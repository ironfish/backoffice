package com.viridityenergy.backoffice.hr

import com.mongodb.casbah.Imports._
import com.viridityenergy.backoffice.core.common.Logging

object BackOfficeHr extends App with Logging {

  // val logger: Logger = LoggerFactory.getLogger(this.getClass)

  backOfficeHr
  println(dbHello)

  def backOfficeHr {
    // logger.debug("IN METHOD BACK_OFFICE_HR")
    debug("IN METHOD BACK_OFFICE_HR")
    println("Back Office Human Resources.")
  }

  def dbHello(): String = {
    // Connect to default - localhost, 27017
    // logger.debug("IN METHOD DB_HELLO")
    debug("IN METHOD DB_HELLO")
    val mongoConn = MongoConnection()
    val mongoDB   = mongoConn("backoffice")
    "hi there"
  }
}
