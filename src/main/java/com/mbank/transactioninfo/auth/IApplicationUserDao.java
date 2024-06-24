package com.mbank.transactioninfo.auth;

import java.util.Optional;

public interface IApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
