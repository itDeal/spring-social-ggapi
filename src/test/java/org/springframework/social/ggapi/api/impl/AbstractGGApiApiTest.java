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

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;

public abstract class AbstractGGApiApiTest {

	protected GGApiTemplate ggapi;
	
	protected GGApiTemplate unauthorizedGGApi;

	protected MockRestServiceServer mockServer;

	protected HttpHeaders responseHeaders;

	@Before
	public void setup() {
		ggapi = new GGApiTemplate("ACCESS_TOKEN");
		mockServer = MockRestServiceServer.createServer(ggapi.getRestTemplate());
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		unauthorizedGGApi = new GGApiTemplate();
		 // create a mock server just to avoid hitting real GGApi if something gets past the authorization check
		MockRestServiceServer.createServer(unauthorizedGGApi.getRestTemplate());
	}
	
	protected Resource jsonResource(String filename) {
        System.out.println(new ClassPathResource(filename + ".json", getClass()));
		return new ClassPathResource(filename + ".json", getClass());
	}
}
