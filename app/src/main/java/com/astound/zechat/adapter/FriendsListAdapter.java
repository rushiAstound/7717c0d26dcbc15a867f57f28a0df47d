package com.astound.zechat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astound.zechat.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android on 3/9/2017.
 */

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendViewHolder>
{
    List list;
    Context context;
    public FriendsListAdapter(List list,Context context)
    {
        this.list=list;
        this.context=context;
    }

    class FriendViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.imgCustomRowFriendsListPhoto) ImageView imgFriendPhoto;
        @BindView(R.id.txtCustomRowFriendsListName) TextView txtFriendName;

        public FriendViewHolder(View itemView)
        {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_row_friends_list, null);
        FriendViewHolder friendViewHolder=new FriendViewHolder(view);
        return friendViewHolder;
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position)
    {
        holder.imgFriendPhoto.setImageDrawable(context.getResources().getDrawable(R.drawable.logo));
        holder.txtFriendName.setText(context.getResources().getString(R.string.app_name));
    }

    @Override
    public int getItemCount()
    {
        return 10;
    }
}
