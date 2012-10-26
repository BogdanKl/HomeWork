data Bool = True | False
-- ��������������� ��� ������
-- ������������ True False
-- 
--data Person =    Person    String Int
-- ���/\�����������/\ ��������� /\

-- data <��� ����>= <�����������1> <���������>|
--			    	<�����������2> <���������>|
--					...

-- ��� ����������
--������������� � ��������
-- �������: 
--1. ident
-- 2.  �������������� �1 �2 �3
--                  �������
--[ident @] K p1 p2 p3
--3. _

--p@(Person name age)
--p@(Persi=on _ age)

-- case expr of
-- p1 -> expr1
-- p2 -> expr2
-- ...
-- pk -> exprk

-- v _ ������������� ������
-- v ident ������� �������������(??)
data User = Person String Int | Robot
instance Show User where
	show (Person name age) = "Name: "++ name ++ ", age:" ++ show age ++ "\n"
	show Robot = "Robot"