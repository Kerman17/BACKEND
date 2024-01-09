package com.utcn.employeeapplication.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.create(department);
    }

    @GetMapping("/getAll")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public Department getDepartment(@PathVariable int id) {return departmentService.getDepartment(id);}

    @PutMapping(value = "/update/{id}")
    public Department updateDepartment(@PathVariable int id,@RequestBody Department department)
    {
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
    }


}
