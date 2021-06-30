package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobAdvert;

@RestController
@RequestMapping("/api/favoriteJobAdverts/")
@CrossOrigin
public class FavoriteJobAdvertsController {

	private FavoriteJobAdvertService favoriteJobAdvertService;

	@Autowired
	public FavoriteJobAdvertsController(FavoriteJobAdvertService favoriteJobAdvertService) {
		super();
		this.favoriteJobAdvertService = favoriteJobAdvertService;
	}
	
	
	@GetMapping("getFavoriteJobAdvertByJobSeekerId")
	public DataResult<List<FavoriteJobAdvert>> getFavoriteJobAdvertByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.favoriteJobAdvertService.getFavoriteJobAdvertsByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("getFavoriteJobAdvertByFavoriteId")
	public DataResult<FavoriteJobAdvert> getFavoriteJobAdvertByFavotiteId(@RequestParam int favoriteId) {
		return this.favoriteJobAdvertService.getFavoriteJobAdvertByFavoriteId(favoriteId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody FavoriteJobAdvert favoriteJobAdvert) {
		return this.favoriteJobAdvertService.add(favoriteJobAdvert);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody FavoriteJobAdvert favoriteJobAdvert) {
		return this.favoriteJobAdvertService.delete(favoriteJobAdvert);
	}

}
