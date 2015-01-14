package streams

object GameDefTests {
  import common._

  trait GameDef {
    case class Pos(x: Int, y: Int) {
      def dx(d: Int) = copy(x = x + d)
      def dy(d: Int) = copy(y = y + d)
    }

    val startPos: Pos
    val goal: Pos
    type Terrain = Pos => Boolean
    val terrain: Terrain

    sealed abstract class Move
    case object Left extends Move
    case object Right extends Move
    case object Up extends Move
    case object Down extends Move

    def startBlock: Block = Block(startPos, startPos)

    case class Block(b1: Pos, b2: Pos) {

      require(b1.x <= b2.x && b1.y <= b2.y, "Invalid block position: b1=" + b1 + ", b2=" + b2)

      def dx(d1: Int, d2: Int) = Block(b1.dx(d1), b2.dx(d2))

      def dy(d1: Int, d2: Int) = Block(b1.dy(d1), b2.dy(d2))

      def left = if (isStanding) dy(-2, -1)
      else if (b1.x == b2.x) dy(-1, -2)
      else dy(-1, -1)

      def right = if (isStanding) dy(1, 2)
      else if (b1.x == b2.x) dy(2, 1)
      else dy(1, 1)

      def up = if (isStanding) dx(-2, -1)
      else if (b1.x == b2.x) dx(-1, -1)
      else dx(-1, -2)

      def down = if (isStanding) dx(1, 2)
      else if (b1.x == b2.x) dx(1, 1)
      else dx(2, 1)

      def neighbors: List[(Block, Move)] = {
        val moves = List(Up, Down, Left, Right)
        val currBlock = this

        def allNeighbors(allMoves: List[Move], block: Block): List[(Block, Move)] = allMoves.head match {
          case List() => Nil
          case Up => List((block.up, Up)) ++ allNeighbors(allMoves.tail, block)
          case Down => List((block.down, Down)) ++ allNeighbors(allMoves.tail, block)
          case Left => List((block.left, Left)) ++ allNeighbors(allMoves.tail, block)
          case Right => List((block.right, Right)) ++ allNeighbors(allMoves.tail, block)
        }
        allNeighbors(moves, currBlock)
      }

      def legalNeighbors: List[(Block, Move)] = ???

      def isStanding: Boolean = b1.x == b2.x && b1.y == b2.y

      def isLegal: Boolean = terrain(b1) && terrain(b2)

    }
  }
}
