package ru.andreyBaranov.employee.api.exceptions

import org.springframework.http.HttpStatus


class EmployeeNotFoundException(httpStatus: HttpStatus, message: String): Exception ()