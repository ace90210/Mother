package uk.ac.uea.nostromo.mother;

import android.widget.TableLayout;

import uk.ac.uea.nostromo.mother.implementation.Graphics;

/**
 * Entry point into the framework.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151204
 */
public interface Game {

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Audio} singleton.
	 * @since	v1.0.0-alpha+20151204
	 */
	Audio getAudio();

	/**
	 * Gain a reference to the {@code FileIO} singleton.
	 *
	 * @return	The {@code FileIO} singleton.
	 * @since	v1.0.0-alpha+20151204
	 */
	FileIO getFileIO();

	/**
	 * Gain a reference to the {@code DataIO} singleton.
	 *
	 * @return	The {@code DataIO} singleton.
	 * @since	!_TODO__ {Barry Wright}
	 */
	DataIO getDataIO();

	/**
	 * Gain a reference to the {@code Graphics} singleton.
	 *
	 * @return	The {@code Graphics} singleton.
	 * @since	v1.0.0-alpha+20151204
	 */
	Graphics getGraphics();

	/**
	 * Set the screen.
	 *
	 * @param	screen	The new screen object on to which we should
	 *					draw.
	 * @since	v1.0.0-alpha+20151204
	 */
	void setScreen(Screen screen);

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Screen} singleton.
	 * @since	v1.0.0-alpha+20151204
	 */
	Screen getCurrentScreen();

	/**
	 * Gain a refernece to the {@code TableLayout} instance.
	 * @return The {@code TableLayout} instance.
	 * @since	v1.0.0-alpha+20151204
	 */
	TableLayout getRootTableLayout();

	/**
	 * Get a reference to the original screen.
	 *
	 * @return	The {@code Screen} singleton.
	 * @since	v1.0.0-alpha+20151204
	 */
	Screen getInitScreen();
	
}
