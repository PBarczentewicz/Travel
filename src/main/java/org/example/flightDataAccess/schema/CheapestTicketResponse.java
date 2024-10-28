package org.example.flightDataAccess.schema;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CheapestTicketResponse {
    Data data;
    String currency;
    boolean success;
}

@Getter
@Setter
class Flight {
    String airline;
    String departure_at;
    String return_at;
    String expires_at;
    int price;
    int flight_number;
}

@Getter
@Setter
class Data {
    private Map<String, Map<String, Flight>> flightsMap = new HashMap<>();

    @JsonAnySetter
    public void addFlights(String airportCode, Map<String, Flight> flights) {
        flightsMap.put(airportCode, flights);
    }
}