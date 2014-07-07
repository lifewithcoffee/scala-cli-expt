import AssemblyKeys._ // put this at the top of the file

name := "scala-cli-expt"

version := "1.0"

// additional dependencies
// =======================
libraryDependencies += "org.rogach" %% "scallop" % "0.9.5"

// plugins
// =======
assemblySettings  // sbt-assembly (for packaging fat jar)