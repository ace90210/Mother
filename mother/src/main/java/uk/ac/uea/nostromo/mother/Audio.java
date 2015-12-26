package uk.ac.uea.nostromo.mother;

/**
 * Abstract factory designed to control the creation of music, and sound
 * resources.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151204
 */
public interface Audio {
	/**
	 * Create a {@code Music} object.
	 *
	 * @param	file	The filename, on disk, of the audio file to
	 *					load.
	 * @return	A fully constructed {@code Music} object containing the
	 *			requested audio data.
	 * @since	v1.0.0-alpha+20151204
	 */
	Music createMusic(String file);

	/**
	 * Create a {@code Sound} object.
	 *
	 * @param	file	The filename, on disk, of the audio file to
	 *					load.
	 * @return	A fully constructed {@code Sound} object containing the
	 *			requested audio data.
	 * @since	v1.0.0-alpha+20151204
	 */
	Sound createSound(String file);
}
