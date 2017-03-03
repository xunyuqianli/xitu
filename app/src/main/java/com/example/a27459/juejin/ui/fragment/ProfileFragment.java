package com.example.a27459.juejin.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a27459.juejin.R;
import com.example.a27459.juejin.base.BaseFragment;
import com.example.a27459.juejin.ui.activity.SignInActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 27459 on 2017/3/2.
 */

public class ProfileFragment extends BaseFragment {
    @BindView(R.id.button_signIn)
    Button button_signIn;
    @BindView(R.id.button_signUp)
    Button button_signUp;
    @Override
    protected View loadViewLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_profile,container,false);
    }

    @Override
    protected void setListener() {
        button_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void bindView(View view) {
        ButterKnife.bind(this,view);

    }

    @Override
    protected void processLogic() {

    }
}
