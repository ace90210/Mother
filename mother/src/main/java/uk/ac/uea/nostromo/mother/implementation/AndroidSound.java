package uk.ac.uea.nostromo.mother.implementation;

import android.media.SoundPool;

import uk.ac.uea.nostromo.mother.Sound;

/**
 * Handles playback of sound effects (should be no longer then 2 seconds).
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;

	/**
	 * Class Constructor
	 *
	 * @param soundPool The sound pool containing all the sound effects.
	 * @param soundId The id for this objects sound effect.
	 */
    public AndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

	/**
	 * Plays full sound effect at the specified volume (from 0.0 - 1.0).
	 * @param	volume	{@inheritDoc}
	 */
    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

	/**
	 * Safely disposes of all sound effects loaded.
	 */
    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}
