package ru.andreyBaranov.employee.api.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.andreyBaranov.employee.api.repository.model.Employee
import ru.andreyBaranov.employee.api.service.EmployeeService

@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployee(): List<Employee> = employeeService.getAllEmployees()

    @GetMapping("/employee/{id}")
    fun getEmployeeById(@PathVariable("id") employeeId: Long): Employee =
        employeeService.getEmployeeById(employeeId)

    @PostMapping("/employee")
    fun createEmployee(@RequestBody payload: Employee): Employee = employeeService.createEmployee(payload)

    @PutMapping("/employee/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @RequestBody payload: Employee): Employee =
        employeeService.updateEmployee(employeeId, payload)

    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable("id") employeeId: Long) = employeeService.deleteEmployeeById(employeeId)

}