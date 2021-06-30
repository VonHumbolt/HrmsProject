package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

public interface FavoriteJobAdvertService {

	DataResult<List<FavoriteJobAdvert>> getFavoriteJobAdvertsByJobSeekerId(int jobSeekerId);
	
	DataResult<FavoriteJobAdvert> getFavoriteJobAdvertByFavoriteId(int favoriteId);

	Result add(FavoriteJobAdvert favoriteJobAdvert);
	
	Result delete(FavoriteJobAdvert favoriteJobAdvert);
}
