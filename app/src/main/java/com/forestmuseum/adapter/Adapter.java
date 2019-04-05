package com.forestmuseum.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.forestmuseum.R;

import java.util.List;
import java.util.Map;

/**
 * @author xinzhao
 * @create 2019-04-05 10:47
 */
public class Adapter extends SimpleAdapter {
    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */

    private int[] backimg = new int[]{R.drawable.unit_backimg_00};
    public Adapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=  super.getView(position, convertView, parent);
        view.setBackgroundResource(backimg[0]);
        return view;
    }
}
