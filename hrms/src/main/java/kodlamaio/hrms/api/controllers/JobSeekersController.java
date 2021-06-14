package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerDetailsDto;

@RestController
@RequestMapping("/api/jobSeekers")
@CrossOrigin
public class JobSeekersController {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("/getAllJobSeekerDtos")
	public DataResult<List<JobSeekerDetailsDto>> getJobSeekerDetailsDtos() {
		return this.jobSeekerService.getJobSeekerDetailsDtos();
	}
	
	@GetMapping("/getJobSeekerDtoByJobSeekerId")
	public DataResult<JobSeekerDetailsDto> getJobSeekerDetailDtoByJobSeekerId(int jobSeekerId) {
		return this.jobSeekerService.getJobSeekerDetailDtoByJobSeekerId(jobSeekerId);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);
	}
	
	@PostMapping("/uploadImage")
	public DataResult<Map> uploadImage(@RequestParam MultipartFile file) {
		return this.jobSeekerService.uploadImage(file);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationErrors(MethodArgumentNotValidException exceptions) {
		Map<String, String> errors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return new ErrorDataResult<Object>(errors, "Doğrulama Hataları");
	}
}
