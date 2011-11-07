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

package org.springframework.social.ggapi.api.impl;

import org.springframework.social.ggapi.api.Profile;
import org.springframework.social.ggapi.api.ProfileListResult;
import org.springframework.social.ggapi.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of the {@link UserOperations} interface providing binding to GGApi's user-oriented REST resources.
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
class UserTemplate extends AbstractGGapiOperations implements UserOperations {

    private final static String GGAPI_PUBDIR_URL    = "https://pubdir.api.gg.pl/users/user,";
    private final static String GGAPI_PUBDIR_ME_URL = "https://pubdir.api.gg.pl/users/me";

    private final RestTemplate restTemplate;

	public UserTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

    @Override
    public long getProfileId() {
        requireAuthorization();
        return getUserProfile().getId();
    }

    @Override
    public String getLabel() {
        requireAuthorization();
        return getUserProfile().getLabel();
    }

    @Override
    public Profile getUserProfile() {
        requireAuthorization();
        ProfileListResult profiles = restTemplate.getForObject(GGAPI_PUBDIR_ME_URL, ProfileListResult.class);
        return profiles.getResult().getProfiles().get(0);
    }

    @Override
    public Profile getUserProfile(long userId) {
        ProfileListResult profiles = restTemplate.getForObject(GGAPI_PUBDIR_URL + userId, ProfileListResult.class);
        return profiles.getResult().getProfiles().get(0);
    }
}
