package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserImage;

public interface UserImageService {
	
	DataResult<UserImage> getUserImageByResumeId(int resumeId);
	
	DataResult<UserImage> getUserImageByJobSeekerId(int jobSeekerId);
	
	Result add(int jobSeekerId ,int resumeId, MultipartFile multipartFile);
}
