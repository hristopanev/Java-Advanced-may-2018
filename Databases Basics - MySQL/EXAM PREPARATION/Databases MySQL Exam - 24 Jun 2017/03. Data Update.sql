UPDATE problems AS p
join contests as c
on c.id = p.contest_id
join categories as cat
on cat.id=c.category_id
join submissions as s
on p.id = s.problem_id
 set p.tests =(
   case p.id %3
       when 0 then length(cat.name)
       when 1 then (select sum(s.id) from submissions as s where s.problem_id=p.id)
       when 2 then length(c.name)
		END	)
where p.tests = 0;