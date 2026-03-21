package com.gal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gal.model.Department;
import com.gal.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }

    // GET by ID
    @GetMapping(value="/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<?> getDepartment(@PathVariable int id) {

        log.info("Fetching department with id: {}", id);

        Department d = departmentService.find(id);

        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department with id " + id + " not found");
        }

        return ResponseEntity.ok(d);
    }

    // GET by name
    @GetMapping("/byname")
    public Department getDepartmentByName(@RequestParam("name") String name) {
        log.info("Fetching department by name: {}", name);
        return departmentService.findByName(name);
    }

    // POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Department addDepartment(@RequestBody Department department) {
        log.info("Adding new department: {}", department);
        departmentService.add(department);
        return department;
    }

    // PUT
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Department updateDepartment(@RequestBody Department department) {
        log.info("Updating department: {}", department);
        return departmentService.update(department);
    }

    // Latest
    @GetMapping("/latest")
    public Department getLatestDepartment() {
        log.info("Fetching latest department");
        return departmentService.getLatestDepartment();
    }

    // No manager
    @GetMapping("/no-manager")
    public List<Department> getDepartmentsWithoutManager() {
        log.info("Fetching departments without manager");
        return departmentService.getDepartmentsWithoutManager();
    }
}