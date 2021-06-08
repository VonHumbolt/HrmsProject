package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto;

public interface JobSeekerDao extends JpaRepository<JobSeeker , Integer>{
	
	JobSeeker findByNationalIdentity(String nationalIdentity);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto(j.jobSeekerId, jp.jobPositionName, j.firstName, j.lastName, j.nationalIdentity, j.dateOfBorn)" + 
			"From JobSeeker j Inner Join j.jobPosition jp")
	List<JobSeekerDetailsDto> getJobSeekerDetailsDtos();
}
