package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	DataResult<List<JobExperience>> sortedJobExperienceByYear();

	Result add(JobExperience jobExperience);
	
	Result update(JobExperience jobExperience);
	
	Result delete(JobExperience jobExperience);
}
