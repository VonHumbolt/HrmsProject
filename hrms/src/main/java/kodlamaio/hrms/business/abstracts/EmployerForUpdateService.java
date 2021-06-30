package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerForUpdateService {

	DataResult<List<EmployerForUpdate>> getAll();
	
	DataResult<EmployerForUpdate> getEmployerForUpdateByEmployerId(int employerId);
	
	Result add(EmployerForUpdate employerForUpdate);
	
	Result delete(EmployerForUpdate employerForUpdate);
}
