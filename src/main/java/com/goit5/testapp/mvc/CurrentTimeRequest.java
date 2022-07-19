package com.goit5.testapp.mvc;

import lombok.Data;

@Data
public class CurrentTimeRequest {
    private String timezone;
    private String format;
}
