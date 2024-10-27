package org.example.flightDataAccess;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter

public class CheapestTicketRequest {

    String origin;
    String destination;
    String departDate;
    String returnDate;
    String page;
    String token;
    String currency;

}
