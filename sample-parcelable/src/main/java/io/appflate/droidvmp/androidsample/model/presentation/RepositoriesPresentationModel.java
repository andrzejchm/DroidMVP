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

import android.os.Parcel;
import android.os.Parcelable;
import io.appflate.droidvmp.androidsample.model.Repository;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andrzejchm on 22/06/16.
 */
public class RepositoriesPresentationModel implements Serializable, Parcelable {
    public static final Parcelable.Creator<RepositoriesPresentationModel> CREATOR =
        new Parcelable.Creator<RepositoriesPresentationModel>() {
            @Override public RepositoriesPresentationModel createFromParcel(
                Parcel source) {return new RepositoriesPresentationModel(source);}

            @Override public RepositoriesPresentationModel[] newArray(
                int size) {return new RepositoriesPresentationModel[size];}
        };
    private List<Repository> repositories;
    private String           username;

    public RepositoriesPresentationModel(String username) {
        this.username = username;
    }

    protected RepositoriesPresentationModel(Parcel in) {
        this.repositories = in.createTypedArrayList(Repository.CREATOR);
        this.username = in.readString();
    }

    public String getUsername() {
        return username;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public boolean shouldFetchRepositories() {
        return repositories == null;
    }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.repositories);
        dest.writeString(this.username);
    }
}
