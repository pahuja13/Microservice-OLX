package com.zensar.olxMasterDataService.repository;

import com.zensar.olxMasterDataService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findDepartmentById(Long departmentId);
}
