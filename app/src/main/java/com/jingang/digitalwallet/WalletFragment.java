package com.jingang.digitalwallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @Description:  钱包页面布局
 * @Author:  jingang.Li
 * @CreateTime: 2021/6/29-11:11 PM
 */
public class WalletFragment extends Fragment {
    public static WalletFragment newInstance() {
        return new WalletFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.wallet_fragment, container, false);
        return view;
    }
}
