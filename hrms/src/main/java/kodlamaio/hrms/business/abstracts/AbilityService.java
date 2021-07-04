package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Ability;

public interface AbilityService {
	
	Result add(Ability ability);
	
	Result update(Ability ability);
	
	Result delete(Ability ability);
	
	DataResult<List<Ability>> getAll();
}
