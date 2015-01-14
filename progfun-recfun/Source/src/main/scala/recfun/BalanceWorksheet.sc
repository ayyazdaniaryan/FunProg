package recfun

object BalanceWorksheet {
 def balance(chars: List[Char]): Boolean = {
    //Auxiliary function
    if (chars.isEmpty) true
    def bracketFinder(acc:Int, list: List[Char]): Boolean = {
      if (list.isEmpty && acc ==0) true
      else {
        var adder = 0
        if(list.head == '(') adder = adder+1
        if(list.head == ')') adder = adder-1
        bracketFinder(adder, list.tail)
      }
    }
    bracketFinder(0,chars)
  }                                               //> balance: (chars: List[Char])Boolean
  
  balance("(the sky is nigh) when (I feel like sky)".toList)
                                                  //> java.util.NoSuchElementException: head of empty list
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:337)
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:334)
                                                  //| 	at recfun.BalanceWorksheet$$anonfun$main$1.bracketFinder$1(recfun.Balanc
                                                  //| eWorksheet.scala:11)
                                                  //| 	at recfun.BalanceWorksheet$$anonfun$main$1.balance$1(recfun.BalanceWorks
                                                  //| heet.scala:16)
                                                  //| 	at recfun.BalanceWorksheet$$anonfun$main$1.apply$mcV$sp(recfun.BalanceWo
                                                  //| rksheet.scala:19)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at recfun.BalanceWorksheet$.main(recfun.BalanceWorksheet.scala:3)
                                                  //| 	at recfun.BalanceWorksheet.main(recfun.BalanceWorksheet.scala)
}