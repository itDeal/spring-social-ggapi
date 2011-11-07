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

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Mixin class for adding Jackson annotations to GGApi Profile.
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@SuppressWarnings("unused")
abstract class ProfileMixin {
	@JsonCreator
    ProfileMixin(
            @JsonProperty("id") long id,
            @JsonProperty("type") String type,
            @JsonProperty("label") String label,
            @JsonProperty("name") String name,
            @JsonProperty("birth") String birth,
            @JsonProperty("gender") int gender,
            @JsonProperty("city") String city) {}
}
