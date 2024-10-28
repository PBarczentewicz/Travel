package org.example.flightDataAccess.schema;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CheapestTicketRequest {

    String origin;
    String destination;
    String page;
    String currency;
}
