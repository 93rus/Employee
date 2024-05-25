package ru.andreyBaranov.employee.api.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import ru.andreyBaranov.employee.api.exceptions.EmployeeNotFoundException
import ru.andreyBaranov.employee.api.repository.model.Employee
import ru.andreyBaranov.employee.api.repository.EmployeeRepository
import java.util.*

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeeById(employeeId: Long): Optional<Employee> = employeeRepository.findById(employeeId)
        ?: throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "Сотрудник с $employeeId не найден")

    fun createEmployee(employee: Employee): Employee = employeeRepository.save(employee)

    fun updateEmployee(employeeId: Long, employee: Employee): Employee {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                Employee(
                    id = employee.id,
                    userName = employee.userName,
                    firstName = employee.firstName,
                    middleName = employee.middleName,
                    lastName = employee.lastName,
                    emailId = employee.emailId,
                    birthDay = employee.birthDay
                )
            )
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "Сотрудник с $employeeId не найден")
    }

    fun deleteEmployeeById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "Сотрудник с $employeeId не найден")
    }
}