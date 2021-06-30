package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.UserImage;

public interface UserImageDao extends JpaRepository<UserImage, Integer> {
	
	@Query("From UserImage u where u.resume.resumeId=:resumeId ")
	UserImage getUserImageByResumeId(int resumeId);
	
	@Query("From UserImage u where u.resume.resumeId=:jobSeekerId ")
	UserImage getUserImageByJobSeekerId(int jobSeekerId);
}
