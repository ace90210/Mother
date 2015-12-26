package uk.ac.uea.nostromo.mother;

/**
 * Abstraction for the control of large audio files. Music is considered
 * to be of some significant length, and paused/played as desired.
 *
 * @author	Unascribed
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @see		Audio
 * @see		Sound
 * @since	v1.0.0-alpha+20151204
 */
public interface Music extends Disposable {
	/**
	 * Play the contained audio file.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void play();

	/**
	 * Stop the contained audio file.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void stop();

	/**
	 * Pause the contained audio file.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void pause();

	/**
	 * Set the boolean flag to indicate if this audio file should loop.
	 *
	 * @param	looping	The flag representing the new loop status.
	 * @since	v1.0.0-alpha+20151204
	 */
	void setLooping(boolean looping);

	/**
	 * Set the play volume of this audio.
	 *
	 * @param	volume	A value representing the volume of the audio.
	 * @since	v1.0.0-alpha+20151204
	 */
	void setVolume(float volume);

	/**
	 * Gain details about the current play state of this audio file.
	 *
	 * @return	A boolean value indicating if the music is currently
	 *			playing.
	 * @see 	#isStopped()
	 * @since	v1.0.0-alpha+20151204
	 */
	boolean isPlaying();

	/**
	 * Gain details about the current play state of this audio file.
	 *
	 * @return	A boolean value indicating if the music is currently
	 *			stopped.
	 * @see		#isPlaying()
	 * @since	v1.0.0-alpha+20151204
	 */
	boolean isStopped();

	/**
	 * Gain details about the current state of the loop flag.
	 *
	 * @return	A boolean value indicating if the audio will loop.
	 * @since	v1.0.0-alpha+20151204
	 */
	boolean isLooping();

	/**
	 * Remove the internal data storing this audio file.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
	void dispose();

	/**
	 * Move the playback marker to the beginning of the audio.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    void seekBegin();
}