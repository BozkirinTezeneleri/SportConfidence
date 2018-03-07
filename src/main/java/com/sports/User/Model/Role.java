package com.sports.User.Model;

import java.util.Arrays;

/**
 * Created by sahin on 07.03.2018.
 */
public enum Role {

        USER("user"),
        ADMIN("admin",Role.USER),
        MANAGER("manager",Role.USER);

        String value;
        Role[] subRoles;

        Role(String value){
            this.value = value;
            this.subRoles = new Role[0];
        }

        Role(String value, Role... subRoles) { // "..." this means we can take one or more string args
            this.value = value;
            this.subRoles = subRoles;
        }


        public String getValue() {
            return value;
        }

        public boolean hasRole(Role role){
            return role == this || Arrays.asList(subRoles).contains(role);
        }
    }

