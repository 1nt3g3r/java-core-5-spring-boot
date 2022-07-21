package com.goit5.testapp.feature.time.pojo;

import lombok.Data;

@Data
public class CurrentTimeRequest {
    private String timezone;
    private String format;
}
