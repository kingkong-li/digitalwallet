package com.jingang.digitalwallet.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.jingang.digitalwallet.R;
import com.jingang.digitalwallet.base.BaseActivity;
import com.jingang.digitalwallet.base.BasePresenter;


public class MainActivity extends BaseActivity {

        private TabLayout mTabLayout;
        private Fragment[] mFragmensts;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mFragmensts = DataGenerator.getFragments(null);
            initView();

        }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initView() {
            mTabLayout = (TabLayout) findViewById(R.id.bottom_tab_layout);

            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    onTabItemSelected(tab.getPosition());

                    //改变Tab 状态
                    for(int i=0;i< mTabLayout.getTabCount();i++){
                        if(i == tab.getPosition()){
                            mTabLayout.getTabAt(i).
                                    setIcon(getResources().getDrawable(DataGenerator.mTabResPressed[i]));
                        }else{
                            mTabLayout.getTabAt(i).
                                    setIcon(getResources().getDrawable(DataGenerator.mTabRes[i]));
                        }
                    }

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

            mTabLayout.addTab(mTabLayout.newTab().
                    setIcon(getResources().getDrawable(R.drawable.wallet)).
                    setText(DataGenerator.mTabTitle[0]));
            mTabLayout.addTab(mTabLayout.newTab().
                    setIcon(getResources().getDrawable(R.drawable.defi)).
                    setText(DataGenerator.mTabTitle[1]));

        }

        private void onTabItemSelected(int position){
            Fragment fragment = null;
            switch (position){
                case 0:
                    fragment = mFragmensts[0];
                    break;
                case 1:
                    fragment = mFragmensts[1];
                    break;

            }
            if(fragment!=null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragment).commit();
            }
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}