package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	
	@Autowired
	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@Override
	public DataResult<User> login(User user) {
		
		User userFromDb = this.userService.getUserByEmail(user.getEmail()).getData();
		
		if(userFromDb == null) {
			
			return new ErrorDataResult<User>("Email ile kayıtlı hesap bulunamadı");
		}else {
			if(userFromDb.getPassword().matches(user.getPassword())) {
				return new SuccessDataResult<User>(userFromDb, "Oturum açıldı.");
			}
			
			return new ErrorDataResult<User>("Email veya parola hatalı");
		}
		
	}

	
}
