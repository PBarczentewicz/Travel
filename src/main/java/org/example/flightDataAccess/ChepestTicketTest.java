package org.example.flightDataAccess;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.example.base.BaseTest;

import org.junit.jupiter.api.Test;

public class ChepestTicketTest extends BaseTest {

    @Test
    public void chepestTicket() {
        CheapestTicketRequest newRequest = new CheapestTicketRequest("Krk", "Waw", "2024-10-01", "2024-10-03", "100", "05087dbf3dbda88d3845ca080a0f107f", "RUB");
        RestAssured.baseURI = "https://api.travelpayouts.com/v1/prices/cheap";

        RequestSpecification ticketInquiry = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newRequest);

        Response response = ticketInquiry.get();
        CheapestTicketResponse ticketResponse = response.as(CheapestTicketResponse.class);
    }
}