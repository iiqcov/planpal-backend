package com.planpal.demo.web.controller;

import com.planpal.demo.apipayload.ApiResponse;
import com.planpal.demo.converter.UserConverter;
import com.planpal.demo.service.friend.FriendQueryService;
import com.planpal.demo.web.dto.UserResponseDto.GetResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
@RequiredArgsConstructor
public class FriendGetController {

    private final FriendQueryService friendQueryService;

    @GetMapping("/request/send")
    public ApiResponse<List<GetResultDto>> getFriendRequestReceiver(@AuthenticationPrincipal Long userId) {
        List<GetResultDto> getResultDtos = friendQueryService.getFriendRequestReceiver(userId).stream()
                .map(UserConverter::toGetResultDto)
                .toList();
        return ApiResponse.onSuccess(getResultDtos);
    }

    @GetMapping("/request/receive")
    public ApiResponse<List<GetResultDto>> getFriendRequestSenders(@AuthenticationPrincipal Long userId) {
        List<GetResultDto> getResultDtos = friendQueryService.getFriendRequestSenders(userId).stream()
                .map(UserConverter::toGetResultDto)
                .toList();
        return ApiResponse.onSuccess(getResultDtos);
    }
}
