package com.viridityenergy.backoffice.hr.model

import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoConnection

case class Employee(@Key("_id") id: ObjectId = new ObjectId, name: String, age: Option[Int], annualSalary: Option[BigDecimal])

object EmployeeDAO extends SalatDAO[Employee, ObjectId](collection = MongoConnection()("backoffice_db")("employees"))

// object Employee {

//   def readAll(): List[Employee] = EmployeeDAO.find(MongoDBObject.empty).toList

//   def readOneById(id: Int): Option[Employee] = EmployeeDAO.findOneById(id = id)

//   def create(employee: Employee) { EmployeeDAO.insert(employee) }

//   def delete(employee: Employee) { EmployeeDAO.remove(employee) }
// }
