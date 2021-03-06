package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll()); 
	}


	@Override
	public DataResult<User> getUserById(int userId) {
		return new SuccessDataResult<User>(this.userDao.getOne(userId));
	}


	@Override
	public DataResult<User> getUserByEmail(String email) {
		
		if(this.userDao.findByEmail(email) == null) {
			return new ErrorDataResult<User>("Bu Emaile sahip kullanıcı bulunamadı");
		}
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

	
	
}
