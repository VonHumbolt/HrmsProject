package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume , Integer>{

	@Query("From Resume r where r.jobSeeker.jobSeekerId=:jobSeekerId")
	Resume getResumeByJobSeekerId(int jobSeekerId);
	
	@Query("From Resume r where r.resumeId=:resumeId")
	Resume getResumeByResumeId(int resumeId);
	
}
