# multi-module

## info 
- This Repository is a multi-module Init Test project.

<hr/>

### uses
- nvm (0.39.3)
- npm (v9.5.1)
- <b>node (v18.16.0)</b>
- <b>java 17</b>
- <b>spring boot 2.7.15</b>
- mariadb 


### project structure
- multi-module
    - cms
        - backend
          - Spring Boot (Controller(API))
        - frontend
          - Vue.js
    - core
        - spring Boot(Service, Repository, Domain)

<hr/>

### Summary

- MSA 방식이 아닌, 단일 웹 모듈을 기반으로 하는 프로젝트 구조일때(대규모X),   
모듈화를 통해 프로젝트를 구성. (다만 추후 MSA를 적용할때 쉽게 전환 가능할 수 있음)


- BO, FO, API 를 분리하여 개발하여, 각 모듈에 대한것만 배포를 진행 할 수 있음.<br/> 


- 또한 각 모듈별 필요 기능을, 재사용 할 수 있음. (ex. core 모듈의 Service, Repository)<br/>
그리고, 각 모듈별 의존성을 별도 관리 할 수 있다.

즉, 코드의 재사용성, 확장성을 고려한다면 멀티모듈 프로젝트를 구성할만한 가치가 있다. 

#### 단점
- 모듈간의 의존성이 높아지면, 빌드 시간이 길어질 수 있다.
- 빌드, 배포 과정이 복잡해질 수 있다. (CI/CD 구축을 이뤄놓으면 어느정도 해결가능)
- 테스트시, 일부 모듈의 의존성이 필요한 경우 테스트가 어려울 수 있음.

<hr/>

![multi-module drawio](https://github.com/swings134man/multi-module/assets/86291550/50b535f3-4b38-4724-92af-332948ccf0f4)

