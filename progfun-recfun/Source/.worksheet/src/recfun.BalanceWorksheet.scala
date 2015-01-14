package recfun

object BalanceWorksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(451); 
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
  };System.out.println("""balance: (chars: List[Char])Boolean""");$skip(64); val res$0 = 
  
  balance("(the sky is nigh) when (I feel like sky)".toList);System.out.println("""res0: Boolean = """ + $show(res$0))}
}
