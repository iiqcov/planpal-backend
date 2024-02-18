package com.planpal.demo.service.user;

import com.planpal.demo.apipayload.status.ErrorStatus;
import com.planpal.demo.domain.User;
import com.planpal.demo.exception.ex.UserException;
import com.planpal.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException(ErrorStatus.USER_NOT_FOUND));
    }
}
