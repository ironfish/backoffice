/**
 *  Copyright (C) 2012 Viridity Energy Inc. <http://www.viridityenergy.com>
 */

package backoffice

import sbt._
import sbt.Keys._
import Dependencies._
import Resolvers._

object BackOfficeBuild extends Build {

  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.viridityenergy",
    version       := "2.0-SNAPSHOT",
    scalaVersion  := "2.9.2",
    scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
    parallelExecution in Test := false,
    publishArtifact := true,
    // artifactName := { ( config: String, module: ModuleID, artifact: Artifact) =>
    //   artifact.classifier match {
    //     case Some("javadoc") => artifact.name + "-" + module.revision + "-javadoc." + artifact.extension
    //     case Some("sources") => artifact.name + "-" + module.revision + "-sources." + artifact.extension
    //     case Some("test") => artifact.name + "-" + module.revision + "-test." + artifact.extension
    //     case Some("test-javadoc") => artifact.name + "-" + module.revision + "-test-javadoc." + artifact.extension
    //     case Some("test-sources") => artifact.name + "-" + module.revision + "-test-sources." + artifact.extension
    //     case Some(classifier) =>  artifact.name + "-" + module.revision + "-" + artifact.classifier + "." + artifact.extension
    //     case None => artifact.name + "-" + module.revision + "." + artifact.extension
    //   }
    // },
    crossPaths := false,
    resolvers ++= Seq(ossSonatype, scalaToolsRepoReleases, scalaToolsRepoSnapshots, sprayRepo, typeSafeRepo)
  )

  lazy val backOffice = Project(
    id = "backoffice",
    base = file("."),
    settings = buildSettings,
    aggregate = Seq(backOfficeCore, backOfficeHr, backOfficeAr)

  )

  lazy val backOfficeCore = Project(
    id = "backoffice-core",
    base = file("backoffice-core"),
    settings = buildSettings ++ Seq(
      description := "Back Office Core",
      libraryDependencies ++= Seq(akka, casbah, logbackClassic, mockito, scalatest, slf4j, testng)
    )
  )

  lazy val backOfficeHr = Project(
    id = "backoffice-hr",
    base = file("backoffice-hr"),
    settings = buildSettings ++ Seq(
      description := "Back Office Human Resources",
      libraryDependencies ++= Seq(akka, casbah, mockito, salat, scalatest, testng)
    )
  ) dependsOn(backOfficeCore)

  lazy val backOfficeAr = Project(
    id = "backoffice-ar",
    base = file("backoffice-ar"),
    settings = buildSettings ++ Seq(
      description := "Back Office Accounts Receivable",
      libraryDependencies ++= Seq(akka, casbah, mockito, salat, sprayCan, sprayClient, sprayServer, scalatest, testng)
    )
  )
}
