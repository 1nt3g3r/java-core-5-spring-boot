package com.goit5.testapp.feature.time;

public class InvalidTimeZoneException extends RuntimeException {
    public InvalidTimeZoneException(String timezone) {
        super("Invalid timezone: " + timezone);
    }
}
