package com.example.a27459.juejin.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a27459.juejin.R;
import com.example.a27459.juejin.base.BaseFragment;
import com.example.a27459.juejin.ui.adapter.TitlePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 27459 on 2017/3/2.
 */

public class HomeFragmen extends BaseFragment {

    private String[] tabTitles = new String[]{"首页","Android"};
    @BindView(R.id.viewPager_home)
    ViewPager mViewPager;
    @BindView(R.id.tablayout_home)
    TabLayout mTabLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void bindView(View view) {
        ButterKnife.bind(this,view);

    }

    @Override
    protected void processLogic() {
        List<BaseFragment> fragments = new ArrayList<>();
        FragmentHomeShouye fragmentHomeShouye = new FragmentHomeShouye();
        fragments.add(fragmentHomeShouye);
        HomeAndroidFragment fragmentHomeAndroid = new HomeAndroidFragment();
        fragments.add(fragmentHomeAndroid);
        //fragmet嵌套fragment的时候用getChildFragmentManager
        mViewPager.setAdapter(new TitlePagerAdapter(getChildFragmentManager(),fragments,tabTitles));
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_home,menu);
    }
}
