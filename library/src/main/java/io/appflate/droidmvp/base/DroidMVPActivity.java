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
import android.support.v7.app.AppCompatActivity;
import java.io.Serializable;

public abstract class DroidMVPActivity<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
    extends AppCompatActivity implements DroidMVPView {

    private DroidMVPViewDelegate<M, V, P> mvpDelegate = new DroidMVPViewDelegate<M, V, P>() {
        @NonNull @Override protected P createPresenter(M presentationModel) {
            return DroidMVPActivity.this.createPresenter(presentationModel);
        }

        @NonNull @Override protected M createPresentationModel() {
            return DroidMVPActivity.this.createPresentationModel();
        }
    };

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performFieldInjection();
        mvpDelegate.onCreate(this, savedInstanceState);
    }

    @Override protected void onStop() {
        super.onStop();
        mvpDelegate.onStop();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mvpDelegate.onDestroy();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mvpDelegate.onSaveInstanceState(outState);
    }

    @Override protected void onStart() {
        super.onStart();
        mvpDelegate.onStart((V) this);
    }

    protected abstract void performFieldInjection();

    @NonNull protected abstract P createPresenter(M presentationModel);

    @NonNull protected abstract M createPresentationModel();
}