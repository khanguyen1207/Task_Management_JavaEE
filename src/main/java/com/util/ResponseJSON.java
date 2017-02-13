package com.util;

/**
 * Created by khanguyen on 07/02/2017.
 */
public class ResponseJSON {
    private final int httpStatus;
    private final String description;

    public ResponseJSON(int httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getDescription() {
        return description;
    }
}
