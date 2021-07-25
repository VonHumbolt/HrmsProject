package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto;

public interface JobSeekerDao extends JpaRepository<JobSeeker , Integer>{
	
	JobSeeker findByNationalIdentity(String nationalIdentity);
	
	JobSeeker findByEmail(String email);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto(j.userId, jp.jobPositionName, j.firstName, j.lastName, j.nationalIdentity, j.dateOfBorn, i.imageUrl)" + 
			"From JobSeeker j Inner Join j.jobPosition jp Inner Join j.userImage i")
	List<JobSeekerDetailsDto> getJobSeekerDetailsDtos();
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto(j.userId, jp.jobPositionName, j.firstName, j.lastName, j.nationalIdentity, j.dateOfBorn, i.imageUrl)" + 
			"From JobSeeker j Inner Join j.jobPosition jp Inner Join j.userImage i where j.userId=:jobSeekerId")
	JobSeekerDetailsDto getJobSeekerDetailDtoByJobSeekerId(int jobSeekerId);
}
