package kodlamaio.hrms.core.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	
	DataResult<Map> uploadImage(MultipartFile file); 
}
