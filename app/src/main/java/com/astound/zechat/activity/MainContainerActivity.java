package com.astound.zechat.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.astound.zechat.R;
import com.astound.zechat.fragments.ChatScreenFragment;
import com.astound.zechat.fragments.FriendsScreenFragment;
import com.astound.zechat.fragments.NotificationScreenFragment;
import com.astound.zechat.fragments.ProfileScreenFragment;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainContainerActivity extends AppCompatActivity
{
    private BottomBar mBottomBar;
    private FragNavController fragNavController;
    TextView messageView;

    //indices to fragments
    private final int TAB_CHAT = FragNavController.TAB1;
    private final int TAB_FRIENDS = FragNavController.TAB2;
    private final int TAB_NOTIFICATION = FragNavController.TAB3;
    private final int TAB_PROFILE = FragNavController.TAB4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_container);
        initFragments(savedInstanceState);
    }

    private void initFragments(Bundle savedInstanceState)
    {
        //FragNav
        //list of fragments
        List<Fragment> fragments = new ArrayList<>(4);
        //add fragments to list
        fragments.add(ChatScreenFragment.newInstance());
        fragments.add(FriendsScreenFragment.newInstance());
        fragments.add(NotificationScreenFragment.newInstance());
        fragments.add(ProfileScreenFragment.newInstance());
        //link fragments to container
        fragNavController = new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.container, fragments, TAB_CHAT);
        //End of FragNav
        initBottomBar(savedInstanceState);
    }


    private void initBottomBar(Bundle savedInstanceState)
    {
        messageView = (TextView) findViewById(R.id.messageView);
        mBottomBar=(BottomBar)findViewById(R.id.bottomBar);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener()
        {
            @Override
            public void onTabSelected(@IdRes int tabId)
            {
                switch (tabId)
                {
                    case R.id.tab_chat:
                        fragNavController.switchTab(TAB_CHAT);
                        break;
                    case R.id.tab_friends:
                        fragNavController.switchTab(TAB_FRIENDS);
                        break;
                    case R.id.tab_notifications:
                        fragNavController.switchTab(TAB_NOTIFICATION);
                        break;
                    case R.id.tab_profile:
                        fragNavController.switchTab(TAB_PROFILE);
                        break;
                }
            }
        });
        mBottomBar.setOnTabReselectListener(new OnTabReselectListener()
        {
            @Override
            public void onTabReSelected(@IdRes int tabId)
            {
                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
    }

}
