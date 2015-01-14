package streams

object Vectors {
  val level = Vector(Vector('o', 'o', 'o'), Vector('o', 'o', 'o'), Vector('o', 'c', 'o'))
                                                  //> level  : scala.collection.immutable.Vector[scala.collection.immutable.Vector
                                                  //| [Char]] = Vector(Vector(o, o, o), Vector(o, o, o), Vector(o, c, o))
  val row = level.indexWhere(v => v.contains('c'))//> row  : Int = 2

  case class Pos(val r: Int, val c: Int) {
    override def toString = "(" + r + "," + c + ")"
  }
  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val row = levelVector.indexWhere(v => v.contains('c'))
    val col = levelVector(row).indexOf('c')
    Pos(row, col)
  }                                               //> findChar: (c: Char, levelVector: Vector[Vector[Char]])streams.Vectors.Pos

  val res = findChar('c', level)                  //> res  : streams.Vectors.Pos = (2,1)
  

}