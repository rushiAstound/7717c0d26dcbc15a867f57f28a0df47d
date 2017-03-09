package com.astound.zechat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astound.zechat.R;

//1
public class FriendsScreenFragment extends Fragment
{
    //2
    public static FriendsScreenFragment newInstance()
    {
        return new FriendsScreenFragment();
    }

    //3
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_friends_screen, container, false);
    }
}