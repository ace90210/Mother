package uk.ac.uea.nostromo.mother.implementation;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import uk.ac.uea.nostromo.mother.Audio;
import uk.ac.uea.nostromo.mother.Music;
import uk.ac.uea.nostromo.mother.Sound;

/**
 * Handles to creation of Sound and Music objects as type Audio.
 *
 * requires an instance of the current activity in order to load in reqiured assets using the asset manager.
 *
 * @author unascribed
 * @version V1.0.0
 * @see Audio
 */
public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool soundPool;

	/**
	 * Class Constructor
	 * @param activity The current android activity.
	 */
    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();
        this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
    }

	/**
	 * Creates an instance of a Music object.
	 * @param filename The URL for the audio file to be loaded.
	 * @return A new instance of a music object for the file specified.
	 * @exception IOException
	 */
    @Override
    public Music createMusic(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            return new AndroidMusic(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + filename + "'");
        }
    }

	/**
	 * Creates an instance of a Sound object.
	 * @param filename The URL for the audio file to be loaded.
	 * @return A new instance of a sound object for the file specified.
	 * @exception IOException
	 */
    @Override
    public Sound createSound(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
