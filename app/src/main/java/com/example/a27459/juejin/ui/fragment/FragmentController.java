package com.example.a27459.juejin.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by 27459 on 2017/3/2.
 */

public class FragmentController {
    private int contaninerId;
    private FragmentManager fm;
    private ArrayList<Fragment> mFragments;
    private static boolean isReload;
    private static FragmentController fragmentController;

    public static FragmentController getInstance(FragmentActivity activity, int contaninerId, boolean isReload){
        FragmentController.isReload = isReload;
        if (fragmentController == null) {
            fragmentController = new FragmentController(activity,contaninerId);
        }
        return fragmentController;
    }

    public FragmentController(FragmentActivity activity, int contaninerId) {
        this.contaninerId = contaninerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        if (isReload) {
            mFragments.add(new HomeFragmen());
            mFragments.add(new ExploreFragment());
            mFragments.add(new NotificationFragment());
            mFragments.add(new ProfileFragment());

            FragmentTransaction ft = fm.beginTransaction();
            for (int i = 0; i < mFragments.size(); i++) {
                ft.add(contaninerId,mFragments.get(i),""+i);
            }
            ft.commit();

        }else{
            for (int i = 0; i < 4; i++) {
                mFragments.add(fm.findFragmentByTag(""+i));
            }
        }
    }

    public void showFragment(int position){
        hideFraments();
        Fragment fragment = mFragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commitAllowingStateLoss();
    }

    private void hideFraments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : mFragments
             ) {
            if (fragment != null) {
                ft.hide(fragment);
            }

        }
        ft.commitAllowingStateLoss();
    }

    public Fragment getFragment(int position){
        return mFragments.get(position);
    }

    public static void onDestroy(){
        fragmentController = null;
    }

}
