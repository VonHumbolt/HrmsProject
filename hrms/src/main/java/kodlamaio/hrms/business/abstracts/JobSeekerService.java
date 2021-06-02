package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<Map> uploadImage(MultipartFile file);
}
