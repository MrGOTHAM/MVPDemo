package com.example.mvp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

/**
 * Created by 安 on 2021/6/11.
 * viewPager 适配器
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    ArrayList<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, ArrayList<Fragment> fragments) {
        super(fragmentManager, lifecycle);
        this.mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return mFragments.size();
    }
}
