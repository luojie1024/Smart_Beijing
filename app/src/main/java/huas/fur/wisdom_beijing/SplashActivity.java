package huas.fur.wisdom_beijing;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity {
          RelativeLayout rlRoot;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_splash);

                    rlRoot=(RelativeLayout) findViewById(R.id.rl_root);
                    starAnim();
          }

          /**
           * 开启动画
           */
          private void starAnim() {
                    //动画集合
                    AnimationSet set = new AnimationSet(false);

                    //旋转动画
                    RotateAnimation rotate = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                    //动画时间1秒
                    rotate.setDuration(1000);
                    //保持动画
                    rotate.setFillAfter(true);

                    //缩放动画
                    ScaleAnimation scanl = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f);
                    //动画时间1秒
                    scanl.setDuration(1000);
                    //保持动画
                    scanl.setFillAfter(true);

                    //渐变动画
                    AlphaAnimation alpha = new AlphaAnimation(0, 1);
                    //动画时间1秒
                    alpha.setDuration(1000);
                    //保持动画
                    alpha.setFillAfter(true);

                    //增加动画集合
                    set.addAnimation(rotate);
                    set.addAnimation(scanl);
                    set.addAnimation(alpha);

                    //设置动画监听，动画结束时跳转到引导页
                    set.setAnimationListener(new Animation.AnimationListener() {
                              @Override
                              public void onAnimationStart(Animation animation) {

                              }

                              @Override
                              public void onAnimationEnd(Animation animation) {
                                        //动画结束跳转到新手引导页
                                        Intent intent = new Intent(SplashActivity.this, GuideAcitivity.class);
                                        startActivity(intent);
                                        finish();
                              }

                              @Override
                              public void onAnimationRepeat(Animation animation) {

                              }
                    });
                    //调用动画
                    rlRoot.startAnimation(set);
          }
}


