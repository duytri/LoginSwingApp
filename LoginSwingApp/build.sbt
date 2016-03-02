import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._

name := "LoginSwingApp"
version := "0.1-SNAPSHOT"
organization := "uit.islab"
scalaVersion := "2.10.6"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.10+"
