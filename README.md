# 잇핏 - Core
잇핏의 핵심 기능을 책임지는 백엔드입니다.
## 주요 기능
- 사용자의 프로필 정보를 바탕으로 주요 영양 성분의 권장 섭취량을 안내해줍니다.
  - 세부적으로 본인의 목표 스타일 및 질병을 고려하여 안내해줍니다.
- 점심까지 입력이 되면 당일 섭취 성분을 바탕으로 저녁 메뉴를 추천해줍니다.
- 각 식사를 입력하고 해당 식사에 대한 정보가 저장됩니다.
- 내 섭취 현황을 모니터링 할 수 있습니다.



# Commit Convention
```
[Commit Type]: 제목
(띄고)
본문(생략 가능)
(띄고)
꼬리말(생략 가능)
```
## Commit Type
feat:	새로운 기능 추가<br>
fix: 버그 수정<br>
refactor:	리팩토링<br>
comment: 주석 관련 작업<br>
style: 단순 코드 정렬<br>
test:	테스트 코드 작성<br>
chore: 기타 변경 사항 ex) 빌드 관 파일, 비즈니 로직과 상관없는 파일<br>
rename:	파일 혹은 폴더명 수정하거나 옮기는 경우<br>
remove:	파일 삭제 작업만 존재하는 경우<br>
