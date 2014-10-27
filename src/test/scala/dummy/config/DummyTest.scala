/*
 * Copyright 2014 David Crosson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dummy.config

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.ShouldMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DummyTest extends FunSuite with ShouldMatchers {

  test("Simple test") {
    
    import dummy.config.dsl._

    val ssh=SSH("default", 22, "anonymous")
    
    val s1 = Server("hostA", "192.168.2.10").services(ssh)
    val s2 = Server("hostB", "192.168.2.11").services(ssh)
    val s3 = Server("hostC", "192.168.2.12").services(ssh)

    Project("zorglub").withServers(s1,s2,s3)
  }

}
