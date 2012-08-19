package com.viridityenergy.backoffice.hr.model

import com.mongodb.casbah.Imports._
import org.scalatest.FunSuite

class EmployeeSuite() extends FunSuite {

  test("Create Employee - EmployeeSuite") {

    // create new employee
    val employee1 = Employee(name = "Duncan DeVore", age = Option(47), annualSalary = Option(50000))

    // insert employee
    val _id = EmployeeDAO.insert(employee1)

    // fetch employee just inserted
    val employee = EmployeeDAO.findOneById(_id.get)

    // verify origional employee id = fetched employee's id
    assert (employee.get.id === _id.get)

    println("BEFORE DROP " + EmployeeDAO.collection)
    EmployeeDAO.collection.drop
    println("AFTER DROP " + EmployeeDAO.collection)
  }
}
