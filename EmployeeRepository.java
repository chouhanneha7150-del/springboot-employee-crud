package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}