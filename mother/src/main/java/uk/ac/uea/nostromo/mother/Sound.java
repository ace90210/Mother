package uk.ac.uea.nostromo.mother;

/**
 * Simple abstraction of a sound file. Sound files are audio files that
 * are short in length and designed to be played in full.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 * @see		Audio
 * @see		Music
 */
public interface Sound {
	/**
	 * Play the stored sound file.
	 *
	 * @param	volume	A value indicating the volume at which the sound
	 *					file should be played.
	 */
	void play(float volume);

	/**
	 * Remove the data representing the sound file from memory.
	 */
	void dispose();
}
