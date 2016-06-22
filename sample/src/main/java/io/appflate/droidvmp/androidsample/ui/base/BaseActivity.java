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

package io.appflate.droidvmp.androidsample.ui.base;

import android.support.annotation.NonNull;
import io.appflate.droidmvp.base.DroidMVPActivity;
import io.appflate.droidmvp.base.DroidMVPPresenter;
import io.appflate.droidmvp.base.DroidMVPView;
import java.io.Serializable;
import javax.inject.Inject;

/**
 * Created by andrzejchm on 22/06/16.
 */
public abstract class BaseActivity<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
    extends DroidMVPActivity<M, V, P> {
    @Inject protected P presenter;

    @NonNull @Override protected P createPresenter(M presentationModel) {
        //this field will be populated by field injeciton from dagger
        // your presenter should not accept the presentationModel as its constructor's paramteter.
        // Instead, it will be provided to your presenter in #attachView method.
        return presenter;
    }
}
