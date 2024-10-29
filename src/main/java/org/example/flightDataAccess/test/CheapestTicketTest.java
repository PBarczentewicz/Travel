package org.example.flightDataAccess.test;

import org.example.flightDataAccess.schema.CheapestTicketRequest;
import org.example.flightDataAccess.service.AssertionService;
import org.example.flightDataAccess.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import sun.jvm.hotspot.utilities.Assert;

public class CheapestTicketTest {

    @ParameterizedTest
    @CsvSource({
            "KRK, PLN, 1, WAW, true",
            "WAW, PLN, 1, KRK, true",
            "KRK, PLN, 1, GDA, bad request: airport GDA: not flightable",
    })

    public void cheapestTicket(String destination, String currency, String page, String origin, String textFromWeb) {

        CheapestTicketRequest request = CheapestTicketRequest.builder()
                .destination(destination)
                .currency(currency)
                .page(page)
                .origin(origin)
                .build();

        new FlightService().GetChepestTicket(request);

        switch (textFromWeb) {
            case "ok":


        }
    }
}