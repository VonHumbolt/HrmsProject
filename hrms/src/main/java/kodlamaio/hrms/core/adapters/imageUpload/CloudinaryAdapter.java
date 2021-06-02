package kodlamaio.hrms.core.adapters.imageUpload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.abstracts.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryAdapter implements ImageUploadService{

	private Cloudinary cloudinary;
	
	public CloudinaryAdapter() {
		
		Map<String, String> config = new HashMap<String, String>();
		config.put("cloud_name", "dspea8wm4");
		config.put("api_key", "767195529372449");
		config.put("api_secret", "L-c0X0TJL2fBdWxm6h5jtzOFuhQ");
		
		this.cloudinary = new Cloudinary(config);
	}
	
	
	@Override
	public DataResult<Map> uploadImage(MultipartFile multipartFile){
		
		Map result = null;
		try {
			File file = convert(multipartFile);
			result = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new SuccessDataResult<Map>(result);
	
		
	}

	
	private File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		return file;
	}


	
}
