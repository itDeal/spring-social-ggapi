/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.ggapi.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.ggapi.api.GGApi;
import org.springframework.social.ggapi.api.Profile;

/**
 * GGApi ApiAdapter implementation.
 * @author Tomasz Kalkosiński
 * @author Keith Donald
 */
public class GGApiAdapter implements ApiAdapter<GGApi> {

    /**
     * clientId is used for generating avatar URL.
     */
    private final String consumerKey;

    public GGApiAdapter(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public boolean test(GGApi GGApi) {
		try {
			GGApi.userOperations().getUserProfile();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(GGApi ggApi, ConnectionValues values) {
		Profile profile = ggApi.userOperations().getUserProfile();
		values.setProviderUserId(Long.toString(profile.getId()));
		values.setDisplayName(profile.getLabel());
		values.setProfileUrl(profile.getProfileUrl());
		values.setImageUrl(profile.getAvatarUrl(this.consumerKey));
	}

	public UserProfile fetchUserProfile(GGApi ggApi) {
		Profile profile = ggApi.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setUsername(profile.getLabel()).build();
	}
	
	public void updateStatus(GGApi ggApi, String message) {
		// nothing
	}
	
}