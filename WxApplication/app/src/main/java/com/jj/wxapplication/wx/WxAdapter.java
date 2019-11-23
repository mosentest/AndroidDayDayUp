package com.jj.wxapplication.wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jj.wxapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2018-2019
 * Author: ziqimo
 * Date: 2019-11-23 22:29
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class WxAdapter extends RecyclerView.Adapter<WxAdapter.ViewHolder> {

    /**
     * 放数据 集合
     */
    private List<WxBean> wxBeans = new ArrayList<>();


    /**
     * ListView 这参数
     * <p>
     * <p>
     * 1 2 3 4 5  ---- 6 7
     * <p>
     * 1 2  * 3 4 5 6 7
     * 1 2 3 4 5
     */

    /**
     * 做缓存对象
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mIcon;
        public TextView mName;
        public TextView mContent;
        public LinearLayout mWxLlContent;


        public ViewHolder(View view) {
            super(view);
            mIcon = view.findViewById(R.id.icon);
            mName = view.findViewById(R.id.name);
            mContent = view.findViewById(R.id.content);
            mWxLlContent = view.findViewById(R.id.wx_llContent);

        }
    }

    /**
     * @param parent
     * @param viewType 加载不同布局，如聊天app
     *                 switch (viewType) {
     *                 case 1:
     *                 case 2:
     *                 }
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * 加载一个布局文件
         */
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_wx_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 做下点击效果
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo 做下点击效果
            }
        });
        return viewHolder;
    }

    /**
     * @param holder   onCreateViewHolder创建的对象
     * @param position 列表的每一个对应的位置
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WxBean wxBean = wxBeans.get(position);

        //数据绑定到viewholder
        holder.mIcon.setImageResource(wxBean.resId);
        holder.mName.setText(wxBean.name);
        holder.mContent.setText(wxBean.content);
    }

    @Override
    public int getItemCount() {
        return wxBeans.size();
    }

    public void setWxBeans(List<WxBean> wxBeans) {
        if (wxBeans == null) {
            return;
        }
        //性能优化方面
        this.wxBeans.clear();
        this.wxBeans.addAll(wxBeans);
    }
}
