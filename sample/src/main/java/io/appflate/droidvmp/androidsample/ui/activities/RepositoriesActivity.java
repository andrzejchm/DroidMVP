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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.appflate.droidvmp.androidsample.ui.fragments.RepositoriesFragment;
import io.appflate.droidvmp.androidsample.utils.Constants;

public class RepositoriesActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String username = getIntent().getStringExtra(Constants.PARAM_USERNAME);
        if (getSupportFragmentManager().findFragmentByTag(RepositoriesFragment.TAG) == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(android.R.id.content,
                                            RepositoriesFragment.newInstance(username),
                                            RepositoriesFragment.class.getCanonicalName())
                                       .commit();
        }
    }

    public static Intent intent(Activity activity, String username) {
        Intent intent = new Intent(activity, RepositoriesActivity.class);
        intent.putExtra(Constants.PARAM_USERNAME, username);
        return intent;
    }
}
