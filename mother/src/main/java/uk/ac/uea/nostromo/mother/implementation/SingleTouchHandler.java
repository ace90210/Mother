package uk.ac.uea.nostromo.mother.implementation;

import java.util.ArrayList;
import java.util.List;

import android.view.MotionEvent;
import android.view.View;

import uk.ac.uea.nostromo.mother.Pool;
import uk.ac.uea.nostromo.mother.Input.TouchEvent;
import uk.ac.uea.nostromo.mother.Pool.PoolObjectFactory;

/**
 * Helper class for dealing with single touch input.
 */
public class SingleTouchHandler implements TouchHandler {
    boolean isTouched;
    int touchX;
    int touchY;
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
    public SingleTouchHandler(View view, float scaleX, float scaleY) {
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
        synchronized(this) {
            TouchEvent touchEvent = touchEventPool.newObject();
            switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchEvent.type = TouchEvent.TOUCH_DOWN;
                isTouched = true;
                break;
            case MotionEvent.ACTION_MOVE:
                touchEvent.type = TouchEvent.TOUCH_DRAGGED;
                isTouched = true;
                break;
            case MotionEvent.ACTION_CANCEL:                
            case MotionEvent.ACTION_UP:
                touchEvent.type = TouchEvent.TOUCH_UP;
                isTouched = false;
                break;
            }
            
            touchEvent.x = touchX = (int)(event.getX() * scaleX);
            touchEvent.y = touchY = (int)(event.getY() * scaleY);
            touchEventsBuffer.add(touchEvent);                        
            
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
        synchronized(this) {
            if(pointer == 0)
                return isTouched;
            else
                return false;
        }
    }

	/**
	 * Returns The horizontal(x) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the horizontal(x) position from.
	 * @return the Horizontal(x) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchX(int pointer) {
        synchronized(this) {
            return touchX;
        }
    }

	/**
	 * Returns The vertical(y) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the vertical(y) position from.
	 * @return The vertical(y) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchY(int pointer) {
        synchronized(this) {
            return touchY;
        }
    }

	/**
	 * Retreive a List of all current touch events.
	 * @return A List of all current touch events.
	 */
    @Override
    public List<TouchEvent> getTouchEvents() {
        synchronized(this) {     
            int len = touchEvents.size();
            for( int i = 0; i < len; i++ )
                touchEventPool.free(touchEvents.get(i));
            touchEvents.clear();
            touchEvents.addAll(touchEventsBuffer);
            touchEventsBuffer.clear();
            return touchEvents;
        }
    }
}
