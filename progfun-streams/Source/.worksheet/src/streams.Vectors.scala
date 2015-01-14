package streams

object Vectors {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(124); 
  val level = Vector(Vector('o', 'o', 'o'), Vector('o', 'o', 'o'), Vector('o', 'c', 'o'));System.out.println("""level  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(level ));$skip(51); 
  val row = level.indexWhere(v => v.contains('c'))

  case class Pos(val r: Int, val c: Int) {
    override def toString = "(" + r + "," + c + ")"
  };System.out.println("""row  : Int = """ + $show(row ));$skip(294); 
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val row = levelVector.indexWhere(v => v.contains('c'))
    val col = levelVector(row).indexOf('c')
    Pos(row, col)
  };System.out.println("""findChar: (c: Char, levelVector: Vector[Vector[Char]])streams.Vectors.Pos""");$skip(35); 

  val res = findChar('c', level);System.out.println("""res  : streams.Vectors.Pos = """ + $show(res ))}
  

}
