package ru.andreyBaranov.employee.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.andreyBaranov.employee.api.repository.model.Employee

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>