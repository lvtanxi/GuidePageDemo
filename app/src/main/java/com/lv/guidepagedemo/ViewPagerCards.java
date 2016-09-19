package com.lv.guidepagedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.lv.guidepagedemo.adapter.CardPagerAdapter;
import com.lv.guidepagedemo.anim.ShadowTransformer;

/**
 * User: 吕勇
 * Date: 2016-09-19
 * Time: 14:07
 * Description:
 */
public class ViewPagerCards extends AppCompatActivity {
    public static void startViewPagerCards(Activity activity) {
        activity.startActivity(new Intent(activity, ViewPagerCards.class));
    }
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_cards);
        initView();
        CardPagerAdapter cardPagerAdapter = new CardPagerAdapter();
        mViewPager.setAdapter(cardPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setPageTransformer(false, new ShadowTransformer(mViewPager,cardPagerAdapter));
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }
}
