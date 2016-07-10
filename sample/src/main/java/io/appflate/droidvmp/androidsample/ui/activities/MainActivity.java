/*
 * Copyright (C) 2016 Appflate.io
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appflate.droidvmp.androidsample.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.appflate.droidvmp.androidsample.R;
import io.appflate.droidvmp.androidsample.domain.ApiManager;
import io.appflate.droidvmp.androidsample.model.presentation.MainPresentationModel;
import io.appflate.droidvmp.androidsample.ui.base.BaseActivity;
import io.appflate.droidvmp.androidsample.ui.mvpviews.MainView;
import io.appflate.droidvmp.androidsample.ui.presenters.MainPresenter;
import io.appflate.droidvmp.androidsample.utils.KeyboardUtils;
import java.util.Locale;

public class MainActivity extends BaseActivity<MainPresentationModel, MainView, MainPresenter>
    implements MainView {

    private static final int POSITION_CONTENT_VIEW  = 0;
    private static final int POSITION_PROGRESS_VIEW = 1;

    @Bind(R.id.fullNameText)     TextView     fullNameTextView;
    @Bind(R.id.showReposButton)  Button       showReposButton;
    @Bind(R.id.usernameEditText) EditText     usernameEditText;
    @Bind(R.id.resultAnimator)   ViewAnimator resultAnimator;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @NonNull @Override protected MainPresenter createPresenter() {
        return new MainPresenter(ApiManager.getInstance().getApiService());
    }

    @NonNull @Override protected MainPresentationModel createPresentationModel() {
        return new MainPresentationModel();
    }

    @Override public void showProgress() {
        resultAnimator.setDisplayedChild(POSITION_PROGRESS_VIEW);
    }

    @Override public void showUserInfo(String name) {
        resultAnimator.setDisplayedChild(POSITION_CONTENT_VIEW);
        fullNameTextView.setText(String.format(Locale.US, "Hello %s!", name));
        showReposButton.setVisibility(View.VISIBLE);
    }

    @Override public void showResponseError() {
        resultAnimator.setDisplayedChild(POSITION_CONTENT_VIEW);
        fullNameTextView.setText(R.string.something_went_wrong);
        showReposButton.setVisibility(View.GONE);
    }

    @Override public void showRepositoriesScreen(String currentUsername) {
        startActivity(RepositoriesActivity.intent(this, currentUsername));
    }

    // clicks

    @OnClick(R.id.submitButton) void onSubmitClicked() {
        KeyboardUtils.hideKeyboard(this);
        String username = usernameEditText.getText().toString();
        getPresenter().onSubmitClicked(username);
    }

    @OnClick(R.id.showReposButton) void onShowReposClicked() {
        getPresenter().onShowReposClicked();
    }
}
