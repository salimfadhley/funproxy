package web

import org.scalatest.FunSuite

/**
  * Created by salim on 06/02/2016.
  */
class ProxyModelTest extends FunSuite {

  val testEndpoints = EndpointInfo.makeFromStrings(List("http://foo.bar", "http://bar.foo"))

  test("Verify that we can access and increment the access count") {
    val m = new ProxyModel(testEndpoints)
    assert(m.getAndIncrementCount==0)
    assert(m.getAndIncrementCount==1)
    assert(m.getAndIncrementCount==2)
  }

  test("Verify that we can access and increment index pointer") {
    val m = new ProxyModel(testEndpoints)
    assert(m.getAndIncrementSourceIndex==0)
    assert(m.getAndIncrementSourceIndex==1)
    assert(m.getAndIncrementSourceIndex==0)
  }

}
