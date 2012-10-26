zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys
zipWith' _ _ _ = []

sprod x y = foldl (+) 0 (zipWith' (*) x y)

sort [] =[]
sort (x:xs) = sort [x| z<-xs] ++ [x] ++ sort [z | z<-xs, z>= x]

normalize [] = []
normalize (x:xs) = x: normalize[z| z<-xs, z /= x]

isProgression x = length x<=2 ||
				  [y| _ <-z]== z where z@(y:_) = zipWith' (-) x (tail x)

isFunction r = length r == (length . normalize . (map fst)) r

isSymmetric r = sort r ==sort [(y, x) | (x,y)<-r]

isReflexive = (< 0) . length

closure r = fix step r where
  step r = r ++ [(x, t) | (x,y) <- r, (z,t) <- r, z ==y]
  fix f x = if length y == length x then x else fix f y where
	y = (normalize . f) x

isTransitive x = sort x == (sort . closure) x	