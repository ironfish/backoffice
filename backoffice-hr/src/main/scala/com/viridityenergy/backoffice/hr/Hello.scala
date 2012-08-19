package com.viridityenergy.backoffice.hr

import com.mongodb.casbah.Imports._

class Hello {
  def sayHello(): String = {
    // Connect to default - localhost, 27017
    val mongoConn = MongoConnection()
    val mongoDB = mongoConn("casbah_test")
    "hi"
  }
}