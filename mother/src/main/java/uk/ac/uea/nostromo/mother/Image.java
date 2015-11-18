package uk.ac.uea.nostromo.mother;

import uk.ac.uea.nostromo.mother.Graphics.ImageFormat;

/**
 * Simplistic image descriptor.
 *
 * @author	Unascribed
 * @version	v1.0.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 * @see		Graphics.ImageFormat
 */
public interface Image {
	/**
	 * Get a pixel count representation of the width of the image.
	 *
	 * @return	The width -- in pixels -- of the stored image.
	 */
	int getWidth();
	/**
	 * Get a pixel count representation of the height of the image.
	 *
	 * @return	The height -- in pixels -- of the stored image.
	 */
	int getHeight();
	/**
	 * Get the pixel format of the stored image.
	 *
	 * @return	A value representing the bytewise format of the image.
	 */
	ImageFormat getFormat();
	/**
	 * Remove the underlying data being used to store the image.
	 */
	void dispose();
}
