package io.appflate.droidmvp;

import android.os.Bundle;

/**
 * Objects of this class are used to serialize and deserialize PresentationModel to/from the Bundle object.
 */
public interface PresentationModelSerializer<M> {
    M restorePresentationModel(Bundle savedInstanceState, String presentationModelKey);

    void savePresentationModel(Bundle outState, String presentationModelKey, M presentationModel);
}
