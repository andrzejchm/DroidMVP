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

package io.appflate.droidvmp.androidsample.ui.presenters;

import io.appflate.droidmvp.SimpleDroidMVPPresenter;
import io.appflate.droidvmp.androidsample.domain.GithubApi;
import io.appflate.droidvmp.androidsample.model.User;
import io.appflate.droidvmp.androidsample.model.presentation.MainPresentationModel;
import io.appflate.droidvmp.androidsample.ui.mvpviews.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andrzejchm on 21/06/16.
 */
public class MainPresenter extends SimpleDroidMVPPresenter<MainView, MainPresentationModel> {
    private final GithubApi githubApi;

    public MainPresenter(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @Override public void attachView(MainView mvpView, MainPresentationModel presentationModel) {
        super.attachView(mvpView, presentationModel);
        if (presentationModel.getName() != null) {
            mvpView.showUserInfo(presentationModel.getName());
        }
    }

    public void onSubmitClicked(String username) {
        if (getMvpView() != null) {
            getMvpView().showProgress();
        }
        getPresentationModel().setLogin(username);
        githubApi.getUserProfile(username).enqueue(new Callback<User>() {
            @Override public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    onUserProfileFetched(response.body());
                } else {
                    onUserProfileFetchError();
                }
            }

            @Override public void onFailure(Call<User> call, Throwable t) {
                onUserProfileFetchError();
            }
        });
    }

    public void onShowReposClicked() {
        if (getMvpView() != null) {
            getMvpView().showRepositoriesScreen(getPresentationModel().getLogin());
        }
    }

    private void onUserProfileFetchError() {
        if (getMvpView() != null) {
            getMvpView().showResponseError();
        }
    }

    private void onUserProfileFetched(User user) {
        getPresentationModel().setUser(user);
        if (getMvpView() != null) {
            getMvpView().showUserInfo(getPresentationModel().getName());
        }
    }
}
