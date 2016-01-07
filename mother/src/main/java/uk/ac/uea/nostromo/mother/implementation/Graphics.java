package uk.ac.uea.nostromo.mother.implementation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.maps.MapFragment;

import java.util.List;

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

    public TableRow newButton(String text, Context c, View.OnClickListener onClickListener){

        TableRow tr = new TableRow(context);
        tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        tr.setClickable(true);

        Button btn = new Button(c);

        btn.setText(text);
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundColor(Color.parseColor("#c67623"));
        btn.setClickable(true);
        btn.setTypeface(btn.getTypeface(), Typeface.BOLD);
        btn.setOnClickListener(onClickListener);

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.weight = 1;
        btn.setLayoutParams(layoutParams);

        tr.addView(btn);

        return tr;
    }

    public TableRow newOptionSpinner(String label, List<String> spinnerLabels, int dropDownLayoutResource, AdapterView.OnItemSelectedListener onItemSelectedListener){
        final float scale = context.getResources().getDisplayMetrics().density;
        int dpHeight = (int) (50 * scale + 0.5f);
        int dpWidth = (int) (100 * scale + 0.5f);

        TableRow tr = new TableRow(context);
        TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, dpHeight);
        rowParams.gravity = Gravity.CENTER;
        rowParams.weight = 1;
        rowParams.topMargin = dpHeight / 2;

        tr.setLayoutParams(rowParams);
        tr.setClickable(true);

        TextView tv = new TextView(context);
        tv.setText(label);
        tv.setTextColor(Color.WHITE);
        tv.setBackgroundColor(Color.parseColor("#c67623"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setTextAlignment(GridLayout.TEXT_ALIGNMENT_CENTER);

        TableRow.LayoutParams leftLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, dpHeight);
        leftLayoutParams.weight = 1;
        tv.setLayoutParams(leftLayoutParams);
        tv.setGravity(Gravity.CENTER);


        TableRow.LayoutParams rightLayoutParams = new TableRow.LayoutParams(dpWidth, dpHeight);
        rightLayoutParams.weight = 1;

        Spinner sp = new Spinner(context);
        sp.setBackgroundColor(Color.WHITE);

        if(onItemSelectedListener != null) {
            sp.setOnItemSelectedListener(onItemSelectedListener);
        }

        ArrayAdapter<String> spinnerArrayAdapter; //selected item will look like a spinner set from XML
        spinnerArrayAdapter = new ArrayAdapter<String>(context, dropDownLayoutResource, spinnerLabels);
        spinnerArrayAdapter.setDropDownViewResource(dropDownLayoutResource);

        sp.setAdapter(spinnerArrayAdapter);
        sp.setLayoutParams(rightLayoutParams);
        sp.setMinimumHeight(dpHeight);
        sp.setMinimumWidth(dpWidth);
        sp.setGravity(Gravity.CENTER);

        tr.addView(tv);
        tr.addView(sp);

        return tr;
    }

    public TableRow newOptionText(String label, boolean editable){
        return newOptionText(label, null, editable);
    }

    public TableRow newOptionText(String label, String defaultText, boolean editable){
        final float scale = context.getResources().getDisplayMetrics().density;
        int dpHeight = (int) (50 * scale + 0.5f);
        int dpWidth = (int) (100 * scale + 0.5f);

        TableRow tr = new TableRow(context);
        TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, dpHeight);
        rowParams.gravity = Gravity.CENTER;
        rowParams.weight = 1;
        rowParams.topMargin = dpHeight / 2;

        tr.setLayoutParams(rowParams);
        tr.setClickable(true);

        TextView tv = new TextView(context);
        tv.setText(label);
        tv.setTextColor(Color.WHITE);
        tv.setBackgroundColor(Color.parseColor("#c67623"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setTextAlignment(GridLayout.TEXT_ALIGNMENT_CENTER);
        TableRow.LayoutParams leftLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, dpHeight);
        leftLayoutParams.weight = 1;
        tv.setLayoutParams(leftLayoutParams);
        tv.setGravity(Gravity.CENTER);

        TableRow.LayoutParams rightLayoutParams = new TableRow.LayoutParams(dpWidth, TableRow.LayoutParams.WRAP_CONTENT);
        rightLayoutParams.weight = 1;

        EditText et = new EditText(context);
        et.setBackgroundColor(Color.WHITE);
        et.setWidth(dpWidth);
        et.setLayoutParams(rightLayoutParams);
        et.setMinimumHeight(dpHeight);
        et.setMinimumWidth(dpWidth);

        if(defaultText != null){
            et.setText(defaultText);
        }

        if(!editable){
            et.setFocusable(false);
        }

        tr.addView(tv);
        tr.addView(et);

        return tr;
    }
}
