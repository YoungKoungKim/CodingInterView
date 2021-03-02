강사님 메일 freeohh1216@gmail.com

## SQL 구조
물리적 데이터베이스 : 하드디스크
작업 영역 Instance : 메모리(SGA)
-> 꼭 알아두어야 할 메모리 영역
1. Shared Pool
2. DB Buffer cash
3. Ledo log buffer

ORACLE 실행 단계
1. Parse
  : Hard/Soft Parse가 있는데 Hard를 지양한다.
  : 이미 실행 된 적이 있는 구문이라면 shared pool 에 있는 library cache에서 해당 구문을 찾는다.
  : 최초 실행 되는 구문이라면 a-b-c 단계를 거친다.
  : SQL 작성 규칙을 따르는 이유는 HARD parse를 줄이기 위해서이다(SQL문은 대/소문자 및 띄어쓰기를 다르게 인식한다.)
  a) Syntax check : SQL 문장의 문법이 맞는지를 확인
  b) Semantic & Privilege Check
  : 시맨틱 - 테이블 컬럼 확인
  : 권한 확인
  c) P_code + 실행계획생성
  : p_code = parse tree = parse form = cursor : 컴파일된 SQL문장
2. execute
  : redo log 버퍼에는 select 를 제외한 명령어가 항상 실행 전에 먼저 기록된다.
  : 변경작업을 할 때는 항상 execute 단계에서 DB Buffer Cache가 쌍으로 올라간다. (eg. 3000 -> 3300으로 수정할 때 3000, 3300 모두 올라가 있다가 commit/rollback시 사용된다.)
3. fetch (fetch는 select 구문에서만 일어남)

ORACLE 튜닝의 종류
1. DB Server 튜닝
  : 메모리, IO 등 튜닝
2. SQL 튜닝
  : 실행계획 확인 및 데이터 접근방법, JOIN방법 등 튜닝

DATABASE 구성
- data file
- redo log file : select 제외한 모든 명령어
- control file

릴레이션 : 논리적 테이블
테이블 : 물리적 릴레이션

## Optimizer
Optimizer의 종류
1. Rule Based Optimizer
2. Cost Based Optimizer
  : Oracle은 2를 권장한다

eg. 테이블 컬럼에 대한 통계 정보
SELECT COLUMN_NAME, NUM_DISTINCT, DENSITY
FROM USER_TAB_COL_STATISTICS
WHERE TABLE_NAME = 'CUSTOMERS';
: num_distinct - 컬럼의 unique 한 값의 개수

1. selectivity
  : DENSITY 에 대한 값
  SELECT * FROM CUSTOMER WHERE CUST_ID = "";
  와 같이 조회했을 때 이 조건에 의해서 access 해야 하는 data의 퍼센테이지
  : 1 / NUM_DISTINCT, 0~1사이의 값
  : %가 작을 수록 index scan이 선호되며, 클 수록 full scan이 선호된다.

2. cardinality
  : 처리해야 할 행의 개수

### 실행계획
콘솔 실행계획
explain plan for [쿼리];
실행의 결과가 plan_table 테이블에 저장된다

## Index
SELECT ROWID, ROWNUM, EMPLOYEE_ID, FIRST_NAME
  FROM EMPLOYEES;
ROWID, ROWNUM : 수도컬럼

SELECT *
  FROM EMP SAMPLE(10);
SAMPLE : 각각의 테이블에 대해서 10%의 ROWSAMPLE을 추출한다

SELECT *
  FROM EMP SAMPLE BLOCK(10);
BLOCK SAMPLE : 블록 내에서 10%의 BLOCKSAMPLE 을 추출한다
