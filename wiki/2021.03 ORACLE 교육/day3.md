## JOIN
업무 성격에 따른 조인 방법
1. Nested-Loop Join
  : 조인에 참여하는 행의 건수가 적을 경우
  : 두 테이블 중 데이터 수가 적은 테이블을 driving 테이블, 많은 테이블을 inner 테이블로 사용
2. Hash-Join
  : 조인에 참여하는 행의 건수가 많을 경우
  : 조인조건절이 =인 경우
3. Sort-Merge Join
  : 조인에 참여하는 행의 건수가 많을 경우
  : 조인조건절이 =이 아닌 경우

오라클의 제약조건 5가지
1. pk
2. unique
3. not null
4. foreign key
5. check

## 서브쿼리
1. 서브쿼리 IN, EXISTS 사용시 SEMI 조인 발생
2. NOT IN, NOT EXISTS 사용시 ANTI 조인 발생
