package uk.ac.uea.nostromo.mother.implementation;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Handles fast rendering on a separate thread which handles the updating and then
 * to the screen in a continues loop until paused or disposed.
 *  *
 * @author unascribed
 * @version V1.0.0
 */
@SuppressLint("ViewConstructor")
public class AndroidFastRenderView extends SurfaceView implements Runnable {
    AndroidGame game;
    Bitmap framebuffer;
    Thread renderThread = null;
    SurfaceHolder holder;
    volatile boolean running = false;
    
	/**
	 * Class Constructor
	 *
	 * @param game An instance of the main game object.
	 * @param framebuffer The Bitmap frame buffer to draw the rendering onto.
	 */
    public AndroidFastRenderView(AndroidGame game, Bitmap framebuffer) {
        super(game);
        this.game = game;
        this.framebuffer = framebuffer;
        this.holder = getHolder();

    }

	/**
	 * Resumes the game loop thread. This resumes both updating and rendering of the game.
	 */
    public void resume() { 
        running = true;
        renderThread = new Thread(this);
        renderThread.start();   

    }      
    
	/**
	 * Runs the game loop. which updates the game, processing the rendering and then copies the render a canvas to display. Loop ends when {@link #pause() pause} is ran.
	 */
    public void run() {
        Rect dstRect = new Rect();
        long startTime = System.nanoTime();
        while(running) {  
            if(!holder.getSurface().isValid())
                continue;           
            

            float deltaTime = (System.nanoTime() - startTime) / 10000000.000f;
            startTime = System.nanoTime();
            
            if (deltaTime > 3.15){
                deltaTime = (float) 3.15;
           }
     

            game.getCurrentScreen().update(deltaTime);
            game.getCurrentScreen().paint(deltaTime);
          
            
            
            Canvas canvas = holder.lockCanvas();
            canvas.getClipBounds(dstRect);
            canvas.drawBitmap(framebuffer, null, dstRect, null);                           
            holder.unlockCanvasAndPost(canvas);
            
            
        }
    }

	/**
	 * Pauses the current game loop.
	 */
    public void pause() {                        
        running = false;                        
        while(true) {
            try {
                renderThread.join();
                break;
            } catch (InterruptedException e) {
                // retry
            }
            
        }
    }     
    
  
}
