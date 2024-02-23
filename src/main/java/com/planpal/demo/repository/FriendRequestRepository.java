package com.planpal.demo.repository;

import com.planpal.demo.domain.User;
import com.planpal.demo.domain.mapping.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {
    boolean existsBySenderAndReceiver(User sender, User receiver);

    Optional<FriendRequest> findByIdAndSender(Long id, User sender);

    Optional<FriendRequest> findByIdAndReceiver(Long id, User receiver);
}
