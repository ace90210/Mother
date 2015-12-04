package uk.ac.uea.nostromo.mother;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

/**
 * Simple representation of the screen on which the app is being
 * displayed on.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	v1.0.0-alpha+20151204
 */
public abstract class Screen {
    protected TableLayout screenLayout;

	/**
	 * The game that is being rendered to this screen.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    protected final Game game;
    protected final Context context;

	/**
	 * Construct a new {@code Screen} object.
	 *
	 * @param	game	The game that should be shown on this screen.
	 * @since	v1.0.0-alpha+20151204
	 */
    public Screen( Game game, Context context) {
        this.game = game;
        this.context = context;
        if(screenLayout == null)
            screenLayout = new TableLayout(context);
        else
            screenLayout.removeAllViews();
    }

	/**
	 * Update the game internally.
	 *
	 * @param	deltaTime	The number of seconds that have passed since
	 *						we last updated.
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void update(float deltaTime);

	/**
	 * Draw the game to this screen.
	 *
	 * @param	deltaTime	The number of seconds that have passed since
	 *						our last paint.
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void paint(float deltaTime);

	/**
	 * Pause the game.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void pause();

	/**
	 * Resume the game.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void resume();

	/**
	 * Dispose of the internal memory.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void dispose();
    
	/**
	 * Go back.
	 *
	 * @since	v1.0.0-alpha+20151204
	 */
    public abstract void backButton();

    public TableLayout getTableLayout(){
        return screenLayout;
    }
}
