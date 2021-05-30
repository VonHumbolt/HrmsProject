package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<List<JobAdvert>> sortByAdvertDate();
	
	DataResult<List<JobAdvert>> getByEmployerId(int employerId);
	
	Result closeJobAdvert(JobAdvert jobAdvert);
}
