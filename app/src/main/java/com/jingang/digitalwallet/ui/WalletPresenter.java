package com.jingang.digitalwallet.ui;

import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jingang.digitalwallet.base.BasePresenter;
import com.jingang.digitalwallet.bean.DigitalCurrency;
import com.jingang.digitalwallet.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime:2021/7/11-10:13 PM
 * @changeTime:
 */
public class WalletPresenter extends BasePresenter<WalletFragment> {
    private volatile float mTotalValue = 0;

    public ArrayList<DigitalCurrency> getBalanceList() {
        HashMap<String, Float> rateMap = new HashMap<>();
        String rateString = FileUtil.getStringFromAssets("live-rates.json");
        JSONObject rateJson = JSONObject.parseObject(rateString);
        JSONArray rateArray = rateJson.getJSONArray("tiers");
        for (int i = 0; i < rateArray.size(); i++) {
            JSONObject jsonObject = rateArray.getJSONObject(i);
            JSONArray jsonArray = jsonObject.getJSONArray("rates");
            Log.v("JG", " " + jsonArray.getJSONObject(0).getFloatValue("rate"));
            rateMap.put(jsonObject.getString("from_currency"), jsonArray.getJSONObject(0).getFloatValue("rate"));
        }


        HashMap<String, DigitalCurrency> currencyMap = new HashMap<>();
        String jsonData = FileUtil.getStringFromAssets("currencies.json");
        JSONObject curreniesJson =
                JSONObject.parseObject(jsonData);
        JSONArray currencyInfList = curreniesJson.getJSONArray("currencies");
        for (int i = 0; i < currencyInfList.size(); i++) {
            DigitalCurrency currency = new DigitalCurrency();
            currency.coid_id = currencyInfList.getJSONObject(i).getString("coin_id");
            currency.name = currencyInfList.getJSONObject(i).getString("name");
            currency.colorful_image_url = currencyInfList.getJSONObject(i).getString("colorful_image_url");
//            currency.colorful_image_url="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fdik.img.kttpdq.com%2Fpic%2F101%2F70661%2Fadd59b8c29886a2d_1440x900.jpg&refer=http%3A%2F%2Fdik.img.kttpdq.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628477244&t=6334f2a9826053cec571b52027291ce8";
            currencyMap.put(currency.coid_id, currency);

        }

        ArrayList<DigitalCurrency> balanceList = new ArrayList<>();
        String balanceString = FileUtil.getStringFromAssets("wallet-balance.json");
        JSONObject balanceJson = JSONObject.parseObject(balanceString);
        JSONArray balanceArray = balanceJson.getJSONArray("wallet");
        for (int i = 0; i < balanceArray.size(); i++) {
            DigitalCurrency digitalCurrency = new DigitalCurrency();
            JSONObject jsonObject = balanceArray.getJSONObject(i);
            digitalCurrency.coid_id = jsonObject.getString("currency");
            digitalCurrency.name = currencyMap.get(digitalCurrency.coid_id).name;
            digitalCurrency.colorful_image_url = currencyMap.get(digitalCurrency.coid_id).
                    colorful_image_url;
            digitalCurrency.amount = jsonObject.getIntValue("amount");
            digitalCurrency.rate = rateMap.get(digitalCurrency.coid_id);
            mTotalValue = mTotalValue + digitalCurrency.amount * digitalCurrency.rate;
            balanceList.add(digitalCurrency);
        }
        return balanceList;
    }

    public float getTotalMoney() {
        return mTotalValue;
    }
}
