package com.tpwalk.cjdroid.activity.mine.tools.anim;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.FlingAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.tpwalk.cjdroid.R;
import com.tpwalk.cjdroid.databinding.ActivityAnimaitonBinding;

public class AnimaitonActivity extends AppCompatActivity {

  ActivityAnimaitonBinding activityAnimaitonBinding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    activityAnimaitonBinding = DataBindingUtil.setContentView(this, R.layout.activity_animaiton);

    initListener();
  }

  private void initListener() {

    activityAnimaitonBinding.button.setOnClickListener(v -> Fling());

    activityAnimaitonBinding.button3.setOnClickListener(v -> SpringAnim());
  }


  private void Fling() {
    ImageView imageView = (ImageView) findViewById(R.id.img_simple_fling);
    FlingAnimation flingAnimation = new FlingAnimation(imageView, DynamicAnimation.X);
    flingAnimation.setStartVelocity(500f);
    flingAnimation.setFriction(0.5f);
    flingAnimation.start();
  }


  private void SpringAnim(){
    ImageView imageView = (ImageView) findViewById(R.id.img_simple_fling);

    SpringAnimation springAnimation=new SpringAnimation(imageView,DynamicAnimation.X);
    springAnimation.setStartVelocity(2000);

    SpringForce springForce=new SpringForce();
    springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
    springForce.setStiffness(SpringForce.STIFFNESS_LOW);
    springForce.setFinalPosition(imageView.getX());

    springAnimation.setSpring(springForce);
    springAnimation.start();

  }

}
