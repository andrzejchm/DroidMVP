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

package io.appflate.droidmvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;

/**
 * Created by andrzejchm on 16/05/16.
 */
public abstract class DroidMVPDelegate<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V>> {

    private P presenter;
    private M presentationModel;

    private String presentationModelKey;

    public void onCreate(DroidMVPView mvpView, @Nullable Bundle savedInstanceState) {
        presentationModel = restorePresentationModel(getClass(), savedInstanceState);
        presentationModelKey = mvpView.getClass().getCanonicalName() + "$PresentationModel";
        if (presentationModel == null) {
            presentationModel = createPresentationModel();
        }
        this.presenter = createPresenter(presentationModel);
    }

    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    protected void onStop() {
        checkPresenter();
        presenter.detachView();
    }

    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    protected void onDestroy() {
        checkPresenter();
        presenter.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(presentationModelKey, presentationModel);
    }

    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
    protected void onStart(V mvpView) {
        checkPresenter();
        presenter.attachView(mvpView);
    }

    public P getPresenter() {
        return presenter;
    }

    @NonNull protected abstract P createPresenter(M presentationModel);

    @NonNull protected abstract M createPresentationModel();

    private void checkPresenter() {
        if (presenter == null) {
            throw new IllegalStateException(
                "call onCreate in DroidMVPDelegate, because presenter is missing");
        }
    }

    private M restorePresentationModel(Class stateViewClass, @Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Serializable potentialPresentationModel =
                savedInstanceState.getSerializable(presentationModelKey);
            try {
                return (M) potentialPresentationModel;
            } catch (ClassCastException ex) {
                throw new IllegalStateException(String.format(
                    "We expected a presentationModel saved in the bundle under the key: \"%s\", but was: %s",
                    presentationModelKey, potentialPresentationModel.toString()));
            }
        }
        return null;
    }
}