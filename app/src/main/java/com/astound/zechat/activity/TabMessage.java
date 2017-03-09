package com.astound.zechat.activity;

import com.astound.zechat.R;

/**
 * Created by iiro on 7.6.2016.
 */
public class TabMessage
{
    public static String get(int menuItemId, boolean isReselection) {
        String message = "Content for ";

        switch (menuItemId) {
            case R.id.tab_chat:
                message += "CHAT";
                break;
            case R.id.tab_friends:
                message += "FRIENDS";
                break;
            case R.id.tab_notifications:
                message += "NOTIFICATIONS";
                break;
            case R.id.tab_profile:
                message += "PROFILE";
                break;
        }

        if (isReselection) {
            message += " WAS RESELECTED! YAY!";
        }

        return message;
    }
}
