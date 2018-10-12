UPDATE tickets AS t
SET t.price = t.price * 1.5
#WHERE t.fligth_id IN (SELECT f.flight_id
#					FROM flights AS f
 #                   INNER JOIN airlines AS a
  #                  ON f.airline_id = a.airline_id
   #                 WHERE a.rating = (SELECT
	#								MAX(a.rating)
     #                               FROM airlines AS a));