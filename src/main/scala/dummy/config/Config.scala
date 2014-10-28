package dummy.config

trait Config {
  private var _name:String="default"
  private var _release:String=""
  private var _services:Set[Service] = Set.empty
  private var _servers:Set[Server] = Set.empty
  
  def name = _name
  protected def name_=(n:String) {_name = n}

  def release = _release
  protected def release_=(n:String) {_release = n}

  def servers = _servers
  def services = _services
  
  def add(srv:Server) {_servers += srv}
  def add(svc:Service) {_services += svc}
  
  def server(name:String, host:String) {
    _servers += Server(name, host)
  }
}
