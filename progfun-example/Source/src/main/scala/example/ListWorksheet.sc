package example

object ListWorksheet {
	  def sum(xs: List[Int]): Int = {
    def adder(accum: Int, list: List[Int]): Int ={
      if (list.isEmpty) accum
      else adder(accum + list.head, list.tail)
    }
    adder(0, xs)
  }                                               //> sum: (xs: List[Int])Int

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
  }                                               //> max: (xs: List[Int])Int
  val list = List(-10,-5,-2,2,5,10)               //> list  : List[Int] = List(-10, -5, -2, 2, 5, 10)
  
  val summer = sum(list)                          //> summer  : Int = 0
  val maximum = max(list)                         //> maximum  : Int = 10
  
}