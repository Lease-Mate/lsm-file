package com.lsm.ws.file.domain.user;

public interface UserRepository {

    void verifyToken(String token);
}
