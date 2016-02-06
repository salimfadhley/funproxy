package web

import org.scalatest.FunSuite

/**
  * Created by salim on 05/02/2016.
  */
class JsonDecodeTest extends FunSuite {

  test("Simple JSON Decode") {
    val json:String = "{\"endpoints\":[{\"url\":\"http://foo\"}]}"
    val result:EndpointInfo = JsonDecode.decodeEndpointInfoList(json)
    val expected:EndpointInfo = new EndpointInfo(List(new SingleEndpointInfo("http://foo")))
    assert(result==expected)
  }

  test("Two-line JSON Decode") {
    val json:String = "{\"endpoints\":[{\"url\":\"http://foo\"}, {\"url\":\"http://bar\"}]}"
    val result:EndpointInfo = JsonDecode.decodeEndpointInfoList(json)
    val expected:EndpointInfo = new EndpointInfo(List(new SingleEndpointInfo("http://foo"), new SingleEndpointInfo("http://bar")))
    assert(result==expected)
  }



}
