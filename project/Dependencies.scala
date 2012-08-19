/**
 *  Copyright (C) 2012 Viridity Energy Inc. <http://www.viridityenergy.com>
 */

package backoffice

import sbt._
import sbt.Keys._

/**
 * Dependencies build definition.
 */
object Dependencies {

  // versions
  val logbackVer = "1.0.3"

  // library dependencies
  //  alias          = "groupID"             % "artifactID"      % "revision" % "configuration"
  val akka           = "com.typesafe.akka"   % "akka-actor"      % "2.0.2"
//  val casbah         = "com.mongodb.casbah"  % "casbah_2.9.0-1"  % "2.1.5.0"
  val casbah         = "org.mongodb"        %% "casbah"          % "2.3.0"
  val logbackClassic = "ch.qos.logback"      % "logback-classic" % logbackVer
  val logbackCore    = "ch.qos.logback"      % "logack-core"     % logbackVer
  val mockito        = "org.mockito"         % "mockito-core"    % "1.9.0"    % "test"
  val salat          = "com.novus"          %% "salat"           % "1.9.0"
  val scalatest      = "org.scalatest"      %% "scalatest"       % "1.8"    % "test"
  val slf4j          = "org.slf4j"           % "slf4j-api"       % "1.6.4"
  val testng         = "org.testng"          % "testng"          % "6.5.2"    % "test"
}
