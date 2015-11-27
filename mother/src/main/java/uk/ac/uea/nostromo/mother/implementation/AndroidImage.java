package uk.ac.uea.nostromo.mother.implementation;

import android.graphics.Bitmap;

import uk.ac.uea.nostromo.mother.Image;
import uk.ac.uea.nostromo.mother.Graphics.ImageFormat;

/**
 * Represents a bitmap image with additional format details.
 */
public class AndroidImage implements Image {
    Bitmap bitmap;
    ImageFormat format;
    
	/**
	 * Class Constructor
	 *
	 * @param bitmap The bitmap image.
	 * @param format The Image format for the bitmap image.
	 */
    public AndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

	/**
	 * Gets the width of the bitmap image.
	 * @return the width for the bitmap image.
	 */
    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

	/**
	 * Gets the height of the bitmap image.
	 * @return the height for the bitmap image.
	 */
    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

	/**
	 * Gets the image format of the bitmap.
	 * @return the ImageFormat for the bitmap.
	 */
    @Override
    public ImageFormat getFormat() {
        return format;
    }

	/**
	 * Disposes of the bitmap in memory.
	 */
    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}
