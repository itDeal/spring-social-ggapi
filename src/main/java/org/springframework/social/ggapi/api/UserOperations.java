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
package org.springframework.social.ggapi.api;

import org.springframework.social.ApiException;
import org.springframework.social.MissingAuthorizationException;


/**
 * Interface defining the operations for retrieving information about GGApi users.
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
public interface UserOperations {

	/**
	 * Retrieves the authenticated user's GGApi UIN.
	 * @return the user's UIN
	 * @throws ApiException if there is an error while communicating with GGApi.
	 * @throws MissingAuthorizationException if GGApiTemplate was not created with OAuth credentials.
	 */
	String  getProfileId();
	
	/**
	 * Retrieves the authenticated user's GGApi screen name
	 * @return the user's screen name
	 * @throws ApiException if there is an error while communicating with GGApi.
	 * @throws MissingAuthorizationException if GGApiTemplate was not created with OAuth credentials.
	 */
	String getLabel();

	/**
	 * Retrieves the authenticated user's GGApi profile details.
	 * @return a {@link Profile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with GGApi.
	 * @throws MissingAuthorizationException if GGApiTemplate was not created with OAuth credentials.
	 */
	Profile getUserProfile();
    
	/**
	 * Retrieves a specific user's GGApi profile details.
	 * Note that this method does not require authentication.
	 * @param userId the user ID for the user whose details are to be retrieved.
	 * @return a {@link Profile} object representing the user's profile.
	 * @throws ApiException if there is an error while communicating with GGApi.
	 */
	Profile getUserProfile(String userId);
}
