package uk.ac.uea.nostromo.mother;

/**
 * Simple representation of the screen on which the app is being
 * displayed on.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 */
public abstract class Screen {
	/**
	 * The game that is being rendered to this screen.
	 */
    protected final Game game;

	/**
	 * Construct a new {@code Screen} object.
	 *
	 * @param	game	The game that should be shown on this screen.
	 */
    public Screen(Game game) {
        this.game = game;
    }

	/**
	 * Update the game internally.
	 *
	 * @param	deltaTime	The number of seconds that have passed since
	 *						we last updated.
	 */
    public abstract void update(float deltaTime);

	/**
	 * Draw the game to this screen.
	 *
	 * @param	deltaTime	The number of seconds that have passed since
	 *						our last paint.
	 */
    public abstract void paint(float deltaTime);

	/**
	 * Pause the game.
	 */
    public abstract void pause();

	/**
	 * Resume the game.
	 */
    public abstract void resume();

	/**
	 * Dispose of the internal memory.
	 */
    public abstract void dispose();
    
	/**
	 * Go back.
	 */
    public abstract void backButton();
}
