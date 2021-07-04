package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	
	DataResult<List<SystemPersonnel>> getAll();
	
	DataResult<SystemPersonnel> getBySystemPersonnelId(int systemPersonnelId);
	
	Result add(SystemPersonnel systemPersonnel);
	
	Result update(SystemPersonnel systemPersonnel);
}
