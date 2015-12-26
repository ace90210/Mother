package uk.ac.uea.nostromo.mother;

/**
 * Simple abstraction of a sound file. Sound files are audio files that
 * are short in length and designed to be played in full.
 *
 * @author	Unascribed
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @see		Audio
 * @see		Music
 * @since	v1.0.0-alpha+20151204
 */
public interface Sound extends Disposable {
	/**
	 * Play the stored sound file.
	 *
	 * @param	volume	A value indicating the volume at which the sound
	 *					file should be played.
	 * @since	v1.0.0-alpha+20151204
	 */
	void play(float volume);

	/**
	 * Remove the data representing the sound file from memory.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void dispose();
}
