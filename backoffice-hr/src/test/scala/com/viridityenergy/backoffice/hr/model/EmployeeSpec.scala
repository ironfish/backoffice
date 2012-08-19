package com.viridityenergy.backoffice.hr.model

import com.mongodb.casbah.Imports._
import org.scalatest.FeatureSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.GivenWhenThen

class EmployeeSpec extends FeatureSpec with GivenWhenThen with BeforeAndAfter {

  after {
    // make sure the collection is cleard after each test
    EmployeeDAO.collection.drop
  }

  feature("CRUD functionality for Employee") {

      info("As a programmer")
      info("I want to insure that an employee document is inserted")
      info("I want to insure that the employee document is read")

    scenario("a new employee is inserted") {

      given("a new employee and a collection count of 0")
      assert(EmployeeDAO.collection.size === 0)
      val employee1 = Employee(name = "Sean Walsh", age = Option(47), annualSalary = Option(55000))

      when("the employee is inserted")
      val _id = EmployeeDAO.insert(employee1)

      then("the colletion count should be 1")
      assert(EmployeeDAO.collection.size === 1)
    }

    scenario("a new employee is inserted then read") {

      given("a new employee and a collection count of 0")
      assert(EmployeeDAO.collection.size === 0)
      val employee1 = Employee(name = "Sean Walsh", age = Option(47), annualSalary = Option(55000))

      when("the employee is inserted and read by id")
      val _id = EmployeeDAO.insert(employee1)
      val employee = EmployeeDAO.findOneById(_id.get)

      then("the read employees id should equal the _id resulting from the insert")
      assert (employee.get.id === _id.get)
    }

    // scenario("Update Employee") (pending)

    // scenario("Delete Employee") (pending)
  }
}
