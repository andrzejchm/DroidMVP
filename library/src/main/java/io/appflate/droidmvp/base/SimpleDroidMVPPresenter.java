package io.appflate.droidmvp.base;

import java.io.Serializable;

/**
 * Base class that implements the DroidMVPPresenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the child classes by calling getMvpView().
 */
public abstract class SimpleDroidMVPPresenter<V extends DroidMVPView, M extends Serializable>
    implements DroidMVPPresenter<V> {

    protected M presentationModel;
    private   V mvpView;

    public SimpleDroidMVPPresenter(M presentationModel) {
        this.presentationModel = presentationModel;
    }

    @Override public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override public void detachView() {
        mvpView = null;
    }

    /**
     * you should override this method in your code and clean all unused objects, like RxJava's
     * subscriptions etc.
     */
    @Override public void onDestroy() {

    }

    protected V getMvpView() {
        return mvpView;
    }
}

