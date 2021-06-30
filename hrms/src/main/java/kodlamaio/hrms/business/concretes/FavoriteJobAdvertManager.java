package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobAdvertDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

@Service
public class FavoriteJobAdvertManager implements  FavoriteJobAdvertService{

	private FavoriteJobAdvertDao favoriteJobAdvertDao;

	@Autowired
	public FavoriteJobAdvertManager(FavoriteJobAdvertDao favoriteJobAdvertDao) {
		super();
		this.favoriteJobAdvertDao = favoriteJobAdvertDao;
	}

	@Override
	public DataResult<List<FavoriteJobAdvert>> getFavoriteJobAdvertsByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<List<FavoriteJobAdvert>>(this.favoriteJobAdvertDao.getFavoriteJobAdvertByJobSeekerId(jobSeekerId));
	}

	@Override
	public DataResult<FavoriteJobAdvert> getFavoriteJobAdvertByFavoriteId(int favoriteId) {
		
		return new SuccessDataResult<FavoriteJobAdvert>(this.favoriteJobAdvertDao.getOne(favoriteId));
	}

	@Override
	public Result add(FavoriteJobAdvert favoriteJobAdvert) {
		
		this.favoriteJobAdvertDao.save(favoriteJobAdvert);
		
		return new SuccessResult("Favorilere eklendi");
	}

	@Override
	public Result delete(FavoriteJobAdvert favoriteJobAdvert) { 
		
		this.favoriteJobAdvertDao.delete(favoriteJobAdvert);;
		return new SuccessResult("Favorilerden kaldırıldı");
	}

}
