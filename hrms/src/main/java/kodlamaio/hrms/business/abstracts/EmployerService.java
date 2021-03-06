package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;
import kodlamaio.hrms.entities.dtos.EmployerForRegister;

public interface EmployerService {
	
	Result add(EmployerForRegister employerForRegister);
	
	Result update(EmployerForUpdate employerForUpdate);
	
	Result setUpdateConfirmed(int employerId, boolean isUpdateConfirmed);
	
	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getEmployerByEmployerId(int employerId);
}
