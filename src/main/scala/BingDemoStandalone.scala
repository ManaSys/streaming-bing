import java.util.Date

import com.github.catalystcode.fortis.spark.streaming.bing.BingAuth
import com.github.catalystcode.fortis.spark.streaming.bing.client.BingCustomSearchClient

class BingDemoStandalone(auth: BingAuth) {
  def run(): Unit = {
    val date = Some(new Date(new Date().getTime - 3600000 /* 1 hour */))
    val searchInstanceId = System.getenv("BING_SEARCH_INSTANCE_ID")
    val keywords = List("al shabaab", "isis")
    println(new BingCustomSearchClient(searchInstanceId, keywords, auth, 10).loadNewPostings.toList)
  }
}
