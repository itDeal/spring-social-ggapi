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
package org.springframework.social.ggapi.connect;

import org.springframework.social.ggapi.api.GGApi;
import org.springframework.social.ggapi.api.impl.GGApiTemplate;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * Twitter ServiceProvider implementation.
 * @author Tomasz Kalkosiński
 * @author Keith Donald
 * @author Craig Walls
 */
public class GGApiServiceProvider extends AbstractOAuth2ServiceProvider<GGApi> {

	public GGApiServiceProvider(String clientId, String clientSecret) {
		super(new GGApiOAuth2Template(clientId, clientSecret));
	}

    public GGApi getApi(String accessToken) {
		return new GGApiTemplate(accessToken);
	}
}