package uk.ac.uea.nostromo.mother.implementation;

import java.io.IOException;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

import uk.ac.uea.nostromo.mother.Music;

/**
 * Handles the playback of music.
 *
 * @since	v1.0.0-alpha+20151204
 */
public class AndroidMusic implements Music, OnCompletionListener, OnSeekCompleteListener, OnPreparedListener, OnVideoSizeChangedListener {
	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    MediaPlayer mediaPlayer;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    boolean isPrepared = false;

	/**
	 * Class Constructor
	 *
	 * @param assetDescriptor An asset file descriptor describing the music file to be loaded and played.
	 * @exception RuntimeException
	 * @since	v1.0.0-alpha+20151204
	 */
    public AndroidMusic(AssetFileDescriptor assetDescriptor) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
                    assetDescriptor.getStartOffset(),
                    assetDescriptor.getLength());
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            
        } catch (Exception e) {
            throw new RuntimeException("Couldn't load music");
        }
    }

	/**
	 * Stops playback and disposes the music object safely.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void dispose() {
    
         if (this.mediaPlayer.isPlaying()){
               this.mediaPlayer.stop();
                }
        this.mediaPlayer.release();
    }

	/**
	 * Gets wether the current music is looping continuously.
	 * @return True is music is currently looping.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public boolean isLooping() {
        return mediaPlayer.isLooping();
    }

	/**
	 * Gets wether the current music is playing.
	 * @return True is music is currently playing.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public boolean isPlaying() {
        return this.mediaPlayer.isPlaying();
    }

	/**
	 * Gets wether music is stopped.
	 * @return True is music is stopped.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public boolean isStopped() {
        return !isPrepared;
    }

	/**
	 * If music is playing, pauses the music.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void pause() {
        if (this.mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    
    
	/**
	 * Begins playback of music, if music is already playing does nothing.
	 *
	 * @exception IllegalStateException
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void play() {
        if (this.mediaPlayer.isPlaying())
            return;

        try {
            synchronized (this) {
                if (!isPrepared)
                    mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Sets the state of the music to to the specified looping state.
	 * @param isLooping the desired looping state.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void setLooping(boolean isLooping) {
        mediaPlayer.setLooping(isLooping);
    }

	/**
	 * Sets the volume level for the music.
	 * @param volume The volume level to set the music too (from 0.0 - 1.0).
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void setVolume(float volume) {
        mediaPlayer.setVolume(volume, volume);
    }

	/**
	 * Stops music playback(if running).
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
	public void stop() {
		boolean isPlaying;

		isPlaying = mediaPlayer.isPlaying();
		if (isPlaying) {
			mediaPlayer.stop();

			synchronized (this) {
				isPrepared = false;
			}
		}
	}

	/**
	 * Event thrown on completion of music playback.
	 * @param player the media player that completed its playback.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onCompletion(MediaPlayer player) {
        synchronized (this) {
            isPrepared = false;
        }
    }

	/**
	 * Sets the current playback position of the music to the beginning.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void seekBegin() {
        mediaPlayer.seekTo(0);
        
    }


	/**
	 * Event thrown when music is being prepared for playback.
	 * @param player the meida player that is starting music playback.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onPrepared(MediaPlayer player) {
        // TODO Auto-generated method stub
         synchronized (this) {
               isPrepared = true;
            }
        
    }

	/**
	 * NOTE: Stud method not implemented.
	 * Event thrown on completion of a seek event.
	 * @param player The media player that completed the seek event.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onSeekComplete(MediaPlayer player) {
        // TODO Auto-generated method stub
        
    }

	/**
	 * NOTE: Stud method not implemented.
	 * Event thrown on resize of the video player.
	 * @param player The media player that is resizing its video dimensions.
	 * @param width The new width of the video player.
	 * @param height The new height of the video player.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onVideoSizeChanged(MediaPlayer player, int width, int height) {
        // TODO Auto-generated method stub
        
    }
}
