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
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import java.io.Serializable;

public abstract class DroidMVPFragment<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V>>
    extends Fragment implements DroidMVPView {

    private DroidMVPDelegate<M, V, P> mvpDelegate = new DroidMVPDelegate<M, V, P>() {
        @Override protected P createPresenter(M presentationModel) {
            return DroidMVPFragment.this.createPresenter(presentationModel);
        }

        @Override protected M createPresentationModel() {
            return DroidMVPFragment.this.createPresentationModel();
        }
    };

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpDelegate.onCreate(this, savedInstanceState);
    }

    @Override public void onStart() {
        super.onStart();
        mvpDelegate.onStart((V) this);
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mvpDelegate.onSaveInstanceState(outState);
    }

    @Override public void onStop() {
        super.onStop();
        mvpDelegate.onStop();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        mvpDelegate.onDestroy();
    }

    protected abstract P createPresenter(M presentationModel);

    protected abstract M createPresentationModel();
}