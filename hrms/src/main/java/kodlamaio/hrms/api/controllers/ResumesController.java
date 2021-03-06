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

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

@RestController 
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {

	private ResumeService resumeService;
	
	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Resume>> getAll() {
		return this.resumeService.getAll();
	}
	
	@GetMapping("/getResumeByJobSeekerId")
	public DataResult<Resume> getResumeByJobSeekerId(@RequestParam int jobSeekerId){
		return this.resumeService.getResumeByJobSeekerId(jobSeekerId);
	}
	
	@GetMapping("/getResumeByResumeId")
	public DataResult<Resume> getResumeByResumeId(@RequestParam int resumeId) {
		return this.resumeService.getResumeByResumeId(resumeId);
	};
	
	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Resume resume) {
		return this.resumeService.update(resume);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Resume resume) {
		return this.resumeService.delete(resume);
	}
}
