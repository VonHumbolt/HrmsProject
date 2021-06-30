package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{

	private SystemPersonnelDao systemPersonelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonelDao) {
		super();
		this.systemPersonelDao = systemPersonelDao;
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonelDao.findAll()); 
	}


	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		 
		this.systemPersonelDao.save(systemPersonnel);
		
		return new SuccessResult("Kayıt başarılı");
	}

}
