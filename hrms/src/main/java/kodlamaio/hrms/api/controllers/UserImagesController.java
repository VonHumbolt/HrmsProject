package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UserImage;

@RestController
@RequestMapping("/api/userImages/")
@CrossOrigin
public class UserImagesController {

	private UserImageService userImageService;
	
	@Autowired
	public UserImagesController(UserImageService userImageService) {
		this.userImageService = userImageService;
	}
	
	@GetMapping("getImageByResumeId")
	public DataResult<UserImage> getUserImageByResumeId(@RequestParam int resumeId){
		return this.userImageService.getUserImageByResumeId(resumeId);
	}
	
	@GetMapping("getImageByJobSeekerId")
	public DataResult<UserImage> getUserImageByJobSeekerId(@RequestParam int jobSeekerId) {
		return this.userImageService.getUserImageByJobSeekerId(jobSeekerId);
	}
	
	@PostMapping(path="addImage")
	public Result add(@RequestParam int jobSeekerId, @RequestParam int resumeId, @RequestBody MultipartFile multipartFile) {
		return this.userImageService.add(jobSeekerId, resumeId, multipartFile);
	}
	
	@PostMapping("update")
	public Result update(@RequestParam int userImageId, @RequestBody MultipartFile multipartFile) {
		return this.userImageService.update(userImageId, multipartFile);
	}
}
