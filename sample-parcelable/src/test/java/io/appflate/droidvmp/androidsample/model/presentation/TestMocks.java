package io.appflate.droidvmp.androidsample.model.presentation;

import io.appflate.droidvmp.androidsample.model.Repository;
import io.appflate.droidvmp.androidsample.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrzejchm on 26/06/16.
 */

public final class TestMocks {

    public static final String           GITHUB_LOGIN = "andrzejchm";
    public static final User             USER         = new User();
    public static final List<Repository> REPOSITORIES = new ArrayList<>(3);

    static {
        USER.name = GITHUB_LOGIN;
        REPOSITORIES.add(new Repository());
        REPOSITORIES.add(new Repository());
        REPOSITORIES.add(new Repository());
    }

    private TestMocks() {
        throw new UnsupportedOperationException();
    }
}
