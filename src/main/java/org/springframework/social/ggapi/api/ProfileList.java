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

import java.io.Serializable;
import java.util.List;

/**
 * Model class representing a GGApi result.
 *
 * @author Tomasz Kalkosiński
 */
public class ProfileList implements Serializable {
	private static final long serialVersionUID = 1L;

    private final List<Profile> profiles;
    private final int status;

    public ProfileList(List<Profile> profiles, int status) {
        this.profiles = profiles;
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public int getStatus() {
        return status;
    }
}
