package com.example.pattern.user.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pattern.user.entity.Member;
import com.example.pattern.user.model.OAuthProfile;
import com.example.pattern.user.model.OauthUser;
import com.example.pattern.user.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final Map<String, OAuthAbstractFactory> oAuthFactories;
    private final MemberRepository memberRepository;

    @Transactional
    public Member saveMember(String snsType, String token) {
        OAuthAbstractFactory factory = switch (snsType) {
            case "google" -> oAuthFactories.get("googleOAuthFactory");
            case "facebook" -> oAuthFactories.get("facebookOAuthFactory");
            default -> throw new IllegalArgumentException("존재하지 않는 snsType 입니다.");
        };

        // Abstract Factory 패턴: 관련된 여러 제품들을 함께 생성
        OAuthProfile profile = factory.createProfile(token);
        OauthUser oauthUser = factory.createUser(token);

        // 프로필 정보 로깅
        log.info("프로필 정보 - 이름: {}, 이메일: {}, 이미지: {}", 
                profile.getDisplayName(), profile.getEmail(), profile.getProfileImage());

        Member member = oauthUser.getMember();
        Member save = memberRepository.save(member);
        log.info("새로운 멤버가 생성되었습니다 : " + save.toString());

        // ModelMapper modelMapper = new ModelMapper();
        // MemberDto map = modelMapper.map(save, MemberDto.class);

        return save;
    }

    @Transactional
    public void emptyLogic() {
        /*
        스프링 OSIV의 특징

        스프링 OSIV는 클라이언트의 요청이 들어올 때 영속성 컨텍스트를 생성해서 요청이 끝날 때까지 같은 영속성 컨텍스트를 유지합니다.
        따라서 한 번 조회한 엔티티는 요청이 끝날 때까지 영속 상태를 유지합니다.
        엔티티 수정은 트랜잭션이 있는 계층에서만 동작합니다.
        트랜잭션이 없는 프리젠테이션 계층은 지연 로딩을 포함해서 조회만 할 수 있습니다.
         */
    }
}
