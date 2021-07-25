package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto;
import kodlamaio.hrms.entities.dtos.JobSeekerForRegister;

@Service
public class JobSeekerManager  implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private EmailService emailService;
	private MernisService mernisService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailService emailService, MernisService mernisService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailService = emailService;
		this.mernisService = mernisService;
	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeekerForRegister jobSeekerForRegister) {
		
		if(emailService.isEmailVerified()) {
			
			if(mernisService.isUserRealPerson()) {
				
				if(this.jobSeekerDao.findByNationalIdentity(jobSeekerForRegister.getNationalIdentity()) == null) {
					
					if(this.jobSeekerDao.findByEmail(jobSeekerForRegister.getEmail()) == null) {
						
						JobSeeker jobSeeker = new JobSeeker();
						
						jobSeeker.setFirstName(jobSeekerForRegister.getFirstName());
						jobSeeker.setLastName(jobSeekerForRegister.getLastName());
						jobSeeker.setNationalIdentity(jobSeekerForRegister.getNationalIdentity());
						jobSeeker.setDateOfBorn(jobSeekerForRegister.getDateOfBorn());
						jobSeeker.setFirstName(jobSeekerForRegister.getFirstName());
						jobSeeker.setEmail(jobSeekerForRegister.getEmail());
						jobSeeker.setPassword(jobSeekerForRegister.getPassword());
						
						this.jobSeekerDao.save(jobSeeker);
						
						return new SuccessResult("Kullanıcı oluşturuldu");
					}
					return new ErrorResult("Bu Email ile bir kayıt yapılmış.");
				}
				return new ErrorResult("Bu kimlik numarasıyla bir kayıt yapılmış.");
				
			}
			return new ErrorResult("Kimlik Bilgileri Hatalı");
		}
		return new ErrorResult("Lütfen emailinize gelen doğrulama kodunu onaylayınız");
	
	}


	@Override
	public DataResult<List<JobSeekerDetailsDto>> getJobSeekerDetailsDtos() {
		
		return new SuccessDataResult<List<JobSeekerDetailsDto>>(this.jobSeekerDao.getJobSeekerDetailsDtos());
	}


	@Override
	public DataResult<JobSeekerDetailsDto> getJobSeekerDetailDtoByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<JobSeekerDetailsDto>(this.jobSeekerDao.getJobSeekerDetailDtoByJobSeekerId(jobSeekerId));
	}
	
	

}
