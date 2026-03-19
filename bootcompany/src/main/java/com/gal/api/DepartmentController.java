package com.gal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // GET by ID
    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    public ResponseEntity getDepartment(@PathVariable int departmentId) {
        log.debug("Request for department with id: {}", departmentId);

        Department d = departmentService.find(departmentId);

        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department with id " + departmentId + " not found");
        }

        return ResponseEntity.ok(d);
    }

    // GET by name
    @RequestMapping(value = "/byname", method = RequestMethod.GET)
    public Department getDepartmentByName(@RequestParam("name") String name) {
        log.info("Fetching department by name: {}", name);
        return departmentService.findByName(name);
    }

    // POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
     Department addDepartment(@RequestBody Department department) {
        log.debug("Adding new department: {}", department);
        departmentService.add(department);
        return department;
    }

    // PUT (update)
    @RequestMapping(value = "", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    public Department updateDepartment(@RequestBody Department department) {
        log.info("Updating department: {}", department);
        return departmentService.update(department);
    }

    // GET latest department
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public Department getLatestDepartment() {
        log.info("Fetching latest department");
        return departmentService.getLatestDepartment();
    }

    // GET departments without manager
    @RequestMapping(value = "/no-manager", method = RequestMethod.GET)
    public List<Department> getDepartmentsWithoutManager() {
        log.info("Fetching departments without manager");
        return departmentService.getDepartmentsWithoutManager();
    }
}