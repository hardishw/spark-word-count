name := "sparkWordCount"

version := "1.0"

scalaVersion := "2.11.0"

// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.3.0" % "provided"
)