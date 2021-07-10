package com.jingang.digitalwallet;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jingang.digitalwallet.bean.DigitalCurrency;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Currency;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime: 2021/6/23-9:29 PM
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyHolder> {

    private volatile ArrayList<DigitalCurrency> mData;
    public MyRecyclerViewAdapter(ArrayList<DigitalCurrency> data){
        mData=data;
    }
    public void setData(ArrayList<DigitalCurrency> data){
        mData=data;
    }

    @NonNull
    @NotNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull final MyHolder holder, final int position) {
       holder.cornNameTextView.setText(mData.get(position).name);
       Glide.with(holder.itemView).load(mData.get(position).colorful_image_url)
               .centerCrop().placeholder(R.drawable.logo).into(holder.cornImageView);
       holder.cornBalanceTextView.setText(mData.get(position).amount+mData.get(position).coid_id);
       holder.cornBalanceInDollarTextView.setText("$"+ mData.get(position).amount*mData.get(position).rate);
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{
        ImageView cornImageView;
        TextView  cornNameTextView;
        TextView  cornBalanceTextView;
        TextView  cornBalanceInDollarTextView;
        public MyHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cornImageView=itemView.findViewById(R.id.corn_image);
            cornNameTextView=itemView.findViewById(R.id.corn_name);
            cornBalanceTextView=itemView.findViewById(R.id.balance);
            cornBalanceInDollarTextView=itemView.findViewById(R.id.balance_in_dollar);
        }
    }
}
