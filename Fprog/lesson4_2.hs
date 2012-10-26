data Tree = Node Tree Tree | Leaf
instance Show Tree where
	show (Node x y) = "(" ++ show x ++ show y ++ ")"
	show Leaf = "."

height Leaf = 0
height (Node x y) = 1 + max (height x) (height y)

fold f x p@Leaf = f x p 
fold f x (Nodw a b) = fold f(fold f ( f x p) a) b

nu,ber = fold (\ acc x -> acc +1 + x) 0

--�������� ������� ����������� � ����0�
-- data Tree = Node [Tree] ���������� ��� ���� ��� ������� � ��������� �������(������������ ���������� �����������)