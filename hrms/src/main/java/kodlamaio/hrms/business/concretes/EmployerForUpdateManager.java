package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerForUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerForUpdateDao;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;

@Service
public class EmployerForUpdateManager implements EmployerForUpdateService{

	private EmployerForUpdateDao employerForUpdateDao;
	
	@Autowired
	public EmployerForUpdateManager(EmployerForUpdateDao employerForUpdateDao) {
		super();
		this.employerForUpdateDao = employerForUpdateDao;
	}

	@Override
	public DataResult<List<EmployerForUpdate>> getAll() {
		
		return new SuccessDataResult<List<EmployerForUpdate>>(this.employerForUpdateDao.findAll());
	}

	@Override
	public DataResult<EmployerForUpdate> getEmployerForUpdateByEmployerId(int employerId) {
		return new SuccessDataResult<EmployerForUpdate>(this.employerForUpdateDao.getEmployerForUpdateByEmployerId(employerId));
	}
	
	@Override
	public Result add(EmployerForUpdate employerForUpdate) {
		
		this.employerForUpdateDao.save(employerForUpdate);
		
		return new SuccessResult("İşlem Başarılı");
	}

	@Override
	public Result delete(EmployerForUpdate employerForUpdate) {
		
		this.employerForUpdateDao.delete(employerForUpdate);
		
		return new SuccessResult("Silindi");
	}

	

}
