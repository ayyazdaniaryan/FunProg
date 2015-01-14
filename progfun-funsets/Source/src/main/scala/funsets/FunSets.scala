package funsets

import common._

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = { x => x==elem }  

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = { x=> contains(s, x) || contains(t, x) }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = { x=> contains(s,x) && contains(t,x)  }

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = { x => if(!contains(t,x)) contains(s,x) else false}

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = {x => if(p(x)) contains(s,x) else false}

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true //iteration continuity
      else if (contains(s,a)) { p(a) && iter(a+1) } //test that all elements in the set pass the function 
      else iter(a+1)
    }
    iter(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  //if p(x) gives false (does not match), new function gives true for !p(x). If all of set does not match, 
  //then forall returns true, so it does not exist at all (!forall for exist). Otherwise, if there is 
  //even 1 case where !p(x) is false, then p(x) is true, there is a match, and forall will be false, !forall is true.
  
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s, x => !p(x))

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  //An item x only exists in transformed set if there exists another item y that is part of the 
  //initial set and for which f(y) = x
  /*
   * Conceptually, if you map a set X into a set Y through a function f: X -> Y, then 
   * an element y of Y is in f(X), iff there exists an x in X such that f(x) = y. 
   * */
  def map(s: Set, f: Int => Int): Set = { y => exists(s, x=> { f(x)== y} ) }

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
