data Bool = True | False
-- алгебрарический тип данных
-- конструкторы True False
-- 
--data Person =    Person    String Int
-- им€/\конструктор/\ аргументы /\

-- data <им€ типа>= < онструктор1> <аргументы>|
--			    	< онструктор2> <аргументы>|
--					...

-- как обращатьс€
--сопоставление с образцом
-- ќбразец: 
--1. ident
-- 2.  им€конструктра р1 р2 р3
--                  образцы
--[ident @] K p1 p2 p3
--3. _

--p@(Person name age)
--p@(Persi=on _ age)

-- case expr of
-- p1 -> expr1
-- p2 -> expr2
-- ...
-- pk -> exprk

-- v _ сопоставление удачно
-- v ident удачное сопоставление(??)
data User = Person String Int | Robot
instance Show User where
	show (Person name age) = "Name: "++ name ++ ", age:" ++ show age ++ "\n"
	show Robot = "Robot"