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

package io.appflate.droidvmp.androidsample.model.presentation;

import io.appflate.droidvmp.androidsample.model.Repository;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by andrzejchm on 22/06/16.
 */
public class RepositoriesPresentationModel implements Serializable {
    private  List<Repository> repositories;
    private String           username;

    public RepositoriesPresentationModel(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public boolean shouldFetchRepositories() {
        return repositories == null;
    }
}
