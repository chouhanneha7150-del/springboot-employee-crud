package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import model.Employee;
import repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @PostMapping
    public Employee add(@RequestBody Employee emp) {
        return repo.save(emp);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable String id) {
        return repo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee emp) {
        emp.setId(id);
        return repo.save(emp);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        repo.deleteById(id);
        return "Deleted";
    }
}