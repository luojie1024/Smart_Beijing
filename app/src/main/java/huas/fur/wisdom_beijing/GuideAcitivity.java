package huas.fur.wisdom_beijing;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * 作者：Jacky
 * 邮箱：550997728@qq.com
 * 时间：2017/1/13 15:23
 */
public class GuideAcitivity extends Activity {

          private ViewPager vpGuide;

          private static final int [] mImageIds=new int[] {R.drawable.guide_1
               ,R.drawable.guide_2,R.drawable.guide_3};
          private ArrayList<ImageView> mImageViewList;

          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    //代码方式去掉标题
                    requestWindowFeature(Window.FEATURE_NO_TITLE);
                    setContentView(R.layout.activity_guide);

                    vpGuide = (ViewPager) findViewById(R.id.vp_guide);
                    //填充数据
                    initViews();
                    //设置适配数据
                    vpGuide.setAdapter(new GuideAdepter());
          }

          /**
           * 初始化界面
           */
          private void initViews(){
                    mImageViewList = new ArrayList<>();
                    for (int i=0;i<mImageIds.length;i++) {
                              ImageView image = new ImageView(this);
                              image.setBackgroundResource(mImageIds[i]);
                              mImageViewList.add(image);
                    }
          }

          class GuideAdepter extends PagerAdapter{

                    @Override
                    public int getCount() {
                              return mImageIds.length;
                    }

                    @Override//初始化界面
                    public Object instantiateItem(ViewGroup container, int position) {
                              container.addView(mImageViewList.get(position));
                              return mImageViewList.get(position);
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                              container.removeView((View) object);
                    }

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                              return view==object;
                    }
          }

}
