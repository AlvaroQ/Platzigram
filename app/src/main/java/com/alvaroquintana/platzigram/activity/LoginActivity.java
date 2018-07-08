package com.alvaroquintana.platzigram.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alvaroquintana.platzigram.R;
import com.alvaroquintana.platzigram.view.ContainerActivity;

/**
 * A login screen that offers login via email/password.
 *
 * URL para conseguir recursos grafico gratuitos para android
 * https://iconos8.es/android-icons/
 *
 * URL para tratar recursos graficos
 * https://romannurik.github.io/AndroidAssetStudio/icons-launcher.html#foreground.space.trim=1&foreground.space.pad=-0.1&foreColor=rgba(96%2C%20125%2C%20139%2C%200)&backColor=rgb(68%2C%20138%2C%20255)&crop=0&backgroundShape=square&effects=none&name=ic_launcher
 *
 */
public class LoginActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     *
     * @param view
     */
    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    /**
     *
     * @param view
     */
    public void goHome(View view) {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}