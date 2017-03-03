package com.example.a27459.juejin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.a27459.juejin.base.BaseActivity;
import com.example.a27459.juejin.ui.fragment.FragmentController;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.imagebutton_home)
    ImageButton mImageButton_home;
    @BindView(R.id.imagebutton_explore)
    ImageButton mImageButton_explore;
    @BindView(R.id.imagebutton_notification)
    ImageButton mImageButton_notification;
    @BindView(R.id.imagebutton_profile)
    ImageButton mImageButton_profile;
    @BindView(R.id.linearLayout_container_bottom)
    LinearLayout mLinearLayout_button;

    private ImageButton lastSeletedIcom;
    private FragmentController mFragmentController;



    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mFragmentController = FragmentController.getInstance(this,R.id.framLayout_shouye,true);
        mFragmentController.showFragment(0);

    }

    @Override
    protected void setListener() {
        for (int i = 0; i < mLinearLayout_button.getChildCount(); i++) {
            if (i == 0) {
                setSeletIcon(mImageButton_home);
            }
            final int position = i;
            mLinearLayout_button.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (lastSeletedIcom != null)   lastSeletedIcom.setSelected(false);
                    ImageButton imageButton = (ImageButton) view;
                    mFragmentController.showFragment(position);
                    setSeletIcon(imageButton);
                }
            });
        }
    }



    private void setSeletIcon(ImageButton imageButton) {
        imageButton.setSelected(true);
        lastSeletedIcom = imageButton;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFragmentController.onDestroy();
    }
}
