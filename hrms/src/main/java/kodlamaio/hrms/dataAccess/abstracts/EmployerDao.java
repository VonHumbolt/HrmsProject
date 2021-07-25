package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer , Integer>{
	
	@Query("From Employer e where e.userId=:employerId")
	Employer getEmployerByUserId(int employerId);

	
	@Query("From Employer e where e.isUpdateConfirmed=false")
	Employer getUnconfirmedEmployer();
	
	Employer getEmployerByEmail(String email);
}
