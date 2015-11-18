package uk.ac.uea.nostromo.mother;

import android.graphics.Paint;

/**
 * Graphics abstraction.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 */
public interface Graphics {
	/**
	 * Representation of bit-level format of an image file.
	 *
	 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
	 */
	enum ImageFormat {
        ARGB8888, ARGB4444, RGB565
    }

	/**
	 * Construct an {@code Image} object based on a series of inputs.
	 *
	 * @param	fileName	The filename of the image on disk that is to
	 *						be loaded into memory.
	 * @param	format		The format of the image. This determines how
	 *						the image is interpreted.
	 * @return	An {@code Image} object based on the method input.
	 */
	Image newImage(String fileName, ImageFormat format);

	/**
	 * Clear the framebuffer of the current screen to a specific colour.
	 *
	 * @param	color	A representation of some  colour to which the
	 *					framebuffer should be cleared.
	 */
	void clearScreen(int color);

	/**
	 * Draw a line of fixed length, and of given colour between two
	 * points.
	 *
	 * @param	x		The x-coordinate of the first point.
	 * @param	y		The y-coordinate of the first point.
	 * @param	x2		The x-coordinate of the second point.
	 * @param	y2		The y-coordinate of the second point.
	 * @param	color	The colour of the line to be drawn.
	 */
	void drawLine(int x, int y, int x2, int y2, int color);

	/**
	 * Draw a rectangle whose top-left corner can be found at
	 * ({@code x}, {@code y}).
	 *
	 * @param	x		The x-coordinate of the top-left corner of the
	 *					rectangle.
	 * @param	y		The y-coordinate of the top-left corner of the
	 *					rectangle.
	 * @param	width	The width of the rectangle.
	 * @param	height	The height of the rectangle.
	 * @param	color	The desired colour of the rectangle.
	 */
	void drawRect(int x, int y, int width, int height, int color);

	/**
	 * Take an image from a sprite-sheet and draw it to the screen.
	 *
	 * @param	image		The image containing the sprite.
	 * @param	x			The top-left x-coordinate of the destination
	 *						of the sprite.
	 * @param	y			The top-left x-coordinate of the destination
	 *						of the sprite.
	 * @param	srcX		The top-left x-coordinate of the source of
	 *						the sprite on the sprite-sheet.
	 * @param	srcY		The top-left x-coordinate of the source of
	 *						the sprite on the sprite-sheet.
	 * @param	srcWidth	The width of the source of the sprite on the
	 *						sprite-sheet.
	 * @param	srcHeight	The height of the source of the sprite on
	 *						the sprite-sheet.
	 */
	void drawImage(Image image, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight);

	/**
	 * Draw a single image to the screen at ({@code x}, {@code y}).
	 *
	 * @param	Image	The image that is to be drawn.
	 * @param	x		The x-coordinate of the top-left corner of the
	 *					image.
	 * @param	y		The y-coordinate of the top-left corner of the
	 *					image.
	 */
	void drawImage(Image Image, int x, int y);

	/**
	 * Draw a string of text to the screen.
	 *
	 * @param	text	The text that should be drawn to the screen.
	 * @param	x		The x-coordinate of the top-left corner of the
	 *					string.
	 * @param	y		The y-coordinate of the top-left corner of the
	 *					string.
	 * @param	paint	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : What does this paramater do?
	 */
    void drawString(String text, int x, int y, Paint paint);

	/**
	 * Get the width of the screen.
	 *
	 * @return	The width of the screen.
	 */
	int getWidth();

	/**
	 * Get the height of the screen.
	 *
	 * @return The height of the screen.
	 */
	int getHeight();

	/**
	 * !_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : What exactly does this method do?
	 *
	 * @param	i	A poorly name reference to -- presumably -- the
	 *				alpha component of the colour.
	 * @param	j	A poorly name reference to -- presumably -- the red
	 *				component of the colour.
	 * @param	k	A poorly name reference to -- presumably -- the
	 *				green component of the colour.
	 * @param	l	A poorly name reference to -- presumably -- the blue
	 *				component of the colour.
	 */
	void drawARGB(int i, int j, int k, int l);
}
