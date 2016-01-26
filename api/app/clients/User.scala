package clients

import io.flow.user.v0.Client

class User {
  val userPort = 8001
  val client = new Client(s"http://localhost:$userPort", auth = Some(io.flow.user.v0.Authorization.Basic("test")))
}
