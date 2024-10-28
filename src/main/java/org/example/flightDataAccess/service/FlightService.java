package org.example.flightDataAccess.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.flightDataAccess.Utilities;
import org.example.flightDataAccess.schema.CheapestTicketRequest;
import org.example.flightDataAccess.schema.CheapestTicketResponse;

public class FlightService {

    public CheapestTicketResponse GetChepestTicket(CheapestTicketRequest request){

        RequestSpecification ticketInquiry = RestAssured.given()
                .baseUri(new Utilities().getUrlCheap())
                .header("X-Access-Token", new Utilities().getToken())
                .contentType(ContentType.JSON)
                .param("origin", request.getOrigin())
                .param("destination", request.getDestination())
                .param("page", request.getPage())
                .param("currency", request.getCurrency());

        Response response = ticketInquiry.get();

        return response.as(CheapestTicketResponse.class);
    }
}
