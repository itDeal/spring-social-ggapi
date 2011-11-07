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
package org.springframework.social.ggapi.api;

import org.springframework.social.ApiBinding;

/**
 * Interface specifying a basic set of operations for interacting with GGApi.
 * Implemented by GGApiTemplate.
 *
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
public interface GGApi extends ApiBinding {

    /**
	 * Returns the portion of the GGApi API containing the friends operations.
	 */
	FriendOperations friendOperations();

    /**
	 * Returns the portion of the GGApi API containing the user operations.
	 */
	UserOperations userOperations();
}
