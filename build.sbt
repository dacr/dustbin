import AssemblyKeys._

seq(assemblySettings: _*)

name := "dustbin"

version := "0.0.1"

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

mainClass := Some("dummy.config.LoadConfig")

mainClass in assembly := Some("dummy.config.LoadConfig")

jarName in assembly := "dummy.jar"

libraryDependencies ++= Seq(
//  "org.reactivemongo" %% "reactivemongo" % "0.10.5"
//  "org.reactivemongo" %% "reactivemongo" % "0.11.0-SNAPSHOT"
  "com.twitter" %% "util-eval" % "6.29.0"
)

resolvers += "twitter" at "http://maven.twttr.com/"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.+" % "test"

libraryDependencies += "junit" % "junit" % "4.+" % "test"

initialCommands in console := """import dummy._"""

sourceGenerators in Compile <+= 
 (sourceManaged in Compile, version, name, jarName in assembly) map {
  (dir, version, projectname, jarexe) =>
  val file = dir / "dummy" / "MetaInfo.scala"
  IO.write(file,
  """package dummy
    |object MetaInfo { 
    |  val version="%s"
    |  val project="%s"
    |  val jarbasename="%s"
    |}
    |""".stripMargin.format(version, projectname, jarexe.split("[.]").head) )
  Seq(file)
}
