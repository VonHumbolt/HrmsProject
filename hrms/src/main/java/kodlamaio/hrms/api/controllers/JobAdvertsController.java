package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll() {
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize) {
		return this.jobAdvertService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getJobAdvertDtoByAdvertId")
	public DataResult<JobAdvertDetailsDto> getJobAdvertDtoByAdvertId(@RequestParam int advertId) {
		return this.jobAdvertService.getJobAdvertDtoByAdvertId(advertId);
	}
	
	@GetMapping("/getJobAdvertDetails")
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsDtos(){
		return this.jobAdvertService.getJobAdvertDetailsDtos();
	}
	
	@GetMapping("/getPassiveJobAdvertDetails")
	public DataResult<List<JobAdvertDetailsDto>> getPassiveJobAdvertDetailsDtos() {
		return this.jobAdvertService.getPassiveJobAdvertDetailsDtos();
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
	
	@PostMapping("/approveJobAdvert")
	public Result approveJobAdvert(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.approveJobAdvert(jobAdvert);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/sortedByDeadline")
	public DataResult<List<JobAdvertDetailsDto>> getJobAdvertDetailsSortedByDeadline(){
		return this.jobAdvertService.getJobAdvertDetailsSortedByDeadline();
	}
}
