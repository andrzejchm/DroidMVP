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

package io.appflate.droidvmp.androidsample.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by andrzejchm on 23/04/16.
 */
public class Repository implements Serializable, Parcelable {
    public static final Parcelable.Creator<Repository> CREATOR =
        new Parcelable.Creator<Repository>() {
            @Override public Repository createFromParcel(Parcel source) {
                return new Repository(source);
            }

            @Override public Repository[] newArray(int size) {return new Repository[size];}
        };
    @SerializedName("id") public                int     id;
    @SerializedName("name") public              String  name;
    @SerializedName("full_name") public         String  fullName;
    @SerializedName("owner") public             Owner   owner;
    @SerializedName("private") public           boolean _private;
    @SerializedName("html_url") public          String  htmlUrl;
    @SerializedName("description") public       String  description;
    @SerializedName("fork") public              boolean fork;
    @SerializedName("url") public               String  url;
    @SerializedName("forks_url") public         String  forksUrl;
    @SerializedName("keys_url") public          String  keysUrl;
    @SerializedName("collaborators_url") public String  collaboratorsUrl;
    @SerializedName("teams_url") public         String  teamsUrl;
    @SerializedName("hooks_url") public         String  hooksUrl;
    @SerializedName("issue_events_url") public  String  issueEventsUrl;
    @SerializedName("events_url") public        String  eventsUrl;
    @SerializedName("assignees_url") public     String  assigneesUrl;
    @SerializedName("branches_url") public      String  branchesUrl;
    @SerializedName("tags_url") public          String  tagsUrl;
    @SerializedName("blobs_url") public         String  blobsUrl;
    @SerializedName("git_tags_url") public      String  gitTagsUrl;
    @SerializedName("git_refs_url") public      String  gitRefsUrl;
    @SerializedName("trees_url") public         String  treesUrl;
    @SerializedName("statuses_url") public      String  statusesUrl;
    @SerializedName("languages_url") public     String  languagesUrl;
    @SerializedName("stargazers_url") public    String  stargazersUrl;
    @SerializedName("contributors_url") public  String  contributorsUrl;
    @SerializedName("subscribers_url") public   String  subscribersUrl;
    @SerializedName("subscription_url") public  String  subscriptionUrl;
    @SerializedName("commits_url") public       String  commitsUrl;
    @SerializedName("git_commits_url") public   String  gitCommitsUrl;
    @SerializedName("comments_url") public      String  commentsUrl;
    @SerializedName("issue_comment_url") public String  issueCommentUrl;
    @SerializedName("contents_url") public      String  contentsUrl;
    @SerializedName("compare_url") public       String  compareUrl;
    @SerializedName("merges_url") public        String  mergesUrl;
    @SerializedName("archive_url") public       String  archiveUrl;
    @SerializedName("downloads_url") public     String  downloadsUrl;
    @SerializedName("issues_url") public        String  issuesUrl;
    @SerializedName("pulls_url") public         String  pullsUrl;
    @SerializedName("milestones_url") public    String  milestonesUrl;
    @SerializedName("notifications_url") public String  notificationsUrl;
    @SerializedName("labels_url") public        String  labelsUrl;
    @SerializedName("releases_url") public      String  releasesUrl;
    @SerializedName("deployments_url") public   String  deploymentsUrl;
    @SerializedName("created_at") public        String  createdAt;
    @SerializedName("updated_at") public        String  updatedAt;
    @SerializedName("pushed_at") public         String  pushedAt;
    @SerializedName("git_url") public           String  gitUrl;
    @SerializedName("ssh_url") public           String  sshUrl;
    @SerializedName("clone_url") public         String  cloneUrl;
    @SerializedName("svn_url") public           String  svnUrl;
    @SerializedName("homepage") public          String  homepage;
    @SerializedName("size") public              int     size;
    @SerializedName("stargazers_count") public  int     stargazersCount;
    @SerializedName("watchers_count") public    int     watchersCount;
    @SerializedName("language") public          String  language;
    @SerializedName("has_issues") public        boolean hasIssues;
    @SerializedName("has_downloads") public     boolean hasDownloads;
    @SerializedName("has_wiki") public          boolean hasWiki;
    @SerializedName("has_pages") public         boolean hasPages;
    @SerializedName("forks_count") public       int     forksCount;
    @SerializedName("mirror_url") public        String  mirrorUrl;
    @SerializedName("open_issues_count") public int     openIssuesCount;
    @SerializedName("forks") public             int     forks;
    @SerializedName("open_issues") public       int     openIssues;
    @SerializedName("watchers") public          int     watchers;
    @SerializedName("default_branch") public    String  defaultBranch;

    public Repository() {}

    protected Repository(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.fullName = in.readString();
        this.owner = in.readParcelable(Owner.class.getClassLoader());
        this._private = in.readByte() != 0;
        this.htmlUrl = in.readString();
        this.description = in.readString();
        this.fork = in.readByte() != 0;
        this.url = in.readString();
        this.forksUrl = in.readString();
        this.keysUrl = in.readString();
        this.collaboratorsUrl = in.readString();
        this.teamsUrl = in.readString();
        this.hooksUrl = in.readString();
        this.issueEventsUrl = in.readString();
        this.eventsUrl = in.readString();
        this.assigneesUrl = in.readString();
        this.branchesUrl = in.readString();
        this.tagsUrl = in.readString();
        this.blobsUrl = in.readString();
        this.gitTagsUrl = in.readString();
        this.gitRefsUrl = in.readString();
        this.treesUrl = in.readString();
        this.statusesUrl = in.readString();
        this.languagesUrl = in.readString();
        this.stargazersUrl = in.readString();
        this.contributorsUrl = in.readString();
        this.subscribersUrl = in.readString();
        this.subscriptionUrl = in.readString();
        this.commitsUrl = in.readString();
        this.gitCommitsUrl = in.readString();
        this.commentsUrl = in.readString();
        this.issueCommentUrl = in.readString();
        this.contentsUrl = in.readString();
        this.compareUrl = in.readString();
        this.mergesUrl = in.readString();
        this.archiveUrl = in.readString();
        this.downloadsUrl = in.readString();
        this.issuesUrl = in.readString();
        this.pullsUrl = in.readString();
        this.milestonesUrl = in.readString();
        this.notificationsUrl = in.readString();
        this.labelsUrl = in.readString();
        this.releasesUrl = in.readString();
        this.deploymentsUrl = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.pushedAt = in.readString();
        this.gitUrl = in.readString();
        this.sshUrl = in.readString();
        this.cloneUrl = in.readString();
        this.svnUrl = in.readString();
        this.homepage = in.readString();
        this.size = in.readInt();
        this.stargazersCount = in.readInt();
        this.watchersCount = in.readInt();
        this.language = in.readString();
        this.hasIssues = in.readByte() != 0;
        this.hasDownloads = in.readByte() != 0;
        this.hasWiki = in.readByte() != 0;
        this.hasPages = in.readByte() != 0;
        this.forksCount = in.readInt();
        this.mirrorUrl = in.readString();
        this.openIssuesCount = in.readInt();
        this.forks = in.readInt();
        this.openIssues = in.readInt();
        this.watchers = in.readInt();
        this.defaultBranch = in.readString();
    }

    @Override public int describeContents() { return 0; }

    @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.fullName);
        dest.writeParcelable(this.owner, flags);
        dest.writeByte(this._private ? (byte) 1 : (byte) 0);
        dest.writeString(this.htmlUrl);
        dest.writeString(this.description);
        dest.writeByte(this.fork ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.forksUrl);
        dest.writeString(this.keysUrl);
        dest.writeString(this.collaboratorsUrl);
        dest.writeString(this.teamsUrl);
        dest.writeString(this.hooksUrl);
        dest.writeString(this.issueEventsUrl);
        dest.writeString(this.eventsUrl);
        dest.writeString(this.assigneesUrl);
        dest.writeString(this.branchesUrl);
        dest.writeString(this.tagsUrl);
        dest.writeString(this.blobsUrl);
        dest.writeString(this.gitTagsUrl);
        dest.writeString(this.gitRefsUrl);
        dest.writeString(this.treesUrl);
        dest.writeString(this.statusesUrl);
        dest.writeString(this.languagesUrl);
        dest.writeString(this.stargazersUrl);
        dest.writeString(this.contributorsUrl);
        dest.writeString(this.subscribersUrl);
        dest.writeString(this.subscriptionUrl);
        dest.writeString(this.commitsUrl);
        dest.writeString(this.gitCommitsUrl);
        dest.writeString(this.commentsUrl);
        dest.writeString(this.issueCommentUrl);
        dest.writeString(this.contentsUrl);
        dest.writeString(this.compareUrl);
        dest.writeString(this.mergesUrl);
        dest.writeString(this.archiveUrl);
        dest.writeString(this.downloadsUrl);
        dest.writeString(this.issuesUrl);
        dest.writeString(this.pullsUrl);
        dest.writeString(this.milestonesUrl);
        dest.writeString(this.notificationsUrl);
        dest.writeString(this.labelsUrl);
        dest.writeString(this.releasesUrl);
        dest.writeString(this.deploymentsUrl);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeString(this.pushedAt);
        dest.writeString(this.gitUrl);
        dest.writeString(this.sshUrl);
        dest.writeString(this.cloneUrl);
        dest.writeString(this.svnUrl);
        dest.writeString(this.homepage);
        dest.writeInt(this.size);
        dest.writeInt(this.stargazersCount);
        dest.writeInt(this.watchersCount);
        dest.writeString(this.language);
        dest.writeByte(this.hasIssues ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasDownloads ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasWiki ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasPages ? (byte) 1 : (byte) 0);
        dest.writeInt(this.forksCount);
        dest.writeString(this.mirrorUrl);
        dest.writeInt(this.openIssuesCount);
        dest.writeInt(this.forks);
        dest.writeInt(this.openIssues);
        dest.writeInt(this.watchers);
        dest.writeString(this.defaultBranch);
    }
}
