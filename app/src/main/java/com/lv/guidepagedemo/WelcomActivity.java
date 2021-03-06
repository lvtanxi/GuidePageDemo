package com.lv.guidepagedemo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * User: 吕勇
 * Date: 2016-08-11
 * Time: 09:08
 * Description:
 */
public class WelcomActivity extends AppCompatActivity {
    private ImageView mIvEntry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeTooabar();
        setContentView(R.layout.activity_welcome);
        initView();
       // StatusBarUtil.setTranslucentForImageView(this,0,mIvEntry);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(mIvEntry, "scaleX", 1f, 1.12f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(mIvEntry, "scaleY", 1f, 1.12f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet
                .setDuration(2000)
                .play(scaleX)
                .with(scaleY);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                MainActivity.startMainActivity(WelcomActivity.this);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animatorSet.start();
    }


    private void initView() {
        mIvEntry = (ImageView) findViewById(R.id.iv_entry);
    }

    private void changeTooabar() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
}
