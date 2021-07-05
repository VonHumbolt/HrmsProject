package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.UserImageService;
import kodlamaio.hrms.core.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserImageDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.UserImage;

@Service
public class UserImageManager implements UserImageService{
	
	private UserImageDao userImageDao;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public UserImageManager(UserImageDao userImageDao, ImageUploadService imageUploadService) {
		this.userImageDao = userImageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<UserImage> getUserImageByResumeId(int resumeId) {
		
		return new SuccessDataResult<UserImage>(this.userImageDao.getUserImageByResumeId(resumeId));
	}
	
	@Override
	public DataResult<UserImage> getUserImageByJobSeekerId(int jobSeekerId) {
		
		return new SuccessDataResult<UserImage>(this.userImageDao.getUserImageByJobSeekerId(jobSeekerId));
	}
	
	@Override
	public Result add(int jobSeekerId, int resumeId, MultipartFile multipartFile) {
		
		var uploadedImage = this.imageUploadService.uploadImage(multipartFile);
		var imageUrl = (String) uploadedImage.getData().get("url");
		
		UserImage userImage = new UserImage();
		
		Resume resume = new Resume();
		resume.setResumeId(resumeId);
		
		userImage.setImageUrl(imageUrl);
		userImage.setResume(resume);
		//userImage.setJobSeekerId(jobSeekerId);
		
		this.userImageDao.save(userImage);
		
		return new SuccessResult("Resim Eklendi");
		
	}

	@Override
	public Result update(int userImageId, MultipartFile multipartFile) {
		
		var uploadedImage = this.imageUploadService.uploadImage(multipartFile);
		var imageUrl = (String) uploadedImage.getData().get("url");
		
		UserImage userImageFromDb = this.userImageDao.getOne(userImageId);
		
		userImageFromDb.setImageUrl(imageUrl);
		
		this.userImageDao.save(userImageFromDb);
		
		return new SuccessResult("Resim Güncellendi");
	}

	
}
