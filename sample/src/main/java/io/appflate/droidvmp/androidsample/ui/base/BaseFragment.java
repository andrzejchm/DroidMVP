package io.appflate.droidvmp.androidsample.ui.base;

import android.support.annotation.NonNull;
import io.appflate.droidmvp.base.DroidMVPFragment;
import io.appflate.droidmvp.base.DroidMVPPresenter;
import io.appflate.droidmvp.base.DroidMVPView;
import java.io.Serializable;
import javax.inject.Inject;

/**
 * Created by andrzejchm on 22/06/16.
 */
public abstract class BaseFragment<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
    extends DroidMVPFragment<M, V, P> {
    @Inject protected P presenter;

    @NonNull @Override protected P createPresenter(M presentationModel) {
        //this field will be populated by field injeciton from dagger
        // your presenter should not accept the presentationModel as its constructor's paramteter.
        // Instead, it will be provided by #attachView method.
        return presenter;
    }
}