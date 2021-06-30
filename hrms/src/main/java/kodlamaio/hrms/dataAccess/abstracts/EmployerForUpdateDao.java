package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerForUpdateDao extends JpaRepository<EmployerForUpdate, Integer>{

	EmployerForUpdate getEmployerForUpdateByEmployerId(int employerId);
}
