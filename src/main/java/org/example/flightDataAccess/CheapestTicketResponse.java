package org.example.flightDataAccess;

public class CheapestTicketResponse {
    boolean success;
    DataFlight flighResponseData;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public org.example.flightDataAccess.DataFlight setFlighResponseData(){
        return flighResponseData;
    }

}
