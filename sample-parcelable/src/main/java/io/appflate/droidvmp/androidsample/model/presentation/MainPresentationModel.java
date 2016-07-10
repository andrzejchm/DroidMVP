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
import io.appflate.droidvmp.androidsample.model.User;

/**
 * Created by andrzejchm on 21/06/16.
 */
public class MainPresentationModel implements Parcelable {
    public static final Parcelable.Creator<MainPresentationModel> CREATOR =
        new Parcelable.Creator<MainPresentationModel>() {
            @Override public MainPresentationModel createFromParcel(
                Parcel source) {return new MainPresentationModel(source);}

            @Override public MainPresentationModel[] newArray(
                int size) {return new MainPresentationModel[size];}
        };
    private String login;
    private User   user;

    public MainPresentationModel() {}

    protected MainPresentationModel(Parcel in) {
        this.login = in.readString();
        this.user = in.readParcelable(User.class.getClassLoader());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        if (user == null) {
            return null;
        } else {
            if (user.name == null) {
                return user.login;
            } else {
                return user.name;
            }
        }
    }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeParcelable(this.user, flags);
    }
}
