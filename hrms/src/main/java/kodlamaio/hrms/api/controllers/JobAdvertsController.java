package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertDetailsDto;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getJobAdvertDetails")
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtos(){
		return this.jobAdvertService.getJobAdvertDetailsDtos();
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvert>> getByEmployerId(@RequestParam int employerId){
		return this.jobAdvertService.getByEmployerId(employerId);
	}
	
	@GetMapping("/getJobAdvertByEmployerId")
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtosByEmployerId(@RequestParam int employerId){
		return this.jobAdvertService.getJobAdvertDetailsDtosByEmployerId(employerId);
	}
	
	
	@PostMapping("/closeJobAdvert")
	public Result closeJobAdvert(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.closeJobAdvert(jobAdvert);
	}
	
	@GetMapping("/sortedByDeadline")
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsSortedByDeadline(){
		return this.jobAdvertService.getJobAdvertDetailsSortedByDeadline();
	}
}
