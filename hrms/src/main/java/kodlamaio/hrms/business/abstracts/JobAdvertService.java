package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<JobAdvertDetailsDto> getJobAdvertDtoByAdvertId(int advertId);
	
	DataResult<List<JobAdvert>> getByEmployerId(int employerId);
	
	Result closeJobAdvert(JobAdvert jobAdvert);
	
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtos();
	
	DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtosByEmployerId(int employerId);
	
	DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsSortedByDeadline();
}
