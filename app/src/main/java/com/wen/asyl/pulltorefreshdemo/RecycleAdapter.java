package com.wen.asyl.pulltorefreshdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Description：xx <br/>
 * Copyright (c) 2018<br/>
 * This program is protected by copyright laws <br/>
 * Date:2018-06-08 11:11
 *
 * @author 姜文莒
 * @version : 1.0
 */
public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{
    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;


    public RecycleAdapter(Context mContext, List<String> mDatas) {
        this.mContext=mContext;
        this.mDatas=mDatas;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout. item,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv=(TextView) view.findViewById(R.id. tv_item);
        }

    }
    //下面两个方法提供给页面刷新和加载时调用
    public void refresh(List<String> addList) {
        //增加数据
        int position = mDatas.size();
        mDatas.addAll(position, addList);
        notifyDataSetChanged();
    }

}
