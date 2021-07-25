package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegister;

public interface JobSeekerService {
	
	Result add(JobSeekerForRegister jobSeekerForRegister);
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<List<JobSeekerDetailsDto>> getJobSeekerDetailsDtos();
	
	DataResult<JobSeekerDetailsDto> getJobSeekerDetailDtoByJobSeekerId(int jobSeekerId);
}
