package uk.ac.uea.nostromo.mother.implementation;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import uk.ac.uea.nostromo.mother.Graphics;
import uk.ac.uea.nostromo.mother.Image;

/**
 * Handles the drawing to the Canvas(being displayed on android screen) with multiple elements
 * such as text, shapes and images.
 */
public class AndroidGraphics implements Graphics {
    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect srcRect = new Rect();
    Rect dstRect = new Rect();

	/**
	 * Class Constructor
	 *
	 * @param assets The games current asset manager.
	 * @param frameBuffer The Bitmap frame buffer to use to draw to and used for the width/height.
	 */
    public AndroidGraphics(AssetManager assets, Bitmap frameBuffer) {
        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();
    }

	/**
	 * Opens the desired image from the assets path in the format specified and returns an
	 * AndroidImage in the same image format.
	 * @param fileName The filename of the image asset to be loaded
	 * @param format The image format of the file to be loaded.
	 * @return An AndroidImage object for the image
	 * @exception RuntimeException
	 */
    @Override
    public Image newImage(String fileName, ImageFormat format) {
		Config config;

        if (format == ImageFormat.RGB565)
            config = Config.RGB_565;
        else if (format == ImageFormat.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;
        
        
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = ImageFormat.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = ImageFormat.ARGB4444;
        else
            format = ImageFormat.ARGB8888;

        return new AndroidImage(bitmap, format);
    }

	/**
	 * Clears the screen to the specified color.
	 * @param color the color in RGB image format as a single integer.
	 */
    @Override
    public void clearScreen(int color) {
        canvas.drawRGB((color & 0xff0000) >> 16, (color & 0xff00) >> 8,
                (color & 0xff));
    }


	/**
	 * Draw a fixed length line of the specified color between the two points specified to the screen.
	 * @param x The x(horizontal) position of the beginning of the line.
	 * @param y The y(vertical) position of the beginning of the line.
	 * @param x2 The x(horizontal) position of the end of the line.
	 * @param y2 The y(vertical) position of the end of the line.
	 * @param color The color of the line to be drawn.
	 */
    @Override
    public void drawLine(int x, int y, int x2, int y2, int color) {
        paint.setColor(color);
        canvas.drawLine(x, y, x2, y2, paint);
    }

	/**
	 * Draw a filled rectangle at the specified position and the specified width and height.
	 * @param x The x(horizontal) position of the rectangle.
	 * @param y The y(vertical) position of the rectangle.
	 * @param width The width of the rectangle.
	 * @param height The height of the rectangle.
	 * @param color The color of the rectangle to be drawn.
	 */
    @Override
    public void drawRect(int x, int y, int width, int height, int color) {
        paint.setColor(color);
        paint.setStyle(Style.FILL);
        canvas.drawRect(x, y, x + width - 1, y + height - 1, paint);
    }
    
	/**
	 * Fills entire screen with the specified color in RGBA format.
	 * @param a The alpha level for the new screen color.
	 * @param r The red level for the new screen color.
	 * @param g The green level for the new screen color.
	 * @param b The blue level for the new screen color.
	 */
    @Override
    public void drawARGB(int a, int r, int g, int b) {
        paint.setStyle(Style.FILL);
       canvas.drawARGB(a, r, g, b);
    }
    
	/**
	 * Writes the specified text to the screen in the position specified and using the specified paint format.
	 * @param text The text to be displayed on screen.
	 * @param x The x(horizontal) position of the text to be displayed.
	 * @param y The y(vertical) position of the text to be displayed.
	 * @param paint The Paint format (E.G fill mode) for the text to be displayed).
	 */
    @Override
    public void drawString(String text, int x, int y, Paint paint){
        canvas.drawText(text, x, y, paint);

        
    }
    

	/**
	 * Draw the specified area of an image to the screen.
	 * @param Image The image to be displayed.
	 * @param x The x(horizontal) position of the image.
	 * @param y The y(vertical) position of the image.
	 * @param srcX The x(horizontal) position on the image of the area to be drawn.
	 * @param srcY The y(vertical) position on the image of the area to be drawn.
	 * @param srcWidth The width of the image to be drawn and the width of the image area to be drawn.
	 * @param srcHeight The height of the image to be drawn and the height of the image area to be drawn.
	 */
    public void drawImage(Image Image, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight) {
        srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;
        
        
        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + srcWidth;
        dstRect.bottom = y + srcHeight;

        canvas.drawBitmap(((AndroidImage) Image).bitmap, srcRect, dstRect,
                null);
    }
    
	/**
	 * Draw the specified image to the screen in the specified position.
	 * @param Image The image to be displayed.
	 * @param x The x(horizontal) position of the image.
	 * @param y The y(vertical) position of the image.
	 */
    @Override
    public void drawImage(Image Image, int x, int y) {
        canvas.drawBitmap(((AndroidImage)Image).bitmap, x, y, null);
    }
    
	/**
	 * Draw the specified area of an image to the screen at the specified scale.
	 * @param Image The image to be displayed.
	 * @param x The x(horizontal) position of the image.
	 * @param y The y(vertical) position of the image.
	 * @param width The width of the image to be drawn.
	 * @param height The height of the image to be drawn.
	 * @param srcX The x(horizontal) position on the image of the area to be drawn.
	 * @param srcY The y(vertical) position on the image of the area to be drawn.
	 * @param srcWidth The width of the image area to be drawn.
	 * @param srcHeight The height of the image area to be drawn.
	 */
    public void drawScaledImage(Image Image, int x, int y, int width, int height, int srcX, int srcY, int srcWidth, int srcHeight){
        
        
     srcRect.left = srcX;
        srcRect.top = srcY;
        srcRect.right = srcX + srcWidth;
        srcRect.bottom = srcY + srcHeight;
        
        
        dstRect.left = x;
        dstRect.top = y;
        dstRect.right = x + width;
        dstRect.bottom = y + height;
        
   
        
        canvas.drawBitmap(((AndroidImage) Image).bitmap, srcRect, dstRect, null);
        
    }
   
	/**
	 * Get the current drawing area width.
	 * @return An integer of the current draw area width.
	 */
    @Override
    public int getWidth() {
        return frameBuffer.getWidth();
    }

	/**
	 * Get the current drawing area height.
	 * @return An integer of the current draw area height.
	 */
    @Override
    public int getHeight() {
        return frameBuffer.getHeight();
    }
}
