package io.appflate.droidmvp;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by andrzejchm on 10/08/16.
 */
public class ParcelableAndSerializablePresentationModelSerializer<M>
    implements PresentationModelSerializer<M> {
    public M restorePresentationModel(Bundle savedInstanceState, String presentationModelKey) {
        if (savedInstanceState != null) {
            Object potentialPresentationModel = savedInstanceState.get(presentationModelKey);
            try {
                return (M) potentialPresentationModel;
            } catch (ClassCastException ex) {
                throw new IllegalStateException(String.format(
                    "We expected a presentationModel saved in the bundle under the key: \"%s\", but was: %s",
                    presentationModelKey,
                    potentialPresentationModel.toString()));
            }
        }
        return null;
    }

    @Override public void savePresentationModel(Bundle outState, String presentationModelKey,
        M presentationModel) {
        if (presentationModel instanceof Parcelable) {
            outState.putParcelable(presentationModelKey, (Parcelable) presentationModel);
        } else if (presentationModel instanceof Serializable) {
            outState.putSerializable(presentationModelKey, (Serializable) presentationModel);
        } else {
            throw new IllegalArgumentException(
                "Your presentation model must either implement Parcelable or Serializable interface: "
                    + presentationModel.getClass().getCanonicalName());
        }
    }
}
