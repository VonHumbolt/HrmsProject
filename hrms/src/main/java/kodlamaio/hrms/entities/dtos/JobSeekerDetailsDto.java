package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class JobSeekerDetailsDto {
	
	private int id;
	
	private String jobPositionName;
	
	private String firstName;
	
	private String lastName;
	
	private String nationalIdentity;
	
	private Date dateOfBorn;
		
	
}
