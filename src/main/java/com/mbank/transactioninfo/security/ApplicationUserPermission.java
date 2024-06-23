package com.mbank.transactioninfo.security;

public enum ApplicationUserPermission {
    TRANSACTIONINFO_READ("transactioninfo:read"),
    TRANSACTIONINFO_WRITE("transactioninfo:write");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
