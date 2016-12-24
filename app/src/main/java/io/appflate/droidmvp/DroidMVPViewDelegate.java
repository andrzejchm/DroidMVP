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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Class that makes it possible to write your own custom MVP Views that will fit in the DroidMVP
 * structure.
 * It is tightly coupled with the common android component's lifecycle, like onCreate, onStart,
 * onStop,
 * onSaveInstanceState and onDestroy to properly recover the model on configuration changes and
 * making sure
 * your presenters won't leak your views when those are supposed to be destroyed.
 */
public abstract class DroidMVPViewDelegate<M, V, P extends DroidMVPPresenter<V, M>> {

    private P presenter;
    private M presentationModel;
    private final PresentationModelSerializer<M> serializer;

    private String presentationModelKey;

    public DroidMVPViewDelegate(@NonNull PresentationModelSerializer<M> serializer) {
        this.serializer = serializer;
    }

    /**
     * Commonly called from fragment's/activity's onCreate. Presentation Model is either created or
     * restored
     * here.
     *
     * @param mvpView the MVP view that is being created.
     * @param savedInstanceState instanceState provided by android framework in which we store the
     * Presentation Model
     */
    public void onCreate(V mvpView, @Nullable Bundle savedInstanceState) {
        presentationModelKey = mvpView.getClass().getCanonicalName() + "$PresentationModel";
        presentationModel =
            serializer.restorePresentationModel(savedInstanceState, presentationModelKey);
        if (presentationModel == null) {
            presentationModel = createPresentationModel();
        }
        this.presenter = createPresenter();
    }

    /**
     * Commonly called from fragment's/activity's onStart. Used for attaching the view to
     * presenter,
     * so the presenter can start to update the view's state
     */
    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR") public void onStart(V mvpView) {
        checkPresenter();
        checkPresentationModel();
        presenter.attachView(mvpView, presentationModel);
    }

    /**
     * Commonly called from fragment's/activity's onStop. Used for detaching the view from
     * presenter, so no
     * memory leaks happen.
     */
    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR") public void onStop() {
        checkPresenter();
        presenter.detachView();
    }

    /**
     * Commonly called from fragment's/activity's onDestroy. Used to notify the presenter that the
     * view
     * will no longer be attached to the presenter, so all the long running tasks have to be
     * terminated
     * and the context should be cleared.
     */
    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR") public void onDestroy() {
        checkPresenter();
        presenter.onDestroy();
    }

    /**
     * Used by the delegate to persist current Presentation Model due to configuration change.
     */
    @SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR") public void onSaveInstanceState(
        Bundle outState) {
        serializer.savePresentationModel(outState, presentationModelKey, presentationModel);
    }

    public P getPresenter() {
        return presenter;
    }

    @NonNull protected abstract P createPresenter();

    @NonNull protected abstract M createPresentationModel();

    private void checkPresenter() {
        if (presenter == null) {
            throw new IllegalStateException(
                "call onCreate in DroidMVPViewDelegate, because presenter is missing");
        }
    }

    private void checkPresentationModel() {
        if (presentationModel == null) {
            throw new IllegalStateException(
                "seems like you forgot to create presentationModel in #createPresentationModel() method, or call the #onCreate() of this delegate");
        }
    }
}