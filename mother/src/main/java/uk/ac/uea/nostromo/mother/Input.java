package uk.ac.uea.nostromo.mother;

import java.util.List;

/**
 * Input tracking.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 */
public interface Input {
    
	/**
	 * Input event descriptor.
	 *
	 * @author	Unascribed
	 * @version	v1.0.0
	 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
	 */
	class TouchEvent {
		/**
		 * Integer value indicating a tap event.
		 */
        public static final int TOUCH_DOWN = 0;
		/**
		 * Integer value indicating a release event.
		 */
        public static final int TOUCH_UP = 1;
		/**
		 * Integer value indicating a dragging event.
		 */
        public static final int TOUCH_DRAGGED = 2;
		/**
		 * Integer value indicating a hold event.
		 */
        public static final int TOUCH_HOLD = 3;

		/**
		 * The type of this event.
		 *
		 * @see	#TOUCH_DOWN
		 * @see	#TOUCH_DRAGGED
		 * @see	#TOUCH_HOLD
		 * @see	#TOUCH_UP
		 */
        public int type;
		/**
		 * The point at which the event took place.
		 */
        public int x, y;
		/**
		 * A index for the current event.
		 */
        public int pointer;


    }

	/**
	 * Test a given touch event to see if it is a tap event.
	 *
	 * @param	pointer	The index of the touch event that is being
	 *					tested.
	 * @return	A boolean value indicating if the presented even was a
	 *			tap event.
	 * @see	TouchEvent
	 */
	boolean isTouchDown(int pointer);

	/**
	 * Get the {@code x} attribute for a given {@code TouchEvent}.
	 *
	 * @param	pointer	The index of the touch event that is being
	 *					tested.
	 * @see	TouchEvent#x
	 */
	int getTouchX(int pointer);

	/**
	 * Get the {@code y} attribute for a given {@code TouchEvent}.
	 *
	 * @param	pointer	The index of the touch event that is being
	 *					tested.
	 * @see	TouchEvent#y
	 */
	int getTouchY(int pointer);

	/**
	 * Get the currently buffered events that haven't yet been
	 * processed.
	 *
	 * @return	A list structure containing all unprocessed events.
	 */
	List<TouchEvent> getTouchEvents();
}
