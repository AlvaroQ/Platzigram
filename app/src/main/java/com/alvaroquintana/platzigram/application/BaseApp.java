package com.alvaroquintana.platzigram.application;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;

public class BaseApp extends Application {

    private static BaseApp INSTANCE;

    /**
     * Called by Android OS.
     *
     * @see android.app.Application
     **/
    public BaseApp() {
        INSTANCE = this;
    }

    public static BaseApp getInstance() {
        return INSTANCE;
    }

    public static void clearCookies(Context context) {
        Log.d("CLEAR COOKIES", "API >=" + String.valueOf(Build.VERSION_CODES.LOLLIPOP_MR1));
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
