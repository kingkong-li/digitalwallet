package com.jingang.digitalwallet.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jingang.digitalwallet.R;
import com.jingang.digitalwallet.base.BaseFragment;

/**
 * @Description:  钱包页面布局
 * @Author:  jingang.Li
 * @CreateTime: 2021/6/29-11:11 PM
 */
public class WalletFragment extends BaseFragment<WalletPresenter> {
    public static WalletFragment newInstance() {
        return new WalletFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.wallet_fragment, container, false);
        TextView totalMoneyTextView=view.findViewById(R.id.tv_total_value);

        RecyclerView recyclerView=view.findViewById(R.id.currency_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyRecyclerViewAdapter( mPresenter.getBalanceList()));
        totalMoneyTextView.setText(new StringBuilder().append("$").
                append(mPresenter.getTotalMoney()).append(" USD").toString());
        return view;
    }

    @Override
    protected WalletPresenter createPresenter() {
        return new WalletPresenter();
    }

    @Override
    public void showLoading() {

    }
}
