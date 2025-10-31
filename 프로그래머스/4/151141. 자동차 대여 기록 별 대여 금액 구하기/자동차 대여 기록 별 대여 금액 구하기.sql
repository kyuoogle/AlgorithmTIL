-- 트럭에 대한 기본 대여 정보를 CTE로 추출
WITH value AS (
  SELECT
    car.daily_fee,                 -- 차량의 일일 요금
    car.car_type,                  -- 차량 종류 (트럭만 필터링할 예정)
    his.history_id,                -- 대여 이력 고유 ID
    DATEDIFF(his.end_date, his.start_date) + 1 AS period  -- 대여 기간(종료일-시작일+1)
  FROM car_rental_company_rental_history AS his
  JOIN car_rental_company_car AS car
    ON car.car_id = his.car_id
  WHERE car.car_type = '트럭'      -- 문제 조건: 트럭만 계산 대상
)

-- CTE로 만든 value 테이블을 기반으로 할인 정책과 결합해 요금 계산
SELECT
  v.history_id,  -- 각 대여 기록의 고유 ID
  ROUND(         -- 문제에서 요구: 원 단위 반올림 처리
        v.daily_fee * v.period * (1 - IFNULL(p.discount_rate, 0) / 100)
  ) AS fee        -- 총 대여 요금 계산식 (할인율이 없으면 0%)
FROM value v
LEFT JOIN car_rental_company_discount_plan p
  ON p.car_type = v.car_type  -- 동일한 차종의 할인 정책만 적용
  AND (
      -- 할인 정책은 기간 구간별(duration_type)로 나누어져 있음.
      -- 따라서 대여일수(period)가 해당 구간에 속할 때만 조인 조건을 만족시킴.
      (p.duration_type = '90일 이상' AND v.period >= 90) OR
      (p.duration_type = '30일 이상' AND v.period BETWEEN 30 AND 89) OR
      (p.duration_type = '7일 이상'  AND v.period BETWEEN 7  AND 29)
    )
--   LEFT JOIN인 이유:
--   - 할인 조건에 맞지 않으면 p.discount_rate가 NULL -> IFNULL로 0% 할인 처리.
--   - 즉, 단기 대여(7일 미만)도 결과에 포함됨.

ORDER BY fee DESC, v.history_id DESC;
-- 대여 금액(FEE)이 높은 순으로 우선 정렬
-- 금액이 같을 경우 HISTORY_ID 내림차순으로 정렬
