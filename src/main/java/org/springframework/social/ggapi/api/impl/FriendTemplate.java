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

import org.springframework.social.ggapi.api.Friend;
import org.springframework.social.ggapi.api.FriendOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

/**
 * Implementation of {@link FriendTemplate}, providing a binding to GGApi's friends REST resources.
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
class FriendTemplate extends AbstractGGapiOperations implements FriendOperations {

    private final RestTemplate restTemplate;

	public FriendTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

    @Override
    public ArrayList<Friend> getFriends() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
