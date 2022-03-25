# RunUpTool_api

### 작품 요약

런업툴은 코로나 19 사태 이후 비대면 수업 진행으로 인해 약화된 교사와 학생 사이의 상호작용을 개선하고자 개발한 교육 플랫폼입니다. 교사와 학생이 다양한 화상회의 플랫폼을 통해 비대면 수업을 진행하는 동안 “런업툴” 서비스를 사용하여 효과적으로 수업을 진행할 수 있습니다. 
대표적으로 실시간 퀴즈, 출석체크 기능을 제공합니다. 교사는 수업시간 이전에 퀴즈를 생성할 수 있습니다. 수업시간에 교사가 퀴즈를 내면 학생은 실시간으로 제한시간 내에 해당 퀴즈에 답을 제출해야 합니다. 추후 학생은 정답과 풀이를, 교사는 학생의 퀴즈 제출여부를 확인할 수 있습니다. 출석체크 기능은 실시간으로 학생의 수업 출석여부를 구분할 수 있습니다. 교사가 출석체크를 시작하면 학생은 10분 이내에 확인 버튼을 눌러야 출석이 인정되고 10분이 넘어갈 시 자동으로 지각처리가 됩니다. 
이와 같은 기능을 통해 효율적으로 학생을 관리하고, 원활한 실시간 쌍방향 교육이 이루어지는 데에 도움을 주고자 개발하였습니다.

### 목적

코로나 19 사태 이후 온라인 수업이 많이 시행되면서 많은 문제점이 발생하고 있습니다. “런업툴”이라는 교육 플랫폼을 구현하여 이를 개선하고자 합니다.
현재 비대면 온라인 수업 때문에 교사와 학생 모두 불편함을 겪고 있습니다. 실시간 온라인 수업에서 교사는 학생의 모습을 직접 확인하기 어려워 수업에 대한 학생별 집중력과 이해도를 파악하기 어려우며, 학생은 수업 참여에 한계가 있습니다.
 
  위의 학습격차 심화의 설문조사 결과에서도 알 수 있듯이 온라인 수업 때문인 ‘학생·교사 간 소통의 한계’가 현재 온라인 교육 현실의 큰 문제점임을 알 수 있습니다. 
 또한, 위의 통계자료를 통해 학생은 온라인 수업 내용을 완벽하게 이해하는 데에 어려움을 겪고 있다는 점을 알 수 있습니다. 특히, 가정형편이 어려운 학생은 온라인 수업의 불편함이 가장 큰 것으로 보입니다. 따라서 교육의 양극화가 더 악화할 우려의 목소리가 커지고 있습니다.
 
 다음으로 학생은 교실이 아닌 혼자만의 장소에서 온라인 수업을 듣게 되어 오로지 수업에 집중하기 어려운 환경에 처하는 문제가 발생할 수 있습니다. 
 기존 화상회의 플랫폼이 제공하지 않는 교사와 학생을 위한 실시간 기능을 추가하여 위와 같은 한계를 극복하고, 효과적인 학생 관리 시스템을 제공하여 초, 중, 고등학생의 원활한 실시간 쌍방향 교육을 위한 플랫폼을 구축하는 것이 목표입니다.

[출처] [소통광장-학습격차]③ 교사·학부모·학생, 코로나시대 교육을 말하다 < 소통광장 학습격차 < 사회 < 기사본문 - 뉴스포스트 (newspost.kr), 적나라하게 드러난 팬데믹 시대 교육 불평등 - 시사IN (sisain.co.kr)

### 개발환경 구성

사용언어: Java, Javascript, JSON
프레임워크: Spring boot, React
서버&DB: Apache tomcat, MariaDB
실행환경: Paas-TA 5.5.1

![image](https://user-images.githubusercontent.com/59945024/160120086-70d95b23-a293-464e-af42-a4064478b276.png)

### DB 설계

![image](https://user-images.githubusercontent.com/59945024/160120136-d6c645c4-1b3a-4693-a3a5-2cabc77ab055.png)

### 화면 예시

![image](https://user-images.githubusercontent.com/59945024/160120187-9571d28d-9233-40aa-87a6-d579fc1916ad.png)
![image](https://user-images.githubusercontent.com/59945024/160120211-efc03365-91dd-4a66-9eda-45abfeba95c3.png)
![image](https://user-images.githubusercontent.com/59945024/160120253-db1133d0-7908-4624-b00e-3bedc00185d6.png)
![image](https://user-images.githubusercontent.com/59945024/160120300-822a5299-955d-4aa6-8d44-95e1b51096eb.png)
![image](https://user-images.githubusercontent.com/59945024/160120331-6d219e2b-21cb-45f1-b554-6f8c600e2998.png)
![image](https://user-images.githubusercontent.com/59945024/160120400-4fa98032-25f1-48fd-bc24-1da2353ab6db.png)
![image](https://user-images.githubusercontent.com/59945024/160120441-b120ac1c-3a4a-4440-a487-9914f50a1dd1.png)

### 서비스 구성도
![image](https://user-images.githubusercontent.com/59945024/160122282-8cb4a8a1-4d70-4a50-9917-69cd4fbc4ade.png)

### 최종 솔루션
![image](https://user-images.githubusercontent.com/59945024/160122251-589af0dd-2186-4a08-bc2d-d523daca916b.png)

### 기대효과
#### 교사의 효율적인 학생 관리
출석 체크가 실시간 자동으로 수행되고, 학생들의 출석 여부와 학생들이 수업 중에 제출한 퀴즈 목록이 기록됨으로써 교사가 학생들의 출석과 수업 이해도를 확인하며 학생들을 효율적으로 관리할 수 있습니다.

#### 학생의 수업 참여도 증가
수업 중에 실시간으로 퀴즈를 풀고 제출함으로써 비대면 수업의 가장 큰 문제인 학생 수업 참여의 부재를 개선할 수 있습니다. 학생들의 수업 참여도 증가는 적극적인 학습 분위기를 형성하고 결과적으로 학습 능력 향상에 도움이 됩니다.

#### 원활한 실시간 쌍방향 교육
교사가 출석과 퀴즈 현황을 실시간 모니터링 함으로써 학생의 수업 참여도 평가와 원활한 수업 운영이 가능합니다. 교사와 학생의 원활한 실시간 쌍방향 교육이 이루어져 온라인 교육의 질이 향상됩니다.

#### 화상회의 플랫폼에 제약받지 않는 편리한 사용
화상회의 플랫폼의 종류와 상관없이 독립적으로 사용 가능 합니다. 교사의 선호 및 수업에 따라 서로 다른 화상회의 플랫폼을 사용하여도, 하나의 플랫폼으로 학생 및 수업 관리가 가능하여 편리합니다.

#### 수업 내용 외 시간 절약
출석 체크할 때 교사가 학생을 일일이 호명할 필요 없이 출석체크가 이뤄지고, 교사는 수업 주제와 맞는 퀴즈를 미리 준비할 수 있어 수업 내용과 상관없는 시간을 절약합니다.






