package uk.ac.uea.nostromo.mother;

import android.widget.TableLayout;

import uk.ac.uea.nostromo.mother.implementation.Graphics;

/**
 * Entry point into the framework.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 */
public interface Game {

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Audio} singleton.
	 */
	Audio getAudio();

	/**
	 * Gain a reference to the {@code FileIO} singleton.
	 *
	 * @return	The {@code FileIO} singleton.
	 */
	FileIO getFileIO();

	/**
	 * Gain a reference to the {@code Graphics} singleton.
	 *
	 * @return	The {@code Graphics} singleton.
	 */
	Graphics getGraphics();

	/**
	 * Set the screen.
	 *
	 * @param	screen	The new screen object on to which we should
	 *					draw.
	 */
	void setScreen(Screen screen);

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Screen} singleton.
	 */
	Screen getCurrentScreen();

	/**
	 * Gain a refernece to the {@code TableLayout} instance.
	 * @return The {@code TableLayout} instance.
	 */
	TableLayout getRootTableLayout();

	/**
	 * Get a reference to the original screen.
	 *
	 * @return	The {@code Screen} singleton.
	 */
	Screen getInitScreen();
	
}
