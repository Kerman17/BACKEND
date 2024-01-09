package com.utcn.employeeapplication.department;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @Transactional
    public Department getDepartment(int id) { return departmentRepository.findDepartmentByID(id); }

    @Transactional
    public Department updateDepartment(int id, Department department)
    {
        Department updatedDepartment = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found!"));
        updatedDepartment.setDescription(department.getDescription());
        updatedDepartment.setManagerID(department.getManagerID());
        updatedDepartment.setParentID(department.getParentID());
        return departmentRepository.save(updatedDepartment);
    }

    @Transactional
    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
