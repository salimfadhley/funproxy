import dispatch.{ Defaults, Http, Req, as, implyRequestHandlerTuple, url }
import scala.concurrent.Future
import scala.concurrent.ExecutionContext._

val request: Req = url.apply("http://google.com")

val result: Future[String] =
  Http.apply(
    implyRequestHandlerTuple(request).OK[String](as.String)
  )(Defaults.executor)


result.wait()

