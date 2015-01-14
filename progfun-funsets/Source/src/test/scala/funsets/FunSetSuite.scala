package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  ignore("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  ignore("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  ignore("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(2)
    val s5 = singletonSet(5)
    val s6 = singletonSet(-1)
    val s7 = singletonSet(7)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect contains only 2"){
    new TestSets{
      val s = intersect(s1,s2)
      val q = intersect(s2,s4)
      assert(!contains(s,2), "Intersect of 1 & 2 does not contain 2")
      assert(contains(q,2), "Intersect of 2 & 2 contains 2")
    }
  }
  
  test("difference test"){
    new TestSets{
      val diff1 = diff(s1,s2)
      val diff2 = diff(s2,s4)
      assert(contains(diff1,1), "Diff of s1 and s2 does not contains s1")
      assert(!contains(diff2,2), "Diff of s2 & s4 contains s2")
    }
  }
    
  test("forall test"){
    new TestSets{
    	val s = union(s1,s2)
    	val t = union(s1,s6)
    	val result1 = forall(s, x=> x>0)
    	val result2 = forall(t, x=> x>0)
    	assert(result1==true, "Union set of 1 & 2 are not positive")
    	assert(result2==false, "Union set of 1 & -1 are positive")
    }
  } 
    
    test("exists test"){
    new TestSets{
    	val s = union(s1,s2) //1,2
    	val t = union(s3,s6) //3,-1
    	val b = union(s,t)
    	val result1 = exists(b, x=> x== (-1))
    	val result2 = exists(b, x=> x>10)
    	assert(result1==true, "Set 1,2,3,-1 did not contain -1")
    	assert(result2==false, "Set 1,2,3,-1 contained larger than 10")
    	}
    }
    
    test("map test"){
    new TestSets{
    	val s = union(s1,s2) //1,2
    	val t = union(s3,s7) //3,7
    	val b = union(s,t) //1,2,3,7
    	val result = map(b, x => x*x) //1,4,9,49
    	assert(contains(result,1), "Set 1,4,9,49 did not contain 1")
    	assert(contains(result,4), "Set 1,4,9,49 did not contain 4")
    	assert(!contains(result,7), "Set 1,4,9,49 contained 7")
    }    
  } 
}
