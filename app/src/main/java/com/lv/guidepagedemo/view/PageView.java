package com.lv.guidepagedemo.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;

public class PageView extends ViewPager {

	private float mTrans;
	private float mScale;
	private static final float SCALE_MAX = 0.5f;
	Map<Integer, View> mViewMap = new HashMap<>();

	public PageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setPositionView(int key, View value) {
		mViewMap.put(key, value);
	}

	public View getPositionView(int postion) {
		return mViewMap.get(postion);
	}

	View leftView = null;
	View rightView = null;

	@Override
	protected void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
//		leftView = mViewMap.get(position);
//		rightView = mViewMap.get(position + 1);
//		dealAnimate(leftView, rightView, positionOffset, positionOffsetPixels);
		super.onPageScrolled(position, positionOffset, positionOffsetPixels);
	}

	private void dealAnimate(View left, View right, float effectOffset,
			int positionOffsetPixels) {
		if (right != null) {
			mScale = (1 - SCALE_MAX) * effectOffset + SCALE_MAX;
			mTrans = -getWidth() - getPageMargin() + positionOffsetPixels;
			ViewHelper.setScaleX(right, mScale);
			ViewHelper.setScaleY(right, mScale);
			ViewHelper.setTranslationX(right, mTrans);
		}
		if (left != null) {
			left.bringToFront();
		}
	}
}
