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

import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

/**
 * GGApi OAuth2Template.
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
public class GGApiOAuth2Template extends OAuth2Template {

    private final static String OAUTH2_AUTHORIZE_URL = "https://www.gg.pl/authorize";
    private final static String OAUTH2_TOKEN_URL = "https://auth.api.gg.pl/token";

	public GGApiOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, OAUTH2_AUTHORIZE_URL, OAUTH2_TOKEN_URL);
	}

	@Override
	protected RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(ClientHttpRequestFactorySelector.getRequestFactory());
//		FormHttpMessageConverter messageConverter = new FormHttpMessageConverter() {
//			public boolean canRead(Class<?> clazz, MediaType mediaType) {
//				// always read as x-www-url-formencoded even though GGApi sets contentType to text/plain
//				return true;
//			}
//		};
//		restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>>singletonList(messageConverter));
		return restTemplate;
	}
	
	/*@Override
	@SuppressWarnings("unchecked")	
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		MultiValueMap<String, String> response = getRestTemplate().postForObject(accessTokenUrl, parameters, MultiValueMap.class);
		String expires = response.getFirst("expires");
		return new AccessGrant(response.getFirst("access_token"), null, null, expires != null ? Integer.valueOf(expires) : null);
	}*/
}
