import scala.util.{Success, Failure}
import com.ning.http.client.AsyncHttpClient
import play.api.libs.ws.WSResponse
import play.api.libs.ws.ning.NingWSClient
import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

val wsClient = NingWSClient()
val eventualResponse: Future[WSResponse] = wsClient
  .url("http://audio.resonancefm.com/hooting_yard/")
  .get()

eventualResponse.onComplete {
  case Success(data) => data.body
  case Failure(err) => s"Error hath occured ${err.getMessage}"
}

