package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisService;
import kodlamaio.hrms.fakeServices.MernisValidationManager;

@Service
public class MernisValidationManagerAdapter implements MernisService{

	@Override
	public boolean isUserRealPerson() {
		
		MernisValidationManager mernisValidationManager = new MernisValidationManager();
		
		boolean isUserValidationResult =  mernisValidationManager.isUserReal();
		
		return isUserValidationResult;
	}

}
