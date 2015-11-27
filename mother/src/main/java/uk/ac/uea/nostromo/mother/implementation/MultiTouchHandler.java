package uk.ac.uea.nostromo.mother.implementation;

import java.util.ArrayList;
import java.util.List;

import android.view.MotionEvent;
import android.view.View;

import uk.ac.uea.nostromo.mother.Pool;
import uk.ac.uea.nostromo.mother.Input.TouchEvent;
import uk.ac.uea.nostromo.mother.Pool.PoolObjectFactory;

/**
 * Helper class for dealing with multi touch input.
 */
public class MultiTouchHandler implements TouchHandler {
    private static final int MAX_TOUCHPOINTS = 10;
    
    boolean[] isTouched = new boolean[MAX_TOUCHPOINTS];
    int[] touchX = new int[MAX_TOUCHPOINTS];
    int[] touchY = new int[MAX_TOUCHPOINTS];
    int[] id = new int[MAX_TOUCHPOINTS];
    Pool<TouchEvent> touchEventPool;
    List<TouchEvent> touchEvents = new ArrayList<TouchEvent>();
    List<TouchEvent> touchEventsBuffer = new ArrayList<TouchEvent>();
    float scaleX;
    float scaleY;

	/**
	 * Class Constructor
	 *
	 * @param view Reference to the current android view.
	 * @param scaleX The horizontal scale to use when converting from display co-ordinates and the views surface size.
	 * @param scaleY The vertical scale to use when converting from display co-ordinates and the views surface size.
	 */
    public MultiTouchHandler(View view, float scaleX, float scaleY) {
        PoolObjectFactory<TouchEvent> factory = new PoolObjectFactory<TouchEvent>() {
            @Override
            public TouchEvent createObject() {
                return new TouchEvent();
            }
        };
        touchEventPool = new Pool<TouchEvent>(factory, 100);
        view.setOnTouchListener(this);

        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

	/**
	 * Event run whenever a new touch down event is detected.
	 * @param v Reference to the current android view.
	 * @param event The new motion event.
	 * @return True if the listener has consumed the event, false otherwise.
	 */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        synchronized (this) {
            int action = event.getAction() & MotionEvent.ACTION_MASK;
            int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
            int pointerCount = event.getPointerCount();
            TouchEvent touchEvent;
            for (int i = 0; i < MAX_TOUCHPOINTS; i++) {
                if (i >= pointerCount) {
                    isTouched[i] = false;
                    id[i] = -1;
                    continue;
                }
                int pointerId = event.getPointerId(i);
                if (event.getAction() != MotionEvent.ACTION_MOVE && i != pointerIndex) {
                    // if it's an up/down/cancel/out event, mask the id to see if we should process it for this touch
                    // point
                    continue;
                }
                switch (action) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    touchEvent = touchEventPool.newObject();
                    touchEvent.type = TouchEvent.TOUCH_DOWN;
                    touchEvent.pointer = pointerId;
                    touchEvent.x = touchX[i] = (int) (event.getX(i) * scaleX);
                    touchEvent.y = touchY[i] = (int) (event.getY(i) * scaleY);
                    isTouched[i] = true;
                    id[i] = pointerId;
                    touchEventsBuffer.add(touchEvent);
                    break;

                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP:
                case MotionEvent.ACTION_CANCEL:
                    touchEvent = touchEventPool.newObject();
                    touchEvent.type = TouchEvent.TOUCH_UP;
                    touchEvent.pointer = pointerId;
                    touchEvent.x = touchX[i] = (int) (event.getX(i) * scaleX);
                    touchEvent.y = touchY[i] = (int) (event.getY(i) * scaleY);
                    isTouched[i] = false;
                    id[i] = -1;
                    touchEventsBuffer.add(touchEvent);
                    break;

                case MotionEvent.ACTION_MOVE:
                    touchEvent = touchEventPool.newObject();
                    touchEvent.type = TouchEvent.TOUCH_DRAGGED;
                    touchEvent.pointer = pointerId;
                    touchEvent.x = touchX[i] = (int) (event.getX(i) * scaleX);
                    touchEvent.y = touchY[i] = (int) (event.getY(i) * scaleY);
                    isTouched[i] = true;
                    id[i] = pointerId;
                    touchEventsBuffer.add(touchEvent);
                    break;
                }
            }
            return true;
        }
    }

	/**
	 * Returns If the screen is being touched using the specified pointer (used to track specific fingers).
	 * @param pointer The pointer id for the touch to check again (default/first is 0).
	 * @return True if the touch pointer being checked is still in the touched state.
	 */
    @Override
    public boolean isTouchDown(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if (index < 0 || index >= MAX_TOUCHPOINTS)
                return false;
            else
                return isTouched[index];
        }
    }

	/**
	 * Returns The horizontal(x) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the horizontal(x) position from.
	 * @return the Horizontal(x) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchX(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if (index < 0 || index >= MAX_TOUCHPOINTS)
                return 0;
            else
                return touchX[index];
        }
    }

	/**
	 * Returns The vertical(y) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the vertical(y) position from.
	 * @return The vertical(y) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchY(int pointer) {
        synchronized (this) {
            int index = getIndex(pointer);
            if (index < 0 || index >= MAX_TOUCHPOINTS)
                return 0;
            else
                return touchY[index];
        }
    }

	/**
	 * Retreive a List of all current touch events.
	 * @return A List of all current touch events.
	 */
    @Override
    public List<TouchEvent> getTouchEvents() {
        synchronized (this) {
            int len = touchEvents.size();
            for (int i = 0; i < len; i++)
                touchEventPool.free(touchEvents.get(i));
            touchEvents.clear();
            touchEvents.addAll(touchEventsBuffer);
            touchEventsBuffer.clear();
            return touchEvents;
        }
    }
    
    // returns the index for a given pointerId or -1 if no index.
	/**
	 * Returns the index for a given pointerId or -1 if no index.
	 * @param pointerId The pointer to check for the index on.
	 * @return The index for the given pointerId or -1 if no index.
	 */
    private int getIndex(int pointerId) {
        for (int i = 0; i < MAX_TOUCHPOINTS; i++) {
            if (id[i] == pointerId) {
                return i;
            }
        }
        return -1;
    }
}
