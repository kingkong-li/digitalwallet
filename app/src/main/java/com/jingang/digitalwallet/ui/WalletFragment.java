package com.jingang.digitalwallet.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jingang.digitalwallet.R;
import com.jingang.digitalwallet.bean.DigitalCurrency;
import com.jingang.digitalwallet.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:  钱包页面布局
 * @Author:  jingang.Li
 * @CreateTime: 2021/6/29-11:11 PM
 */
public class WalletFragment extends Fragment {
    private volatile float mTotalValue=0;
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



        HashMap<String,Float> rateMap=new HashMap<>();
        String rateString=FileUtil.getStringFromAssets("live-rates.json");
        JSONObject rateJson=JSONObject.parseObject(rateString);
        JSONArray  rateArray=rateJson.getJSONArray("tiers");
        for(int i=0;i<rateArray.size();i++){
            JSONObject jsonObject=rateArray.getJSONObject(i);
            JSONArray jsonArray=jsonObject.getJSONArray("rates");
            Log.v("JG"," "+jsonArray.getJSONObject(0).getFloatValue("rate"));
            rateMap.put(jsonObject.getString("from_currency"), jsonArray.getJSONObject(0).getFloatValue("rate"));
        }


        HashMap<String,DigitalCurrency> currencyMap=new HashMap<>();
        String jsonData= FileUtil.getStringFromAssets("currencies.json");
        JSONObject curreniesJson=
                JSONObject.parseObject(jsonData);
        JSONArray currencyInfList= curreniesJson.getJSONArray("currencies");
        for(int i=0;i<currencyInfList.size();i++){
            DigitalCurrency currency=new DigitalCurrency();
            currency.coid_id=currencyInfList.getJSONObject(i).getString("coin_id");
            currency.name=currencyInfList.getJSONObject(i).getString("name");
            currency.colorful_image_url=currencyInfList.getJSONObject(i).getString("colorful_image_url");
//            currency.colorful_image_url="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F101%2F70661%2Fadd59b8c29886a2d_1440x900.jpg&refer=http%3A%2F%2Fdik.img.kttpdq.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628477244&t=6334f2a9826053cec571b52027291ce8";
            currencyMap.put(currency.coid_id, currency);

        }

        ArrayList<DigitalCurrency> balanceList=new ArrayList<>();
        String balanceString=FileUtil.getStringFromAssets("wallet-balance.json");
        JSONObject balanceJson=JSONObject.parseObject(balanceString);
        JSONArray  balanceArray=balanceJson.getJSONArray("wallet");
        for(int i=0;i<balanceArray.size();i++){
            DigitalCurrency digitalCurrency=new DigitalCurrency();
            JSONObject jsonObject=balanceArray.getJSONObject(i);
            digitalCurrency.coid_id=jsonObject.getString("currency");
            digitalCurrency.name=currencyMap.get(digitalCurrency.coid_id).name;
            digitalCurrency.colorful_image_url=currencyMap.get(digitalCurrency.coid_id).
                    colorful_image_url;
            digitalCurrency.amount=jsonObject.getIntValue("amount");
            digitalCurrency.rate=rateMap.get(digitalCurrency.coid_id);
            mTotalValue=mTotalValue+digitalCurrency.amount*digitalCurrency.rate;
            balanceList.add(digitalCurrency);
        }
        recyclerView.setAdapter(new MyRecyclerViewAdapter(balanceList));
        totalMoneyTextView.setText(String.valueOf(mTotalValue));
        return view;
    }
}