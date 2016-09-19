package com.lv.guidepagedemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lv.guidepagedemo.R;


/**
 * Created by leo on 16/5/7.
 */
public class GalleryPageAdapter extends PagerAdapter {
    private Context context;

    public GalleryPageAdapter( Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return 5;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, null);
        container.addView(view);
        return view;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
