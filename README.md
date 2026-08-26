# Employee Payroll System

A simple Java console application that models a company payroll system using **OOP principles** — abstraction, inheritance, and polymorphism. It supports full-time and part-time employees, each with their own salary calculation logic, managed through a central payroll system.

## Features

- Add employees (full-time or part-time) to the payroll system
- Remove employees by ID
- Display all employees with their calculated salary
- Salary calculation is polymorphic — each employee subtype defines its own logic

## Class Structure

| Class | Description |
|---|---|
| `Employee` (abstract) | Base class holding common fields (`name`, `id`) and declaring the abstract `calculateSalary()` method |
| `fullTimeEmployee` | Extends `Employee`; salary = fixed `monthlySalary` |
| `partTimeEmployee` | Extends `Employee`; salary = `hoursWorked * hourlyRate` |
| `payRollSystem` | Manages a list of `Employee` objects — add, remove, and display |
| `Main` | Entry point demonstrating the system with sample data |

### UML-style overview

```
Employee (abstract)
 ├── fullTimeEmployee
 └── partTimeEmployee

payRollSystem
 └── uses ArrayList<Employee>
```

## Getting Started

### Run it

```bash
# Compile
javac org/example/Main.java

# Run
java org.example.Main
```

## Sample Output

```
Initial Employee Details: 
Employee [name=Vikas, id=1, salary=70000.0]
Employee [name=Roy, id=2, salary=4000.0]
Removing Employees
Remaining Emploees: 
Employee [name=Vikas, id=1, salary=70000.0]
```

## Concepts Demonstrated

- **Abstraction** — `Employee` defines a contract (`calculateSalary()`) without implementing it
- **Inheritance** — `fullTimeEmployee` and `partTimeEmployee` inherit shared fields/behavior from `Employee`
- **Polymorphism** — `payRollSystem.displayEmployee()` calls `calculateSalary()` on each object without knowing its concrete type
- **Encapsulation** — Fields are private, accessed via getters

## Possible Improvements

- Fix typo: `Emploees` → `Employees` in output message
- Add input validation (e.g., negative salary/hours)
- Add unit tests (JUnit)
- Support updating employee details
- Persist employee data to a file or database
