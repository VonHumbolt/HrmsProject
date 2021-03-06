package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}
	
	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Cv Kaydedildi");
	}

	@Override
	public Result update(Resume resume) {
		Resume resumeFromDb = this.resumeDao.getOne(resume.getResumeId());
		
		resumeFromDb.setGithubAddress(resume.getGithubAddress());
		resumeFromDb.setLinkedinAdress(resume.getLinkedinAdress());
		resumeFromDb.setCoverLetter(resume.getCoverLetter());
		
		this.resumeDao.save(resumeFromDb);
		
		return new SuccessResult("Cv Güncellendi");
	}

	@Override
	public Result delete(Resume resume) {
		this.resumeDao.delete(resume);
		
		return new SuccessResult("Cv Silindi");
	}
	
	@Override
	public DataResult<List<Resume>> getAll() {
		
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll());
	}

	@Override
	public DataResult<Resume> getResumeByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<Resume>(this.resumeDao.getResumeByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<Resume> getResumeByResumeId(int resumeId) {
		
		return new SuccessDataResult<Resume>(this.resumeDao.getResumeByResumeId(resumeId));
	}

}
