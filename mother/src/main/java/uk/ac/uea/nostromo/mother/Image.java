package uk.ac.uea.nostromo.mother;

import uk.ac.uea.nostromo.mother.Graphics.ImageFormat;

/**
 * Simplistic image descriptor.
 *
 * @author	Unascribed
 * @author	Alex Melbourne {@literal <a.melbourne@uea.ac.uk>}
 * @version	v1.1.0
 * @since	!_TODO__ [Alex Melbourne <a.melbourne@uea.ac.uk>] : Update this label before new release.
 * @see		Graphics.ImageFormat
 */
public interface Image extends Disposable {
	/**
	 * Get a pixel count representation of the width of the image.
	 *
	 * @return	The width -- in pixels -- of the stored image.
	 */
    public int getWidth();
	/**
	 * Get a pixel count representation of the height of the image.
	 *
	 * @return	The height -- in pixels -- of the stored image.
	 */
    public int getHeight();
	/**
	 * Get the pixel format of the stored image.
	 *
	 * @return	A value representing the bytewise format of the image.
	 */
    public ImageFormat getFormat();
}
