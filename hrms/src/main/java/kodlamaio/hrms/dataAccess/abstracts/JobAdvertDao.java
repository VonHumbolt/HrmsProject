package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>  {
	
	List<JobAdvert> getByEmployer_EmployerId(int employerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto(j.id, e.companyName, jb.jobPositionName, j.countOfJob, j.publishedDate, j.deadline)" + 
			"From JobAdvert j Inner Join j.employer e Inner Join j.jobPosition jb where j.isActive=true")
	List<JobAdvertDetailsDto> getJobAdvertDetailsDtos();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto(j.id, e.companyName, jb.jobPositionName, j.countOfJob, j.publishedDate, j.deadline)" + 
			"From JobAdvert j Inner Join j.jobPosition jb Inner Join j.employer e where e.employerId=:employerId and j.isActive=true")
	List<JobAdvertDetailsDto> getJobAdvertDetailsByEmployerId(int employerId);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto(j.id, e.companyName, jb.jobPositionName, j.countOfJob, j.publishedDate, j.deadline)" + 
			"From JobAdvert j Inner Join j.jobPosition jb Inner Join j.employer e Order By j.deadline DESC")
	List<JobAdvertDetailsDto> getJobAdvertDetailsSortedByDeadline();
}
