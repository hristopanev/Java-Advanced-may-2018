DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters varchar(50), word VARCHAR(50))
RETURNS int
READS SQL DATA
DETERMINISTIC
BEGIN
	declare result int;
    declare ind int;
    declare val int;
    declare size int;
    set size := length(word);
    set ind := 1;
    set result := 1;
    
    while(ind <= size) do
		set val := (select instr(set_of_letters, substring(word, ind, 1)));
			if(val = 0) then
				set result = 0;
				return result;
			end if;
		set ind = ind +1;
	end while;
    RETURN result;
END $$
