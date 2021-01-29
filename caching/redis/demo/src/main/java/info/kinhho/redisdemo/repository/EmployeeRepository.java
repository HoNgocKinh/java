package info.kinhho.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.kinhho.redisdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
