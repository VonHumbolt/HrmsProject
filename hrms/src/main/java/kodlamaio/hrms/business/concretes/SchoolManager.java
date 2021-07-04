package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> sortedByGraduationYearSchools() {
		return new SuccessDataResult<List<School>>(this.schoolDao.sortedByGraduationYearSchools());
	}

	@Override
	public Result add(School school) {
		
		this.schoolDao.save(school);
		
		return new SuccessResult("Yeni okul eklendi");
	}

	@Override
	public Result update(School school) {
		
		School schoolFromDb = this.schoolDao.getOne(school.getSchoolId());
		
		schoolFromDb.setSchoolName(school.getSchoolName());
		schoolFromDb.setSchoolDepartment(school.getSchoolDepartment());
		schoolFromDb.setStartYear(school.getStartYear());
		schoolFromDb.setGraduationYear(school.getGraduationYear());
		
		this.schoolDao.save(schoolFromDb);
		
		return new SuccessResult("Güncelleme Başarılı");
	}
	

}
