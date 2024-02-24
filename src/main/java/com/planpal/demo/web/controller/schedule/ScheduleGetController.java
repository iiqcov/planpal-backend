package com.planpal.demo.web.controller.schedule;

import com.planpal.demo.apipayload.ApiResponse;
import com.planpal.demo.apipayload.status.SuccessStatus;
import com.planpal.demo.service.schedule.ReadScheduleService;
import com.planpal.demo.web.dto.schedule.GetAllScheduleListResponse;
import com.planpal.demo.web.dto.schedule.GetScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleGetController {
    private final ReadScheduleService readScheduleService;

    @GetMapping("/schedules/{scheduleId}")
    public ApiResponse<GetScheduleResponse> getSchedule(@PathVariable Long scheduleId){
        GetScheduleResponse response=readScheduleService.getSchedule(scheduleId);
        return ApiResponse.of(SuccessStatus._OK, response);
    }

    @GetMapping("/schedules")
    public ApiResponse<GetAllScheduleListResponse> getAllSchedules(){
        GetAllScheduleListResponse response=readScheduleService.getAllSimpleScheduls();
        return ApiResponse.of(SuccessStatus._OK, response);
    }
}
