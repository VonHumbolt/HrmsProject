package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.AbilityDao;
import kodlamaio.hrms.entities.concretes.Ability;

@Service
public class AbilityManager implements AbilityService{

	private AbilityDao abilityDao;
	
	@Autowired
	public AbilityManager(AbilityDao abilityDao) {
		super();
		this.abilityDao = abilityDao;
	}
	
	@Override
	public Result add(Ability ability) {
		this.abilityDao.save(ability);
		
		return new SuccessResult("Yetenek Kaydedildi");
	}

	@Override
	public DataResult<List<Ability>> getAll() {
		
		return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll());
	}

	@Override
	public Result update(Ability ability) {
		
		Ability abilityFromDb = this.abilityDao.getOne(ability.getAbilityId());
		
		abilityFromDb.setTechnology(ability.getTechnology());
		
		this.abilityDao.save(abilityFromDb);
		
		return new SuccessResult("Güncellendi");
	}

	@Override
	public Result delete(Ability ability) {
		
		this.abilityDao.delete(ability);
		
		return new SuccessResult("Silme işlemi başarılı");
	}

}
