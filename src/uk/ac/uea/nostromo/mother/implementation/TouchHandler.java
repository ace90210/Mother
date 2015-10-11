package uk.ac.uea.nostromo.mother.implementation;

import java.util.List;

import android.view.View.OnTouchListener;

import uk.ac.uea.nostromo.mother.Input.TouchEvent;

/**
 * Interface representing a touch handler which supports checking touches for a touch pointer, getting the co-ordinates of a touch pointer and getting a list of all touch events.
 */
public interface TouchHandler extends OnTouchListener {

	/**
	 * Return if the touch point is in the state touch down for the specified pointer (used to track specific fingers).
	 * @param pointer The pointer id for the touch to check again (default/first is 0).
	 * @return True if the touch pointer being checked is still in the touched state.
	 */
    public boolean isTouchDown(int pointer);
    
	/**
	 * Return The horizontal(x) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the horizontal(x) position from.
	 * @return The horizontal(x) position of the touch for the specified pointer.
	 */
    public int getTouchX(int pointer);
    
	/**
	 * Return The vertical(y) touch position for the specified pointer.
	 * @param pointer The touch pointer to retrieve the vertical(y) position from.
	 * @return The vertical(y) position of the touch for the specified pointer.
	 */
    public int getTouchY(int pointer);
    
	/**
	 * Retreive a List of all current touch events.
	 * @return A List of all current touch events.
	 */
    public List<TouchEvent> getTouchEvents();
}
