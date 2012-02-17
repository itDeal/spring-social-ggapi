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

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.social.ggapi.api.Profile;

import static org.junit.Assert.assertEquals;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

/**
 * @author Tomasz Kalkosiński
 */
public class UserTemplateTest extends AbstractGGApiApiTest {
    
    @Test
    public void testGetUserProfile() throws Exception {
//        mockServer.expect(requestTo("https://pubdir.api.gg.pl/users/me"))
//			.andExpect(method(HttpMethod.GET))
//			.andRespond(withResponse(jsonResource("me"), responseHeaders));

        mockServer.expect(requestTo("https://pubdir.api.gg.pl/users/me"))
			.andExpect(method(HttpMethod.GET))
			.andRespond(withResponse("{\"result\":{\"users\":[{\"id\":\"9200922362184425977\",\"type\":\"user\",\"label\":\"SpOOnman\",\"name\":\"Tomasz\",\"birth\":\"2000-01-07T01:00:00+01:00\",\"gender\":\"2\",\"city\":\"Warszawa\"}],\"status\":0}}", responseHeaders));

        Profile me = ggapi.userOperations().getUserProfile();

        assertEquals("9200922362184425977", me.getId());
        assertEquals("user", me.getType());
        assertEquals("SpOOnman", me.getLabel());
        assertEquals("Tomasz", me.getName());
        assertEquals("2000-01-07T01:00:00+01:00", me.getBirth());
        assertEquals(2, me.getGender());
        assertEquals("Warszawa", me.getCity());
        assertEquals("http://avatars.api.gg.pl/files/clientId,12345/user,9200922362184425977/", me.getAvatarUrl("12345"));
    }
}
