package io.appflate.droidvmp.androidsample.model.presentation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by andrzejchm on 26/06/16.
 */
public class RepositoriesPresentationModelTest {
    private RepositoriesPresentationModel model;

    @Before public void setUp() throws Exception {
        model = new RepositoriesPresentationModel(TestMocks.GITHUB_LOGIN);
    }

    @Test public void getUsername() throws Exception {
        assertEquals(TestMocks.GITHUB_LOGIN, model.getUsername());
    }

    @Test public void setRepositories() throws Exception {
        assertNull(model.getRepositories());
        model.setRepositories(TestMocks.REPOSITORIES);
        assertEquals(TestMocks.REPOSITORIES, model.getRepositories());
    }
}