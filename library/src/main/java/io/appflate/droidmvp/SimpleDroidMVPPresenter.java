/*
 * Copyright (C) 2016 Appflate.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.appflate.droidmvp;

import java.io.Serializable;

/**
 * Base class that implements the DroidMVPPresenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the child classes by calling getMvpView().
 */
public abstract class SimpleDroidMVPPresenter<V extends DroidMVPView, M extends Serializable>
    implements DroidMVPPresenter<V,M> {

    private M presentationModel;
    private   V mvpView;

    @Override public void attachView(V mvpView, M presentationModel) {
        this.mvpView = mvpView;
        this.presentationModel = presentationModel;
    }

    public M getPresentationModel() {
        return presentationModel;
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

