package com.astound.zechat.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Android on 2/11/2017.
 */

public class Utilities
{
    public static void showToast(String msg, Activity act)
    {
        Toast toast = Toast.makeText(act, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    // Email Validation
    public static boolean eMailValidation(String emailstring)
    {
        if (TextUtils.isEmpty(emailstring))
        {
            return false;
        }
        Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher emailMatcher = emailPattern.matcher(emailstring);
        return emailMatcher.matches();
    }
}
