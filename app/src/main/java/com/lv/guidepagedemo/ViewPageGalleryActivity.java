package com.lv.guidepagedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lv.guidepagedemo.adapter.GalleryPageAdapter;
import com.lv.guidepagedemo.anim.ZoomOutPageTransformer;

/**
 * User: 吕勇
 * Date: 2016-09-19
 * Time: 13:45
 * Description:
 */
public class ViewPageGalleryActivity extends AppCompatActivity {
    public static void startViewPageGalleryActivity(Activity activity) {
        activity.startActivity(new Intent(activity, ViewPageGalleryActivity.class));
    }
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private View mLlLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_gallery);
        initView();
        setSupportActionBar(mToolbar);
        mViewPager.setAdapter(new GalleryPageAdapter(this));
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                    mLlLayout.invalidate();
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mViewPager.setPageTransformer(false, new ZoomOutPageTransformer());
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mLlLayout =  findViewById(R.id.ll_layout);
    }
}
