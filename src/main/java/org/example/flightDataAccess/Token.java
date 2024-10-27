package org.example.flightDataAccess;

import lombok.Data;

public class Token {
    String token = "05087dbf3dbda88d3845ca080a0f107f";
    String myPartnerId = "582990";

    public String getToken() {
        return token;
    }

    public String getMyPartnerId() {
        return myPartnerId;
    }
}
