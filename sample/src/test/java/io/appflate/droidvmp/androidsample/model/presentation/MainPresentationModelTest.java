package io.appflate.droidvmp.androidsample.model.presentation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by andrzejchm on 26/06/16.
 */
public class MainPresentationModelTest {
    private MainPresentationModel model;

    @Before public void setUp() throws Exception {
        model = new MainPresentationModel();
    }

    @Test public void getAndSetLogin() throws Exception {
        assertNull(model.getLogin());
        model.setLogin(TestMocks.GITHUB_LOGIN);
        assertEquals(TestMocks.GITHUB_LOGIN, model.getLogin());
    }

    @Test public void setUserAndGetName() throws Exception {
        assertNull(model.getName());
        model.setUser(TestMocks.USER);
        assertEquals(TestMocks.GITHUB_LOGIN, model.getName());
    }
}