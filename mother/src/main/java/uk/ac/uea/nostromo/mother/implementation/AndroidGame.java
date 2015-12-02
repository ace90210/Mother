package uk.ac.uea.nostromo.mother.implementation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TableLayout;

import uk.ac.uea.nostromo.mother.Audio;
import uk.ac.uea.nostromo.mother.FileIO;
import uk.ac.uea.nostromo.mother.Game;
import uk.ac.uea.nostromo.mother.Screen;

/**
 * Handles the main game process. This class extends the android activity class and implements the Game interface.
 *
 * This class is responsible for the creation of the main games basic assets and pause, resume and changing of the currently active screen.
 *
 * The following elements are handled in the Class:
 * @see Graphics
 * @see Audio
 * @see FileIO
 * @see Screen
 * @see WakeLock
 */
public abstract class AndroidGame extends Activity implements Game {
    Graphics graphics;
    Audio audio;
    FileIO fileIO;
    Screen screen;
    WakeLock wakeLock;
    TableLayout rootLayout;

	/**
	 * Handles the creation of the main game screen.
	 * Instantiates the main renderer, graphics object (for handling basic graphical operations such as  drawing to the canvas),
	 * the file input and output handler, audio handler, user input handler and the main screen.
	 * Enables the wakelock to disable android locking the screen while the app is active.
	 * @param	savedInstanceState	{@inheritDoc}
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fileIO = new AndroidFileIO(this);
        audio = new AndroidAudio(this);
        graphics = new Graphics(this);
        screen = getInitScreen();
        rootLayout = new TableLayout(this);

		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

	/**
	 * Resumes the main games screen, renderer and applies the wakelock.
	 */
    @Override
    public void onResume() {
        super.onResume();
        wakeLock.acquire();
        screen.resume();
    }

	/**
	 * Pauses the game screen, renderer and releases the wakelock.
	 *
	 * If activity is closing the screen is disposed.
	 */
    @Override
    public void onPause() {
        super.onPause();
        wakeLock.release();
        screen.pause();

        if (isFinishing())
            screen.dispose();
    }

	/**
	 * Get handle to the current file input/output handler.
	 * @return An FileIO object for the games file input/output handler.
	 */
    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

	/**
	 * Get handle to the current graphics object.
	 * @return An Graphics object for the game.
	 */
    @Override
    public Graphics getGraphics() {
        return graphics;
    }

	/**
	 * Get handle to the current audio handler.
	 * @return An Audio object for the games audio handler.
	 */
    @Override
    public Audio getAudio() {
        return audio;
    }

	/**
	 * Sets the games screen to the specified screen.
	 * @param screen The new screen to be applied to the game environment.
	 */
    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }
    
	/**
	 * Get handle to the current games screen.
	 * @return A Screen object for the games screen.
	 */
    public Screen getCurrentScreen() {
        return screen;
    }


    /**
     * Get handle to the current root table layout.
     * @return The root table layout instance.
     */
    @Override
    public TableLayout getRootTableLayout(){
        return rootLayout;
    }
}
