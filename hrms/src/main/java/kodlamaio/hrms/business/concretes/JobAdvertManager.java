package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

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
import kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto;

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
	public DataResult<List<JobAdvert>> getByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_EmployerId(employerId));
	}

	@Override
	public Result closeJobAdvert(JobAdvert jobAdvert) {
		
		JobAdvert jobAdvertFromDb = this.jobAdvertDao.getOne(jobAdvert.getAdvertId());
		
		//jobAdvertFromDb.setActive(false);
		
		return new SuccessResult("İlan Kapatıldı");
	}

	@Override
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtos() {
		
		return new SuccessDataResult<List<JobAdvertDetailsDto>>(this.jobAdvertDao.getJobAdvertDetailsDtos(),"Details Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtosByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertDetailsDto>>(this.jobAdvertDao.getJobAdvertDetailsByEmployerId(employerId));
	}

	@Override
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsSortedByDeadline() {
		
		return new SuccessDataResult<List<JobAdvertDetailsDto>>(this.jobAdvertDao.getJobAdvertDetailsSortedByDeadline(), "Tarihe göre listelendi");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		
		this.jobAdvertDao.save(jobAdvert);
		
		return new SuccessResult("İş İlani Oluşturuldu!");
	}

	@Override
	public DataResult<JobAdvertDetailsDto> getJobAdvertDtoByAdvertId(int advertId) {
		
		return new SuccessDataResult<JobAdvertDetailsDto>(this.jobAdvertDao.getJobAdvertDtoByAdvertId(advertId)); 
	}

	
}
