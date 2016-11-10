import AssemblyKeys._

name := "Spark_study"
version := "1.0"
scalaVersion := "2.10.4"
libraryDependencies ++= Seq( 
	"org.apache.spark" %% "spark-core" % "2.0.1" % "provided"
)

assemblySettings

jarName in assembly := "my-project-assembly.jar"

assemblyOption in assembly := 
  ( assemblyOption in assembly ).value.copy(includeScala = false)