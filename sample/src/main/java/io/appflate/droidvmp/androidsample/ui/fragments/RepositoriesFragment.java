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

package io.appflate.droidvmp.androidsample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.appflate.droidvmp.androidsample.R;
import io.appflate.droidvmp.androidsample.domain.ApiManager;
import io.appflate.droidvmp.androidsample.model.Repository;
import io.appflate.droidvmp.androidsample.model.presentation.RepositoriesPresentationModel;
import io.appflate.droidvmp.androidsample.ui.adapters.ReposRecyclerAdapter;
import io.appflate.droidvmp.androidsample.ui.base.BaseFragment;
import io.appflate.droidvmp.androidsample.ui.mvpviews.RepositoriesView;
import io.appflate.droidvmp.androidsample.ui.presenters.RepositoriesPresenter;
import io.appflate.droidvmp.androidsample.utils.Constants;
import java.util.List;

/**
 * Created by andrzejchm on 22/06/16.
 */

public class RepositoriesFragment
    extends BaseFragment<RepositoriesPresentationModel, RepositoriesView, RepositoriesPresenter>
    implements RepositoriesView {
    public static final  String TAG                 = RepositoriesFragment.class.getCanonicalName();
    private static final int    CHILD_PROGRESS_VIEW = 0;
    private static final int    CHILD_CONTENT_VIEW  = 1;
    @Bind(R.id.reposRecyclerView) RecyclerView reposRecyclerView;
    @Bind(R.id.reposAnimator)     ViewAnimator reposAnimator;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull @Override protected RepositoriesPresenter createPresenter() {
        return new RepositoriesPresenter(ApiManager.getInstance().getApiService());
    }

    @NonNull @Override protected RepositoriesPresentationModel createPresentationModel() {
        String username = getArguments().getString(Constants.PARAM_USERNAME);
        return new RepositoriesPresentationModel(username);
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repositories, container, false);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override public void showTitle(String username) {
        getActivity().setTitle(username);
    }

    @Override public void showLoadingProgress() {
        reposAnimator.setDisplayedChild(CHILD_PROGRESS_VIEW);
    }

    @Override public void showRepositoriesList(List<Repository> repositories) {
        reposAnimator.setDisplayedChild(CHILD_CONTENT_VIEW);
        reposRecyclerView.setLayoutManager(
            new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        reposRecyclerView.setAdapter(new ReposRecyclerAdapter(repositories));
    }

    @Override public void showRepositoriesFetchError() {
        reposAnimator.setNextFocusDownId(1);
    }

    public static RepositoriesFragment newInstance(String username) {
        Bundle args = new Bundle();
        RepositoriesFragment fragment = new RepositoriesFragment();
        args.putSerializable(Constants.PARAM_USERNAME, username);
        fragment.setArguments(args);
        return fragment;
    }
}
