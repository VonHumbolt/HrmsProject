package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.abstracts.ImageUploadService;
import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager  implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private EmailService emailService;
	private MernisService mernisService;
	private ImageUploadService imageService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailService emailService, MernisService mernisService, ImageUploadService imageService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailService = emailService;
		this.mernisService = mernisService;
		this.imageService = imageService;
	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {

		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}


	@Override
	public Result add(JobSeeker jobSeeker) {
		
		JobSeeker jobSeekerFromDb = this.jobSeekerDao.findByNationalIdentity(jobSeeker.getNationalIdentity());
		
		if(!emailService.isEmailVerified()) {
			return new ErrorResult("Lütfen emailinize gelen doğrulama kodunu onaylayınız");
			
		}
		else if(!mernisService.isUserRealPerson()) {
			return new ErrorResult("Kimlik Bilgileri Hatalı");
		}
		else if(jobSeekerFromDb != null) {
			return new ErrorResult("Bu kimlik numarasıyla bir kayıt yapılmış.");
		}
		
		
		this.jobSeekerDao.save(jobSeeker);
		
		return new SuccessResult("Kayıt İşlemi tamamlandı.");
	}


	@Override
	public DataResult<Map> uploadImage(MultipartFile file) {
		
		Map map = this.imageService.uploadImage(file).getData();
		
		return new SuccessDataResult<Map>(map,"Resim eklendi");
	}
	
	

}
