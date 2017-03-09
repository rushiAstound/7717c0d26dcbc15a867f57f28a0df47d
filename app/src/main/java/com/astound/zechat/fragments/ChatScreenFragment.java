package com.astound.zechat.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astound.zechat.R;

//1
public class ChatScreenFragment extends Fragment
{
    //2
    public static ChatScreenFragment newInstance()
    {
        return new ChatScreenFragment();
    }

    //3
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_chat_screen, container, false);
    }
}