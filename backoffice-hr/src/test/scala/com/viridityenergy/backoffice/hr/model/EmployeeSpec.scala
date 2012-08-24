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
      info("I want to insure that the employee document is updated")

    scenario("a new employee is inserted") {

      given("a new employee and a collection count of 0")
      assert(EmployeeDAO.collection.size === 0)
      val newEmployee = Employee(name = "Sean Walsh", age = Option(47), annualSalary = Option(55000))

      when("the new employee is inserted")
      val newEmployeeId = EmployeeDAO.insert(newEmployee)

      then("the colletion count should be 1")
      assert(EmployeeDAO.collection.size === 1)
    }

    scenario("a new employee is inserted then read") {

      given("a new employee and a collection count of 0")
      assert(EmployeeDAO.collection.size === 0)
      val newEmployee = Employee(name = "Duncan DeVore", age = Option(47), annualSalary = Option(55000))

      when("the new employee is inserted and the inserted employee is found by the new employee id")
      val newEmployeeId = EmployeeDAO.insert(newEmployee)
      val insertedEmployee = EmployeeDAO.findOneById(newEmployeeId.get)

      then("the inserted employee id should equal the new employee id")
      assert (insertedEmployee.get.id === newEmployeeId.get)
    }

    scenario("a new employee is inserted then read then updated") {

      given("a new employee and a collection count of 0")
      assert(EmployeeDAO.collection.size === 0)
      val newEmployee = Employee(name = "Craig Stewart", age = Option(43), annualSalary = Option(55000))

      when("the new employee is inserted and the inserted employee is found by the new employee id")
      val newEmployeeId = EmployeeDAO.insert(newEmployee)
      val insertedEmployee = EmployeeDAO.findOneById(newEmployeeId.get)

      then("the inserted employee id should equal the new employee id")
      assert (insertedEmployee.get.id === newEmployeeId.get)

      when("the inserted employee is copied and the annualSalary is updated")
      val updatedEmployee = insertedEmployee.get.copy(annualSalary = Option(650000))
      EmployeeDAO.update(MongoDBObject("_id" -> insertedEmployee.get.id), updatedEmployee, false, false, new WriteConcern)

      then("the fetched updated employee id equals the new employee id and the salary has been updated")
      val fetchedUpdatedEmployee = EmployeeDAO.findOneById(insertedEmployee.get.id)
      assert (fetchedUpdatedEmployee.get.id === newEmployeeId.get)
      assert (fetchedUpdatedEmployee.get.annualSalary === Option(650000))
    }

    scenario("Delete Employee") (pending)
  }
}
