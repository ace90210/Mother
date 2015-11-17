package uk.ac.uea.nostromo.mother;

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
	public Audio getAudio();

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Audio} singleton.
	 */
    public Input getInput();

	/**
	 * Gain a reference to the {@code FileIO} singleton.
	 *
	 * @return	The {@code FileIO} singleton.
	 */
    public FileIO getFileIO();

	/**
	 * Gain a reference to the {@code Graphics} singleton.
	 *
	 * @return	The {@code Graphics} singleton.
	 */
    public Graphics getGraphics();

	/**
	 * Set the screen.
	 *
	 * @param	screen	The new screen object on to which we should
	 *					draw.
	 */
    public void setScreen(Screen screen);

	/**
	 * Gain a reference to the {@code Audio} singleton.
	 *
	 * @return	The {@code Screen} singleton.
	 */
    public Screen getCurrentScreen();

	/**
	 * Get a reference to the original screen.
	 *
	 * @return	The {@code Screen} singleton.
	 */
    public Screen getInitScreen();
	
}
