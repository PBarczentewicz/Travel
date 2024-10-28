package org.example.flightDataAccess.test;

import org.example.flightDataAccess.schema.CheapestTicketRequest;
import org.example.flightDataAccess.service.FlightService;
import org.junit.jupiter.api.Test;

public class CheapestTicketTest {

    @Test
    public void cheapestTicket() {

        CheapestTicketRequest request = CheapestTicketRequest.builder()
                .destination("KRK")
                .currency("PLN")
                .page("1")
                .origin("WAW").build();

        new FlightService().GetChepestTicket(request);
    }
}