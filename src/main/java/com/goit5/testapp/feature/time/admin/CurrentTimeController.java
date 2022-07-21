package com.goit5.testapp.feature.time.admin;

import com.goit5.testapp.feature.time.pojo.CurrentTimeRequest;
import com.goit5.testapp.feature.time.pojo.CurrentTimeResponse;
import com.goit5.testapp.feature.time.service.CurrentTimeService;
import com.goit5.testapp.feature.time.InvalidTimeZoneException;
import com.goit5.testapp.mvc.LocalizeService;
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

    @ResponseBody
    @GetMapping("/getAsString")
    public String getCurrentTimeAsString(@RequestParam(required = false, name = "tz", defaultValue = "UTC") String timezone) {
        return currentTimeService.getCurrentTime(timezone);
    }

    @ResponseBody
    @GetMapping("/getAsObject")
    public CurrentTimeResponse getCurrentTimeAsObject(@RequestParam(required = false, name = "tz", defaultValue = "UTC") String timezone) {
        try {
            return CurrentTimeResponse.success(currentTimeService.getCurrentTime(timezone));
        } catch (InvalidTimeZoneException ex) {
            ex.printStackTrace();

            return CurrentTimeResponse.failed(CurrentTimeResponse.Error.invalidTimezone);
        }
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
