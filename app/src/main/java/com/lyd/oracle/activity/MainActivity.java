package com.lyd.oracle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;


import com.lyd.oracle.R;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private List<View> mViews =new ArrayList<View>();


    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mWeixinImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();

    }

    private void initEvents() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0) {

               int currentItem = mViewPager.getCurrentItem();
               resetImg();
               switch (currentItem){
                   case 0:
                       mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
                       break;
                   case 1:
                       mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                       break;
                   case 2:
                       mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                       break;
                   case 3:
                       mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                       break;

                       default:
                           break;
               }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {

        mViewPager=findViewById(R.id.id_viewpager);

        mTabWeixin=findViewById(R.id.id_tab_weixin);
        mTabFrd=findViewById(R.id.id_tab_frd);
        mTabAddress=findViewById(R.id.id_tab_address);
        mTabSetting=findViewById(R.id.id_tab_setting);

        mWeixinImg=findViewById(R.id.id_tab_weixin_img);
        mFrdImg=findViewById(R.id.id_tab_frd_img);
        mAddressImg=findViewById(R.id.id_tab_address_img);
        mSettingImg=findViewById(R.id.id_tab_setting_img);

        LayoutInflater mInflater=LayoutInflater.from(this);
        View tab01= mInflater.inflate(R.layout.tab01,null);
        View tab02= mInflater.inflate(R.layout.tab02,null);
        View tab03= mInflater.inflate(R.layout.tab03,null);
        View tab04= mInflater.inflate(R.layout.tab04,null);

        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);
        mViews.add(tab04);

        mAdapter=new PagerAdapter() {
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

               container.removeView(mViews.get(position));
            }
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view=mViews.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
                return arg0==arg1;
            }
        };

        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {

        resetImg();
        switch (v.getId()){
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                mWeixinImg.setImageResource(R.mipmap.tab_weixin_pressed);
            break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                mFrdImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                mViewPager.setCurrentItem(2);
                mAddressImg.setImageResource(R.mipmap.tab_address_pressed);
                break;
            case R.id.id_tab_setting:
                mViewPager.setCurrentItem(3);
                mSettingImg.setImageResource(R.mipmap.tab_settings_pressed);
                break;

                default:
                    break;
        }
    }

    /*将图片切换为暗色*/
    private void resetImg() {
        mWeixinImg.setImageResource(R.mipmap.tab_weixin_normal);
        mFrdImg.setImageResource(R.mipmap.tab_find_frd_normal);
        mAddressImg.setImageResource(R.mipmap.tab_address_normal);
        mSettingImg.setImageResource(R.mipmap.tab_settings_normal);

    }
}
