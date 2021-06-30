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

import kodlamaio.hrms.business.abstracts.EmployerForUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerForUpdate;

@RestController 
@RequestMapping("/api/employerForUpdates/")
@CrossOrigin
public class EmployerForUpdatesController {

	private EmployerForUpdateService employerForUpdateService;

	@Autowired
	public EmployerForUpdatesController(EmployerForUpdateService employerForUpdateService) {
		super();
		this.employerForUpdateService = employerForUpdateService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<EmployerForUpdate>> getAll(){
		
		return this.employerForUpdateService.getAll();
	}
	
	@GetMapping("getEmployerForUpdateByEmployerId")
	public DataResult<EmployerForUpdate> getEmployerForUpdateByEmployerId(@RequestParam int employerId) {
		return this.employerForUpdateService.getEmployerForUpdateByEmployerId(employerId);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody EmployerForUpdate employerForUpdate) {
		return this.employerForUpdateService.add(employerForUpdate);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestBody EmployerForUpdate employerForUpdate) {
		return this.employerForUpdateService.delete(employerForUpdate);
	}
}
