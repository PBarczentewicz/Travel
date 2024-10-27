package org.example.flightDataAccess;

import com.sun.mail.imap.protocol.SearchSequence;
import lombok.Data;


public class IataCode {

    private SearchSequence[] searchSequence;

    public SearchSequence[] getSearchSequence() {
        return searchSequence;
    }

    public void setSearchSequence(SearchSequence[] searchSequence) {
        this.searchSequence = searchSequence;
    }
}