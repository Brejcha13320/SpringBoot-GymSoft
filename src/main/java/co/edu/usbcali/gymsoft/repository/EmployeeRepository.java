package co.edu.usbcali.gymsoft.repository;

import co.edu.usbcali.gymsoft.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
}
