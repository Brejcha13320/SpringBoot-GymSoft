package co.edu.usbcali.gymsoft.repository;

import co.edu.usbcali.gymsoft.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    //List<Employee> findAllByUserId(Integer userId);
    boolean existsByEmail(String email);

}
