package com.goit5.testapp.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/current-time")
@Controller
public class CurrentTimeController {
    private final CurrentTimeService currentTimeService;
    private final LocalizeService localizeService;

    @GetMapping("/get")
    public ModelAndView getCurrentTime(
            @RequestParam(required = false, name = "tz", defaultValue = "UTC") String timezone) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(timezone));
        return result;
    }

    @PostMapping("/post-x-form-url-encoded")
    public ModelAndView postCurrentTimeXFormUrlEncoded(String tz) {
        ModelAndView result = new ModelAndView("current-time");
        result.addObject("time", currentTimeService.getCurrentTime(tz));
        return result;
    }

    @PostMapping("/post-json")
    public ModelAndView getCurrentTimeJson(@RequestBody CurrentTimeRequest request,
                                           @RequestHeader(value = "Accept-Language", required = false) String acceptLanguage) {
        ModelAndView result = new ModelAndView("current-time");

        result.addObject("time", currentTimeService.getCurrentTime(
                request.getTimezone(), request.getFormat()
        ));

        result.addObject("currentTimeLabel", localizeService.getCurrentTimeLabel(acceptLanguage));

        return result;
    }

    @GetMapping("/{timezone}/{format}")
    public ModelAndView getPathVariableTime(
            @PathVariable("timezone") String timezone,
            @PathVariable("format") String format) {
        ModelAndView result = new ModelAndView("current-time");

        result.addObject("time", currentTimeService.getCurrentTime(timezone, format));

        result.addObject("currentTimeLabel", localizeService.getCurrentTimeLabel("uk"));

        return result;
    }
}
