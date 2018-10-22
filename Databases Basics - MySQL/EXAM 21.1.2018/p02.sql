UPDATE journeys AS j
SET j.purpose =  CASE
			WHEN j.id MOD 2 = 0 THEN 'Medical'
            WHEN j.id MOD 3 = 0 THEN 'Technical'
            WHEN j.id MOD 5 = 0 THEN 'Educational'
            WHEN j.id MOD 7 = 0 THEN 'Military'
			END;
