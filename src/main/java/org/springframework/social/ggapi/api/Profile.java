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

/**
 * Model class representing a GGApi user's profile information.
 *
 * @author Tomasz Kalkosiński
 * @author Craig Walls
 */
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

//    private final static String PROFILE_URL = "http://www.mojageneracja.pl/";
    private final static String PROFILE_URL = "http://www.gg.pl/#profile/";
    private final static String PROFILE_AVATAR_URL = "http://avatars.gg.pl/";

    private final long id;
    private final String type;
    private final String label;
    private final String name;
    private final String birth;
    private final int gender;
    private final String city;

    public Profile(long id, String type, String label, String name, String birth, int gender, String city) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.city = city;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public int getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getProfileUrl() {
        return PROFILE_URL + id;
    }

    public String getAvatarUrl() {
        return PROFILE_AVATAR_URL + id;
    }
}
