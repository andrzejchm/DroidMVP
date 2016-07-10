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

package io.appflate.droidvmp.androidsample.model;/**
 * Created by andrzejchm on 23/04/16.
 */

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class User implements Serializable, Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override public User createFromParcel(Parcel source) {return new User(source);}

        @Override public User[] newArray(int size) {return new User[size];}
    };
    @SerializedName("login") public               String  login;
    @SerializedName("id") public                  int     id;
    @SerializedName("avatar_url") public          String  avatarUrl;
    @SerializedName("gravatar_id") public         String  gravatarId;
    @SerializedName("url") public                 String  url;
    @SerializedName("html_url") public            String  htmlUrl;
    @SerializedName("followers_url") public       String  followersUrl;
    @SerializedName("following_url") public       String  followingUrl;
    @SerializedName("gists_url") public           String  gistsUrl;
    @SerializedName("starred_url") public         String  starredUrl;
    @SerializedName("subscriptions_url") public   String  subscriptionsUrl;
    @SerializedName("organizations_url") public   String  organizationsUrl;
    @SerializedName("repos_url") public           String  reposUrl;
    @SerializedName("events_url") public          String  eventsUrl;
    @SerializedName("received_events_url") public String  receivedEventsUrl;
    @SerializedName("type") public                String  type;
    @SerializedName("site_admin") public          boolean siteAdmin;
    @SerializedName("name") public                String  name;
    @SerializedName("company") public             String  company;
    @SerializedName("blog") public                String  blog;
    @SerializedName("location") public            String  location;
    @SerializedName("email") public               String  email;
    @SerializedName("hireable") public            boolean hireable;
    @SerializedName("bio") public                 String  bio;
    @SerializedName("public_repos") public        int     publicRepos;
    @SerializedName("public_gists") public        int     publicGists;
    @SerializedName("followers") public           int     followers;
    @SerializedName("following") public           int     following;
    @SerializedName("created_at") public          String  createdAt;
    @SerializedName("updated_at") public          String  updatedAt;

    public User() {}

    protected User(Parcel in) {
        this.login = in.readString();
        this.id = in.readInt();
        this.avatarUrl = in.readString();
        this.gravatarId = in.readString();
        this.url = in.readString();
        this.htmlUrl = in.readString();
        this.followersUrl = in.readString();
        this.followingUrl = in.readString();
        this.gistsUrl = in.readString();
        this.starredUrl = in.readString();
        this.subscriptionsUrl = in.readString();
        this.organizationsUrl = in.readString();
        this.reposUrl = in.readString();
        this.eventsUrl = in.readString();
        this.receivedEventsUrl = in.readString();
        this.type = in.readString();
        this.siteAdmin = in.readByte() != 0;
        this.name = in.readString();
        this.company = in.readString();
        this.blog = in.readString();
        this.location = in.readString();
        this.email = in.readString();
        this.hireable = in.readByte() != 0;
        this.bio = in.readString();
        this.publicRepos = in.readInt();
        this.publicGists = in.readInt();
        this.followers = in.readInt();
        this.following = in.readInt();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
    }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeInt(this.id);
        dest.writeString(this.avatarUrl);
        dest.writeString(this.gravatarId);
        dest.writeString(this.url);
        dest.writeString(this.htmlUrl);
        dest.writeString(this.followersUrl);
        dest.writeString(this.followingUrl);
        dest.writeString(this.gistsUrl);
        dest.writeString(this.starredUrl);
        dest.writeString(this.subscriptionsUrl);
        dest.writeString(this.organizationsUrl);
        dest.writeString(this.reposUrl);
        dest.writeString(this.eventsUrl);
        dest.writeString(this.receivedEventsUrl);
        dest.writeString(this.type);
        dest.writeByte(this.siteAdmin ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.blog);
        dest.writeString(this.location);
        dest.writeString(this.email);
        dest.writeByte(this.hireable ? (byte) 1 : (byte) 0);
        dest.writeString(this.bio);
        dest.writeInt(this.publicRepos);
        dest.writeInt(this.publicGists);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
    }
}