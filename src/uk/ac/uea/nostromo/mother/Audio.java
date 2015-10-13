package uk.ac.uea.nostromo.mother;

/**
 * Abstract factory designed to control the creation of music, and sound
 * resources.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 */
public interface Audio {
	/**
	 * Create a {@code Music} object.
	 *
	 * @param	file	The filename, on disk, of the audio file to
	 *					load.
	 * @return	A fully constructed {@code Music} object containing the
	 *			requested audio data.
	 */
    public Music createMusic(String file);

	/**
	 * Create a {@code Sound} object.
	 *
	 * @param	file	The filename, on disk, of the audio file to
	 *					load.
	 * @return	A fully constructed {@code Sound} object containing the
	 *			requested audio data.
	 */
    public Sound createSound(String file);
}
