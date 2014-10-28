package dummy.config

import java.io.File
import scala.io.Source
import com.twitter.util.Eval

object LoadConfig {
  val configFilename = "target.xconf"

  def main(args: Array[String]) {
    val config = load()
    println(config.name)
  }

  def load(): Config = {
    val eval = new Eval()
    eval[Config](new File(configFilename))
  }
}