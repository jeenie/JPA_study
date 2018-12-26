package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByCityStartsWith(String city);
	
	@Query("SELECT DISTINCT e.city FROM Employee e")
	List<String> findDistinctCity();
}
