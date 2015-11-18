package uk.ac.uea.nostromo.mother.implementation;

import java.util.List;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import uk.ac.uea.nostromo.mother.Input;

/**
 * Handles Input from the user.
 */
public class AndroidInput implements Input {    
    TouchHandler touchHandler;

	/**
	 * Class Constructor
	 * @param context the current context.
	 * @param view Reference to the current android view.
	 * @param scaleX The horizontal scale to use when converting from display co-ordinates and the views surface size.
	 * @param scaleY The vertical scale to use when converting from display co-ordinates and the views surface size.
	 */
    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        if(VERSION.SDK_INT < 5)
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);        
    }


	/**
	 * Returns If the screen is being touched using the specified pointer (used to track specific fingers).
	 * @param pointer The pointer id for the touch to check again (default/first is 0).
	 * @return True if the touch pointer being checked is still in the touched state.
	 */
    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

	/**
	 * Returns The horizontal(x) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the horizontal(x) position from.
	 * @return the Horizontal(x) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

	/**
	 * Returns The vertical(y) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the vertical(y) position from.
	 * @return The vertical(y) position of the touch for the specified pointer.
	 */
    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }



	/**
	 * Retreive a List of all current touch events.
	 * @return A List of all current touch events.
	 */
    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
    
}
