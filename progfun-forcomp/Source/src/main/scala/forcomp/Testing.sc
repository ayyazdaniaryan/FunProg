package forcomp

object Testing {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)]
  
  val occ = Anagrams.wordOccurrences("eat")       //> occ  : forcomp.Anagrams.Occurrences = List((a,1), (e,1), (t,1))
  val (c,i) = occ.unzip                           //> c  : List[Char] = List(a, e, t)
                                                  //| i  : List[Int] = List(1, 1, 1)
}