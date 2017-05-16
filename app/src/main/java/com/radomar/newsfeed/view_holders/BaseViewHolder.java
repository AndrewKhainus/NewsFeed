package com.radomar.newsfeed.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Radomar on 16.05.2017.
 */

public abstract class BaseViewHolder<DO extends Object> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(DO dataObject);
}
