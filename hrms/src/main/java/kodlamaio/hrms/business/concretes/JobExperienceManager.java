package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> sortedJobExperienceByYear() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.sortedJobExperienceByYear());
	}

	@Override
	public Result add(JobExperience jobExperience) {
		
		this.jobExperienceDao.save(jobExperience);
		
		return new SuccessResult("Başarıyla eklendi");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		
		JobExperience jobExperienceFromDb = this.jobExperienceDao.getOne(jobExperience.getExperienceId());
		
		jobExperienceFromDb.setWorkPlaceName(jobExperience.getWorkPlaceName());
		jobExperienceFromDb.setPosition(jobExperience.getPosition());
		jobExperienceFromDb.setStartYear(jobExperience.getStartYear());
		jobExperienceFromDb.setEndYear(jobExperience.getEndYear());
		
		this.jobExperienceDao.save(jobExperienceFromDb);
		
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(JobExperience jobExperience) {
		
		this.jobExperienceDao.delete(jobExperience);
		
		return new SuccessResult("Job Experience Silindi");
	}

	
}
