package com.alvaroquintana.platzigram.base.activity;

import android.support.v7.app.AppCompatActivity;

import com.alvaroquintana.platzigram.base.presenter.BasePresenter;
import com.alvaroquintana.platzigram.base.view.BaseView;
import com.alvaroquintana.platzigram.utils.DialogListener;

public abstract class BaseActivity<V extends BaseView, T extends BasePresenter<V>>
        extends AppCompatActivity implements BaseView, DialogListener {

}
