package com.jingang.digitalwallet;

import android.companion.DeviceFilter;
import android.content.Context;
import android.service.quickaccesswallet.WalletCard;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime:2021/6/29-10:59 PM
 * @changeTime:
 */
public class DataGenerator {

    public static final int []mTabRes = new int[]{R.drawable.wallet,R.drawable.defi};
    public static final int []mTabResPressed = new int[]{R.drawable.wallet,R.drawable.defi};
    public static final String []mTabTitle = new String[]{"Wallet","DeFi"};

    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = WalletFragment.newInstance();
        fragments[1] = DeFiFragment.newInstance();
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
//        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
//        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
//        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
//        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
//        tabText.setText(mTabTitle[position]);
//        return view;
        return null;
    }
}

