package com.radomar.newsfeed.adapters;

import android.support.v7.widget.RecyclerView;

import com.radomar.newsfeed.view_holders.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radomar on 16.05.2017.
 */

public abstract class BaseAdapter<DO extends Object, VH extends BaseViewHolder<DO>> extends RecyclerView.Adapter<VH> {

    public NewsEventListener mListener;

    protected List<DO> mData = new ArrayList<>();

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setData(List<DO> data) {
        if (data == null)
            mData = new ArrayList<>();
        else
            mData = data;
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void setListener(NewsEventListener mListener) {
        this.mListener = mListener;
    }
}
