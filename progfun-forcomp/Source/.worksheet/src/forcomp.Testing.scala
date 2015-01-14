package forcomp

object Testing {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(169); 
  
  val occ = Anagrams.wordOccurrences("eat");System.out.println("""occ  : forcomp.Anagrams.Occurrences = """ + $show(occ ));$skip(24); 
  val (c,i) = occ.unzip;System.out.println("""c  : List[Char] = """ + $show(c ));System.out.println("""i  : List[Int] = """ + $show(i ))}
}
