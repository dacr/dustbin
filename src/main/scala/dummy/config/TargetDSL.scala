package dummy.config

trait Service {
}

case class SSH(alias:String, port: Int, username: String) extends Service

case class HTTP(alias:String, port: Int) extends Service

case class Server(name: String, ip: String) {
  def services(svcs: Service*): Server = {
    this
  }
}

case class Target(name: String, servers:List[Server]=List.empty) {
  def withServers(newServers: Server*) = Target(name, servers++newServers)
}
