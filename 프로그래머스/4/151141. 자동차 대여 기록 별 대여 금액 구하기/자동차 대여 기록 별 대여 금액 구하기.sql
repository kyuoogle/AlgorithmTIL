WITH value AS (
  SELECT
    car.daily_fee,
    car.car_type,
    his.history_id,
    DATEDIFF(his.end_date, his.start_date) + 1 AS period
  FROM car_rental_company_rental_history AS his
  JOIN car_rental_company_car AS car
    ON car.car_id = his.car_id
  WHERE car.car_type = '트럭'
)
SELECT
  v.history_id,
  ROUND(v.daily_fee * v.period * (1 - IFNULL(p.discount_rate, 0) / 100)) AS fee
FROM value v
LEFT JOIN car_rental_company_discount_plan p
  ON p.car_type = v.car_type
 AND (
      (p.duration_type = '90일 이상' AND v.period >= 90) OR
      (p.duration_type = '30일 이상' AND v.period >= 30 AND v.period < 90) OR
      (p.duration_type = '7일 이상'  AND v.period >= 7  AND v.period < 30)
    )
ORDER BY fee DESC, v.history_id DESC;