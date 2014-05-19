package org.tmp.shopclient.views;

import org.tmp.shopclient.R;
import org.tmp.shopclient.adapter.MyFragmentPagerAdapter;
import org.tmp.shopclient.fragments.DealedOrderFragment;
import org.tmp.shopclient.fragments.DealingOrderFragment;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.InjectView;

public class OrderManagementActivity extends RoboFragmentActivity implements View.OnClickListener {


    @InjectView(R.id.order_view_pager)
    private ViewPager viewPager ;
    @InjectView(R.id.img_cursor)
    private ImageView cursor ;
    @InjectView(R.id.tv_dealed)
    private TextView tvDealed  ;
    @InjectView(R.id.tv_dealing)
    private TextView tvDealing  ;

    private ArrayList<Fragment> fragments ;
    private int currIndex;//当前页卡编号
    private int bmpW;//横线图片宽度
    private int offset;//图片移动的偏移量

	private FragmentManager fragmentManager ;
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_management_main_layout);
		ActionBar actionBar = this.getActionBar() ;
		actionBar.setTitle(getResources().getString(R.string.orderManagement));

        this.tvDealed.setOnClickListener(this);
        this.tvDealing.setOnClickListener(this);

        initCursor();
        InitViewPager();
	}

    /*
     * 初始化图片的位移像素
     */
    private void initCursor(){
        bmpW = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher).getWidth();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        offset = (screenW/2 - bmpW)/2;
        //imgageview设置平移，使下划线平移到初始位置（平移一个offset）
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        this.cursor.setImageMatrix(matrix);
    }
    /* 
     * 初始化ViewPager 
     */
    private void InitViewPager(){
        viewPager = (ViewPager)findViewById(R.id.order_view_pager);
        fragments = new ArrayList<Fragment>();
        Fragment dealedFragment= new DealedOrderFragment();
        Fragment dealingFragment= new DealingOrderFragment();
        //Fragment secondFragment = TestFragment.newInstance("this is second fragment");
        
        fragments.add(dealedFragment);
        fragments.add(dealingFragment);


        //给ViewPager设置适配器  
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.setCurrentItem(0);//设置当前显示标签页为第一页
        viewPager.setOnPageChangeListener(new MyPageChangeListener());//页面变化时的监听器
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener{
        int one = offset * 2 + bmpW ;
        @Override
        public void onPageScrolled(int i, float v, int i2) {

        }

        @Override
        public void onPageSelected(int i) {

            Animation animation = new TranslateAnimation(currIndex*one,i*one,0,0);
            currIndex  = i ;
            animation.setFillAfter(true);
            animation.setDuration(200);
            cursor.setAnimation(animation);

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_dealed:
                viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
                break;
            case R.id.tv_dealing:
                viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
                break;

            default:
                break;
        }
    }
	
}
