package com.wide.cakeapplication.infrastructure.constant;

import java.util.HashMap;
import java.util.HashSet;

public class Constant {
    public static HashMap<String,String> ROLES;
    static {
        ROLES = new HashMap<>();
        ROLES.put("0","staff");
        ROLES.put("1","employee");
    }
    public static String getIdentityStr(String identity){
        return ROLES.get(identity);
    }
}
