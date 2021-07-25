package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegister {

	private int employerId;
	
	@NotBlank
	private String companyName;
	
	@NotBlank
	private String website;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String phoneNumber;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String confirmPassword;
}
