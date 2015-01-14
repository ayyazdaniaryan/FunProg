package example

object ListWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(229); 
	  def sum(xs: List[Int]): Int = {
    def adder(accum: Int, list: List[Int]): Int ={
      if (list.isEmpty) accum
      else adder(accum + list.head, list.tail)
    }
    adder(0, xs)
  };System.out.println("""sum: (xs: List[Int])Int""");$skip(340); 

  def max(xs: List[Int]): Int = {
    if (xs.isEmpty) throw new NoSuchElementException

    def maxFinder(maxNum: Int, list: List[Int]): Int = {
      if (list.isEmpty) maxNum
      else {
        var max = if (maxNum > list.head) maxNum else list.head
        maxFinder(max, list.tail)
      }
    }
    maxFinder(xs.head, xs.tail)
  };System.out.println("""max: (xs: List[Int])Int""");$skip(36); 
  val list = List(-10,-5,-2,2,5,10);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(28); 
  
  val summer = sum(list);System.out.println("""summer  : Int = """ + $show(summer ));$skip(26); 
  val maximum = max(list);System.out.println("""maximum  : Int = """ + $show(maximum ))}
  
}
