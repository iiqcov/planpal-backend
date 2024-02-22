package com.planpal.demo.domain;

import com.planpal.demo.domain.common.BaseEntity;
import com.planpal.demo.domain.enums.AlarmState;
import com.planpal.demo.domain.enums.UserState;
import com.planpal.demo.domain.mapping.FriendRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long kakaoId;

    @Column(nullable = false, unique = true, length = 4)
    private String tagId;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    private AlarmState alarmState;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UserState userState;

    private LocalDate inactiveAt;

    @OneToMany(mappedBy = "inviter", cascade = CascadeType.ALL)
    private List<FriendRequest> inviteList;

    @OneToMany(mappedBy = "invitee", cascade = CascadeType.ALL)
    private List<FriendRequest> invitedList;

    @Builder
    public User(Long kakaoId, String nickname) {
        this.kakaoId = kakaoId;
        this.nickname = nickname;
        this.tagId = generateRandomTagId();
        this.alarmState = AlarmState.OFF;
        this.userState = UserState.ACTIVE;
    }

    private String generateRandomTagId() {
        return UUID.randomUUID().toString().substring(0, 4);
    }
}
