package com.example.mvp.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.example.mvp.Adapter.ViewPagerAdapter;
import com.example.mvp.Fragment.FragmentOne;
import com.example.mvp.Fragment.FragmentThree;
import com.example.mvp.Fragment.FragmentTwo;
import com.example.mvp.R;
import java.util.ArrayList;

public class ViewPagerActivity extends BaseActivity {

    ViewPager2 mViewPager;
    ArrayList<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewPager = findViewById(R.id.view_pager);
        initData();
        initView();
//        mViewPager.setMinimumHeight(getScreenHeight()/2);
//        mViewPager.setMinimumWidth(getScreenWidth()/2);
    }

    private void initData() {

    }

    private void initView(){
        FragmentOne fragmentOne = new FragmentOne();
        FragmentTwo fragmentTwo = new FragmentTwo();
        FragmentThree fragmentThree = new FragmentThree();
        mFragmentList.add(fragmentOne);
        mFragmentList.add(fragmentTwo);
        mFragmentList.add(fragmentThree);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle(), mFragmentList);
        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }
}