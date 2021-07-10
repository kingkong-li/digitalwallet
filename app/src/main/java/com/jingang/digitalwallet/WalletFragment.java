package com.jingang.digitalwallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jingang.digitalwallet.bean.DigitalCurrency;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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

        RecyclerView recyclerView=view.findViewById(R.id.currency_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<DigitalCurrency> digitalCurrencyList=new ArrayList<>();
        DigitalCurrency currency=new DigitalCurrency();
        currency.coid_id="BTC";
        currency.name="btc";
        currency.amount=100;
        currency.rate=1000;
        currency.colorful_image_url="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F101%2F70661%2Fadd59b8c29886a2d_1440x900.jpg&refer=http%3A%2F%2Fdik.img.kttpdq.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628477244&t=6334f2a9826053cec571b52027291ce8";
        digitalCurrencyList.add(currency);
        DigitalCurrency currency1=new DigitalCurrency();
        currency1.coid_id="ETC";
        currency1.name="etc";
        currency1.amount=1000;
        currency1.rate=10;
        currency1.colorful_image_url="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F101%2F70661%2Fadd59b8c29886a2d_1440x900.jpg&refer=http%3A%2F%2Fdik.img.kttpdq.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628477244&t=6334f2a9826053cec571b52027291ce8";
        digitalCurrencyList.add(currency1);
        recyclerView.setAdapter(new MyRecyclerViewAdapter(digitalCurrencyList));
        return view;
    }
}
