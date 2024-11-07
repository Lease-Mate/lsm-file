package com.lsm.ws.file.infrastructure.rest.context;

import com.lsm.ws.file.domain.user.UserRole;
import com.lsm.ws.file.infrastructure.jwt.JwtType;

public class RequestContextBuilder {

    private JwtType tokenType;
    private UserRole userRole;
    private String userId;
    private String originalToken;

    public RequestContextBuilder withTokenType(JwtType tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public RequestContextBuilder withUserRole(UserRole userRole) {
        this.userRole = userRole;
        return this;
    }

    public RequestContextBuilder withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public RequestContextBuilder withOriginalToken(String originalToken) {
        this.originalToken = originalToken;
        return this;
    }

    public RequestContext build() {
        return new RequestContext(tokenType, userRole, userId, originalToken);
    }
}
