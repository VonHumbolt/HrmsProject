package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;
import kodlamaio.hrms.entities.dtos.EmployerForRegister;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailService emailService;
	
	@Autowired 
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(EmployerForRegister employerForRegister) { 
		
		if(this.emailService.isEmailVerified()) {
			
			if(this.employerDao.getEmployerByEmail(employerForRegister.getEmail()) == null) {
				
				Employer employer = new Employer();
				employer.setCompanyName(employerForRegister.getCompanyName());
				employer.setWebSite(employerForRegister.getWebsite());
				employer.setEmailVertification(true);
				employer.setEmail(employerForRegister.getEmail());
				employer.setPhoneNumber(employerForRegister.getPhoneNumber());
				employer.setPassword(employerForRegister.getPassword());
				
				this.employerDao.save(employer);
				
				return new SuccessResult("Kayıt Başarılı");
			}
			
			return new SuccessResult("Bu email ile zaten bir hesap oluşturulmuş!");
		}
		return new ErrorResult("Email Doğrulama kodunuzu onaylayınız.");
		
	}
	
	@Override
	public Result update(EmployerForUpdate employerForUpdate) {
		
		Employer employerFromDb = this.employerDao.getOne(employerForUpdate.getEmployerId());
		
		employerFromDb.setCompanyName(employerForUpdate.getNewCompanyName());
		employerFromDb.setWebSite(employerForUpdate.getNewWebSite());
		employerFromDb.setPhoneNumber(employerForUpdate.getNewPhoneNumber());
		employerFromDb.setUpdateConfirmed(true);
		employerFromDb.setEmail(employerForUpdate.getNewEmail());
		
		this.employerDao.save(employerFromDb);
		
		return new SuccessResult("Kayıt başarıyla güncellendi");
	}

	@Override
	public DataResult<Employer> getEmployerByEmployerId(int employerId) {
		
		return new SuccessDataResult<Employer>(this.employerDao.getEmployerByUserId(employerId));

	}

	@Override
	public Result setUpdateConfirmed(int employerId, boolean isUpdateConfirmed) {
		
		Employer employerForDb = this.employerDao.getOne(employerId);
		
		employerForDb.setUpdateConfirmed(isUpdateConfirmed);
		this.employerDao.save(employerForDb);
		
		return new SuccessResult();
	}




}
