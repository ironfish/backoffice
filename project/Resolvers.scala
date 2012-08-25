/**
 *  Copyright (C) 2012 Viridity Energy Inc. <http://www.viridityenergy.com>
 */

package backoffice

import sbt._
import sbt.Keys._

/**
 * Repositories build definition.
 */
object Resolvers {
  //  alias                   = "name"                   at "location"
  val ossSonatypeReleases     = "OSS Sonatype Releases"  at "https://oss.sonatype.org/content/repositories/releases"
  val ossSonatypeSnapshots    = "OSS Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  val sprayRepo               = "Spray Repo"             at "http://repo.spray.cc/"
  val scalaToolsRepoReleases  = "Scala Tools Releases"   at "http://scala-tools.org/repo-releases"
  val scalaToolsRepoSnapshots = "Scala Tools Snapshots"  at "http://scala-tools.org/repo-snapshots"
  val typeSafeRepo            = "Typesafe Repo"          at "http://repo.typesafe.com/typesafe/releases/"
}
