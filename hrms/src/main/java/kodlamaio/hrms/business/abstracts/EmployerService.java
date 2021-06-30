package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerService {
	
	Result add(Employer employer);
	
	Result update(EmployerForUpdate employerForUpdate);
	
	Result setUpdateConfirmed(int employerId, boolean isUpdateConfirmed);
	
	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getEmployerByEmployerId(int employerId);
}
