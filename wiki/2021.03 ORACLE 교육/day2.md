## INDEX
- 오라클의 색인은 컬럼을 기반으로 만든다
- 오라클의 색인은 데이터와 인덱스 데이터를 저장하여 관리하는데, 두 개의 데이터를 분리해서 관리한다.

- 인덱스의 leaf에서 branch로는 다시 올라가지 않는다. 그리고 각 leaf들은 더블링크 구조로 되어있다.
- 인덱스는 select성능을 높이기 위한 것이기 때문에 DML 성능은 오히려 떨어진다.
- 대용량 데이터를 INSERT 할 때 성능을 높이기 위하여 제약조건을 disable, INDEX drop 을 한 후 대용량 데이터를 INSERT 하고 제약조건을 enable, INDEX create 를 실행한다.
- INDEX에 대해서 DML 은 DELETE, INSERT의 개념만 있다.
- 오라클은 리프 블럭에 대해서 10%의 여유공간을 남겨놓는데, 이 10%의 공간은 가변길이 데이터에 대한 여유 공간으로 사용한다.
- INDEX 공간은 테이블과 다르게 비어있는 공간의 재사용이 불가능하다.
- 오라클의 인덱스는 B-tree 구조라서, 트리의 밸런스를 맞추려고 노력한다. 이 밸런스가 깨졌을 때, 오라클은 tree를 재구성한다.
- tree의 레벨이 너무 깊어졌을 때(= Table data가 너무 많아졌을 때) 사용하는 방식이 partition 이다. (partiton 별로 index가 만들어지기 때문에)
- oracle 데이터는 bottom-up 으로 쌓인다(아래에서 위로 쌓인다)

alter session set statistics_level = all;
1. 인덱스 고유 스캔(Index Unique Scan)
2. 인덱스 범위 스캔
3. 인덱스 전체 스캔
4. 인덱스 빠른 전체 스캔
5. 인덱스 조인
6. 인덱스 스킵 스캔

E-Rows : estimate rows 처리를 위해 예상되는 데이터의 건수
A-Rows : acutial rows 실체 처리한 데이터의 건수
buffers : access한 block의 건수
e-rows와 a-rows 차이가 없으면 통계가 잘 만들어져 있다고 이야기한다.

- 실행계획 읽는 법
  : 가장 많이 들여쓰기가 된 것부터 읽으면 된다
  : 같은 들여쓰기 LEVEL 에서는 위에서부터 아래로 읽으면 된다.
  : 같은 자리에 최대로 올 수 있는 실행계획의 개수는 2개이다
    eg ) 1.
            2.
              2-1
              2-2
            3.
- 인덱스끼리의 join은 rowid를 사용하여 return 결과를 return 한다.
- 인덱스 힌트 이용 : full / no index / index
  select /*+ full(customers) */ cust_city, cust_year_of_birth, cust_id
  from customers
  where cust_last_name LIKE 'S%';
