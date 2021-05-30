package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> sortByAdvertDate() {
		Sort sort = Sort.by(Direction.DESC, "deadline");
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "Tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_EmployerId(employerId));
	}

	@Override
	public Result closeJobAdvert(JobAdvert jobAdvert) {
		
		this.jobAdvertDao.delete(jobAdvert);
		
		return new SuccessResult("İlan Kapatıldı");
	}

	
}
