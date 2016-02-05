package web

import org.scalatest.FunSuite

/**
  * Created by salim on 05/02/2016.
  */
class JsonDecodeTest extends FunSuite {

  test("Simple JSON Decode") {
    val json:String = "[{\"url\":\"http://foo\"}]"
    val result:List[EndpointInfo] = JsonDecode.decodeEndpointInfoList(json)
    val expected:List[EndpointInfo] = List(new EndpointInfo("http://foo"))
    assert(result==expected)
  }

  test("Two-line JSON Decode") {
    val json:String = "[{\"url\":\"http://foo\"}, {\"url\":\"http://bar\"}]"
    val result:List[EndpointInfo] = JsonDecode.decodeEndpointInfoList(json)
    val expected:List[EndpointInfo] = List(new EndpointInfo("http://foo"), new EndpointInfo("http://bar"))
    assert(result==expected)
  }



}
