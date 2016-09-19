package com.lv.guidepagedemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.lv.guidepagedemo.adapter.LBasePagerAdapter;
import com.lv.guidepagedemo.anim.AccordionTransformer;
import com.lv.guidepagedemo.anim.CubeTransformer;
import com.lv.guidepagedemo.anim.DefaultTransformer;
import com.lv.guidepagedemo.anim.DepthPageTransformer;
import com.lv.guidepagedemo.anim.InRightDownTransformer;
import com.lv.guidepagedemo.anim.InRightUpTransformer;
import com.lv.guidepagedemo.anim.RotateTransformer;
import com.lv.guidepagedemo.anim.ZoomOutPageTransformer;
import com.lv.guidepagedemo.view.CirclePageIndicator;
import com.lv.guidepagedemo.view.PageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static void startMainActivity(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    private PageView mGuidePager;
    private CirclePageIndicator mGuidePageindicator;
    private LBasePagerAdapter<Integer> mPagerAdapter;
    private RelativeLayout.LayoutParams mParams;
    private Spinner mSpinner;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mGuidePager = (PageView) findViewById(R.id.guide_pager);
        mGuidePageindicator = (CirclePageIndicator) findViewById(R.id.guide_pageindicator);
        mParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mPagerAdapter = new LBasePagerAdapter<Integer>() {
            @Override
            public View newView(Integer integer) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(integer);
                imageView.setLayoutParams(mParams);
                return imageView;
            }
        };
        mPagerAdapter.bindData(R.mipmap.tut_page_1_background, R.mipmap.tut_page_1_front, R.mipmap.tut_page_4_background, R.mipmap.tut_page_4_foreground, R.mipmap.tut_page_3_foreground);
        mGuidePager.setAdapter(mPagerAdapter);
        mGuidePageindicator.setViewPager(mGuidePager);
        mSpinner = (Spinner) findViewById(R.id.guide_spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setPageTransformer(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mView = findViewById(R.id.tonew);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int max = 20;
                int min = 10;
                Random random = new Random();
                int s = random.nextInt(max) % (max - min + 1) + min;
                if (s % 2 == 0) {
                    ViewPageGalleryActivity.startViewPageGalleryActivity(MainActivity.this);
                    return;
                }
                ViewPagerCards.startViewPagerCards(MainActivity.this);
            }
        });
    }

    public void setPageTransformer(int position) {
        switch (position) {
            case 0:
                mGuidePager.setPageTransformer(true, new DefaultTransformer());
                break;
            case 1:
                mGuidePager.setPageTransformer(true, new DepthPageTransformer());
                break;
            case 2:
                mGuidePager.setPageTransformer(true, new CubeTransformer());
                break;
            case 3:
                mGuidePager.setPageTransformer(true, new RotateTransformer());
                break;
            case 4:
                mGuidePager.setPageTransformer(true, new AccordionTransformer());
                break;
            case 5:
                mGuidePager.setPageTransformer(true, new InRightUpTransformer());
                break;
            case 6:
                mGuidePager.setPageTransformer(true, new InRightDownTransformer());
                break;
            case 7:
                mGuidePager.setPageTransformer(true, new ZoomOutPageTransformer());
                break;
            default:
                break;
        }
    }
}
