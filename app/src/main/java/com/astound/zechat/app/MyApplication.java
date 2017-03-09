package com.astound.zechat.app;

import android.app.Application;

import com.astound.zechat.R;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Android on 10/12/2016.
 */

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        //LeakCanary Install and analyze
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        // Enable command line interface
        /*initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(context));*/

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);

        //Calligraphy initialisation
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/OpenSans-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
