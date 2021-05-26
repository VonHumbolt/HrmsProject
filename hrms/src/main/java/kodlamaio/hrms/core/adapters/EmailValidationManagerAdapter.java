package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.fakeServices.EmailValidationManager;

@Service
public class EmailValidationManagerAdapter implements EmailService{

	@Override
	public boolean isEmailVerified() {
		
		EmailValidationManager emailValidationManager = new EmailValidationManager();
		
		boolean emailValidationResult = emailValidationManager.isEmailVerified();
		
		return emailValidationResult;
	}

}
