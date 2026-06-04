package com.stacklink.domain.project.service;

import com.stacklink.domain.project.dto.UserResponse;
import com.stacklink.domain.project.entity.User;
import com.stacklink.domain.project.repository.TechUsersRepository;
import com.stacklink.domain.project.repository.UserFollowRepository;
import com.stacklink.domain.project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFollowRepository userFollowRepository;
    private final TechUsersRepository techUsersRepository;

    // 마이페이지에서 내 정보 읽어오기 위해 만든 서비스
    @Transactional(readOnly = true)
    public UserResponse getMyProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        long followerCount = userFollowRepository.countByFollowing_Id(userId);
        long followingCount = userFollowRepository.countByFollower_Id(userId);

        // { techName: careerDetail } 형태로 변환
        Map<String, String> techStack = techUsersRepository.findByUser_Id(userId)
                .stream()
                .collect(Collectors.toMap(
                        tu -> tu.getTech().getTechName(),
                        tu -> tu.getCareer().getCareerDetail()
                ));

        return UserResponse.of(user, followerCount, followingCount, techStack);
    }
}
