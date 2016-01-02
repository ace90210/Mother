package uk.ac.uea.nostromo.mother.implementation;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;

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

    public TextView newTextView(String defaultContent, boolean multiLine, boolean fillWidth, boolean fillHeight){
        TextView tv = new TextView(context);
        tv.setText(defaultContent);
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(
                fillWidth ? LinearLayout.LayoutParams.MATCH_PARENT : LinearLayout.LayoutParams.WRAP_CONTENT,
                fillHeight ? LinearLayout.LayoutParams.MATCH_PARENT : LinearLayout.LayoutParams.MATCH_PARENT
        );

        if(!multiLine){
            tv.setMaxLines(1);
        }
        tv.setLayoutParams(layout);
        return tv;
    }

    public LinearLayout newLinearLayout(){
        LinearLayout ll = new LinearLayout(context);
        ll.setId(View.generateViewId());
        return ll;
    }

    public LinearLayout newLinearLayout(int width, int height){
        LinearLayout ll = newLinearLayout();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);

        ll.setLayoutParams(lp);

        return ll;
    }

    public MapFragment newMap(Activity act, int containerID){
        MapFragment mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = act.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerID, mMapFragment);
        fragmentTransaction.commit();
        return mMapFragment;
    }
}
