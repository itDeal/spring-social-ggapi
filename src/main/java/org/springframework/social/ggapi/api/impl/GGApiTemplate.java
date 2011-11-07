/*
 * Copyright 2010 the original author or authors.
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


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.ggapi.api.FriendOperations;
import org.springframework.social.ggapi.api.GGApi;
import org.springframework.social.ggapi.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

/**
 * This is the central class for interacting with GGApi.
 *
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
public class GGApiTemplate  extends AbstractOAuth2ApiBinding implements GGApi {

    private FriendOperations friendOperations;

    private UserOperations userOperations;

    public GGApiTemplate() {
        super();
        initSubApis();
    }

    public GGApiTemplate(String accessToken) {
		super(accessToken);
		initSubApis();
	}

    @Override
    public FriendOperations friendOperations() {
        return friendOperations;
    }

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new GGApiModule());
		converter.setObjectMapper(objectMapper);
		return converter;
	}

    // private helper

	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized());
		this.friendOperations = new FriendTemplate(getRestTemplate(), isAuthorized());
	}
}
