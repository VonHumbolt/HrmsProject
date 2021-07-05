package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(Resume resume);
	
	Result update(Resume resume);
	
	Result delete(Resume resume);
	
	DataResult<List<Resume>> getAll();

	DataResult<Resume> getResumeByJobSeekerId(int jobSeekerId);
	
	DataResult<Resume> getResumeByResumeId(int resumeId);
}
