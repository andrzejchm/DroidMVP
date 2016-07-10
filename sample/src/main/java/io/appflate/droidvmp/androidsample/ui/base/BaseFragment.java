package io.appflate.droidvmp.androidsample.ui.base;

import io.appflate.droidmvp.DroidMVPFragment;
import io.appflate.droidmvp.DroidMVPPresenter;
import io.appflate.droidmvp.DroidMVPView;
import java.io.Serializable;

/**
 * Created by andrzejchm on 22/06/16.
 */
public abstract class BaseFragment<M extends Serializable, V extends DroidMVPView, P extends DroidMVPPresenter<V, M>>
    extends DroidMVPFragment<M, V, P> {

    @Override protected void performFieldInjection() {
        //since we don't use any dependency injection framework here, lets make this method no-op.
    }
}