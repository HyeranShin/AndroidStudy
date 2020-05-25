# Activity Life Cycle
### 생명주기 메서드
|method|description|
|:-:|-|
|`onCreate`|∙ Activity 생성<br/>∙ 초기화 처리, 뷰 생성 등|
|`onStart`|∙ Activity가 화면에 표시<br/>∙ 통신이나 센서 처리 시작|
|`onResume`|∙ 사용자와 상호작용<br/>∙ 필요한 애니메이션 실행 등 화면 갱신 처리|
|`onPause`|∙ Activity가 focus를 잃음<br/>∙ 애니메이션 등 화면 갱신 처리 정지 / 일시정지할때 필요없는 리소스 해체 / 필요한 데이터 영속화|
|`onStop`|∙ Activity가 더 이상 표시되지 않음<br/>∙ 통신이나 센서 처리 정지|
|`onRestart`|∙ 활동 상태 복원<br/>∙ 보통 아무 작업 안함|
|`onDestroy`|∙ Activity가 제거<br/>∙ 필요없는 리소스 해제 / Activity 참조 정리|

### 존재 가능한 상태
- `Resumed(Active)` : 화면에 보이고, focus를 가짐
- `Paused` : 화면에 보이지만, focus를 가지지 못함 → 부분적으로 투명하거나 가려짐
- `Stopped` : 화면에 보이지 않음

### 생명주기 메서드 호출 순서
- 시작할때 : `onCreate` → `onStart` → `onResume`
- 화면 회전할때 : `onPause` → `onStop` → `onDestroy` → `onCreate` → `onStart` → `onResume`
- 다른 Activity로 이동할때 / 화면 끌때 / 홈 버튼 : `onPause` → `onStop`
- 기존 Activity 돌아올때 : `onRestart` → `onStart` → `onResume`
- Activity 종료 : `onPause` → `onStop` → `onDestroy`
- Dialog나 투명 Activity가 뜰때 : `onPause`
#### ActivityA, ActivityB가 있을때
- ActivityA → ActivityB : `onPause` → `onCreate` → `onStart` → `onResume` → `onStop`
- 다시 ActivityB → ActivityA : `onPause` → `onRestart` → `onStart` → `onResume` → `onDestroy`

### 주의점
- 리소스 생성과 소멸은 대칭이 되는 생명주기 메서드에서 실행해야 함
  - `onCreate` - `onDestroy`, `onResume` - `onPause`, `onStart` - `onStop`
- 생명주기의 super 메서드를 호출할 때 주의
  - `onCreate`, `onStart`, `onResume`은 super 호출 후 작업
  - `onPause`, `onStop`, `onDestroy`는 작업 후 super 호출
- 생명주기 메서드를 직접 호출하는 것은 추천하지 않음

![액티비티 생명주기](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile27.uf.tistory.com%2Fimage%2F22AC6833597EDA1626E2B0)