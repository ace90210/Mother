package uk.ac.uea.nostromo.mother;

/**
 * Abstraction for the control of large audio files. Music is considered
 * to be of some significant length, and paused/played as desired.
 *
 * @author	Unascribed
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 * @see		Audio
 * @see		Sound
 */
public interface Music extends Disposable {
	/**
	 * Play the contained audio file.
	 */
	void play();

	/**
	 * Stop the contained audio file.
	 */
	void stop();

	/**
	 * Pause the contained audio file.
	 */
	void pause();

	/**
	 * Set the boolean flag to indicate if this audio file should loop.
	 *
	 * @param	looping	The flag representing the new loop status.
	 */
	void setLooping(boolean looping);

	/**
	 * Set the play volume of this audio.
	 *
	 * @param	volume	A value representing the volume of the audio.
	 */
	void setVolume(float volume);

	/**
	 * Gain details about the current play state of this audio file.
	 *
	 * @return	A boolean value indicating if the music is currently
	 *			playing.
	 * @see 	#isStopped()
	 */
	boolean isPlaying();

	/**
	 * Gain details about the current play state of this audio file.
	 *
	 * @return	A boolean value indicating if the music is currently
	 *			stopped.
	 * @see		#isPlaying()
	 */
	boolean isStopped();

	/**
	 * Gain details about the current state of the loop flag.
	 *
	 * @return	A boolean value indicating if the audio will loop.
	 */
	boolean isLooping();

	/**
	 * Remove the internal data storing this audio file.
	 */
	void dispose();

	/**
	 * Move the playback marker to the beginning of the audio.
	 */
    void seekBegin();
}