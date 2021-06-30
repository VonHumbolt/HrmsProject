package kodlamaio.hrms.api.controllers;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Result add(@RequestParam int jobSeekerId, @RequestParam int resumeId, @RequestParam MultipartFile multipartFile) {
		return this.userImageService.add(jobSeekerId, resumeId, multipartFile);
	}
}
