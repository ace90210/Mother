package uk.ac.uea.nostromo.mother.implementation;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

/**
 * Handles the drawing to the Canvas(being displayed on android screen) with multiple elements
 * such as text, shapes and images.
 *
 * @since	v1.0.0-alpha+20151204
 */
public class Graphics {
	/**
	 * @since	v1.0.0-alpha+20151204
	 */
	private static final String TAG = "AndroidGraphics";

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    private Context context;

	/**
	 * @since	v1.0.0-alpha+20151204
	 */
    public Graphics(Context context) {
        this.context = context;
    }

    /**
	 * Returns an ImageView for the specified image in the format specified.
	 * @param resourceId The filename of the image asset to be loaded
	 * @return An ImageView object for the image
	 * @exception RuntimeException
	 * @since	v1.0.0-alpha+20151204
	 */
    public ImageView newImage(int resourceId) {
        ImageView view = new ImageView(context);

        try {
            Resources res = context.getResources();
            Drawable drawable = res.getDrawable(resourceId);
            view.setImageDrawable(drawable);
        }
        catch (Exception ex){
            System.out.print("test " + ex.getMessage());
        }
        return view;
    }
}
