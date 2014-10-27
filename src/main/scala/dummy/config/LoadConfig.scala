package dummy.config

import java.io.File
import scala.io.Source
import com.twitter.util.Eval

object LoadConfig {
  val configFilename = "project.xconf"

  def main(args: Array[String]) {
    val config = load()
    println(config.project.name)
  }

  def load(): Config = {
    val configIntern = Source.fromFile(configFilename).getLines.toList
    val config = (
      ("import dummy.config.dsl._" ::
        "import dummy.config._" ::
        "new Config {" ::
        configIntern) :+ "}").mkString("\n")

    println(config)
    val eval = new Eval()

    eval[Config](config, true)
  }
}