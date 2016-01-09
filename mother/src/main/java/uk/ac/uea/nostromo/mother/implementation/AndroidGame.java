package uk.ac.uea.nostromo.mother.implementation;

import android.app.Activity;
import android.os.Bundle;
import android.os.PowerManager.WakeLock;
import android.view.WindowManager;
import android.widget.TableLayout;
import uk.ac.uea.nostromo.mother.Audio;
import uk.ac.uea.nostromo.mother.DataIO;
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
 * @since	v1.0.0-alpha+20151204
 */
public abstract class AndroidGame extends Activity implements Game {
    int mainTableLayout;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    Graphics graphics;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    Audio audio;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    FileIO fileIO;

    /**
     * @since	v1.0.0-alpha+20151204
     */
    DataIO dataIO;
	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    Screen screen;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    WakeLock wakeLock;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    protected TableLayout rootLayout;

    /**
	 * Handles the creation of the main game screen.
	 * Instantiates the main renderer, graphics object (for handling basic graphical operations such as  drawing to the canvas),
	 * the file input and output handler, audio handler, user input handler and the main screen.
	 * Enables the wakelock to disable android locking the screen while the app is active.
	 * @param	savedInstanceState	{@inheritDoc}
	 * @since	v1.0.0-alpha+20151204
	 */
    public void onCreate(Bundle savedInstanceState, int mainActivity, int mainTableLayout) {
        super.onCreate(savedInstanceState);

        this.mainTableLayout = mainTableLayout;
        fileIO = new AndroidFileIO(this);
        dataIO = new AndroidDataIO();
        audio = new AndroidAudio(this);
        graphics = new Graphics(this);
        screen = getInitScreen();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(mainActivity);

        rootLayout = (TableLayout) findViewById(mainTableLayout);

        TableLayout screenLayout = screen.getTableLayout();

        rootLayout.addView(screenLayout);
    }

	/**
	 * Resumes the main games screen, renderer and applies the wakelock.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onResume() {
        super.onResume();
        //wakeLock.acquire();
        if(screen != null)
            screen.resume();
    }

	/**
	 * Pauses the game screen, renderer and releases the wakelock.
	 *
	 * If activity is closing the screen is disposed.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void onPause() {
        super.onPause();
        //wakeLock.release();
        if(screen != null)
            screen.pause();

        if (screen != null && isFinishing())
            screen.dispose();
    }

	/**
	 * Get handle to the current file input/output handler.
	 * @return An FileIO object for the games file input/output handler.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    /**
     * Get handle to the current data input/output handler.
     * @return An DataIO object for the games data input/output handler.
     * @since	!_TODO__ {Barry Wright}
     */
    @Override
    public DataIO getDataIO() {
        return dataIO;
    }

	/**
	 * Get handle to the current graphics object.
	 * @return An Graphics object for the game.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public Graphics getGraphics() {
        return graphics;
    }

	/**
	 * Get handle to the current audio handler.
	 * @return An Audio object for the games audio handler.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public Audio getAudio() {
        return audio;
    }

	/**
	 * Sets the games screen to the specified screen.
	 * @param screen The new screen to be applied to the game environment.
	 * @since	v1.0.0-alpha+20151204
	 */
    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        rootLayout.removeAllViews();
        rootLayout = (TableLayout) findViewById(mainTableLayout);

        rootLayout.addView(screen.getTableLayout());

        if(this.screen != null) {
            this.screen.pause();
            this.screen.dispose();
        }

        if(screen != null){
            screen.resume();
            screen.update(0);
        }
        this.screen = screen;
    }
    
	/**
	 * Get handle to the current games screen.
	 * @return A Screen object for the games screen.
	 * @since	v1.0.0-alpha+20151204
	 */
    public Screen getCurrentScreen() {
        return screen;
    }


    /**
     * Get handle to the current root table layout.
     * @return The root table layout instance.
     * @since	v1.0.0-alpha+20151204
     */
    @Override
    public TableLayout getRootTableLayout(){
        return rootLayout;
    }
}
