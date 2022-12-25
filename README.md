Spec

```
Spring Boot 3.0, openJDK 17, JPA, H2 DB
```

내용

```
1. 팩토리 메서드 패턴
2. 추상팩토리 패턴
3. 빌더 패턴
4. 프로토타입 패턴
5. 싱글톤 패턴
6. 어댑터 패턴
7. 브릿지 패턴
8. 컴포지트 패턴
9. 데코레이터 패턴
10. 파사드 패턴
11. 플라이웨이트 패턴
12. 프록시 패턴
13. 책임 연쇄 패턴
14. 커맨드 패턴
15. 반복자 패턴
16. 중재자 패턴
17. 메멘토 패턴
18. 옵저버 패턴
19. 상태 패턴
20. 전략 패턴
21. 템플릿 메서드 패턴
22. 방문자 패턴
```

로컬에서 도커를 사용해서 띄우기(Macbook M1 환경)

```
M1 에서는 docker descktop의 설정 > Preferences > Docker Engine > buildkit을 false로 설정해 주어야 아래 에러 안생김
- failed to solve with frontend dockerfile.v0: failed to create LLB definition: no match for platform in manifest

프로젝트 폴더에서 아래 명령어 실행(M1인 경우 platform 옵션 주어야 함)
- docker build --platform linux/amd64 -t pattern-demo:0.0.1 .

이미지 확인
- docker images --filter=reference='pattern-demo:0.0.1'

어플리케이션 실행(M1인 경우 platform 옵션 주어야 함)
- docker run --platform linux/amd64 -d -p 9000:9000 --name pattern-demo pattern-demo:0.0.1

어플리케이션 실행 확인
- http://localhost:9000/benefits 호출
```