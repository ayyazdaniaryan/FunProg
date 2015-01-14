package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==0 || r==0 || r==c) 1
    else (pascal(c,r-1) + pascal(c-1,r-1))
  }
    
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    //Auxiliary function
    def bracketFinder(acc:Int, list: List[Char]): Boolean = {
      if (list.isEmpty) {acc == 0}
      else {
	      val head = list.head
	      val num = {
		      if(head == '(') acc +1
		      else if(head == ')') acc-1
		      else acc
	      }
	      if (num >= 0 ) bracketFinder(num, list.tail)
	      else false
      }
    }
    bracketFinder(0,chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    //refer to http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html#%_idx_722 for info
    if(money == 0) 1
    else if(money<0) 0
    else if(coins.isEmpty) 0
    else{
      countChange(money,coins.tail) + countChange(money-coins.head,coins)
    }
  }
}
