package com.alvaroquintana.platzigram.base.presenter;

import com.alvaroquintana.platzigram.base.view.BaseView;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

    boolean isFragmentFingerPrintAttached();
}
