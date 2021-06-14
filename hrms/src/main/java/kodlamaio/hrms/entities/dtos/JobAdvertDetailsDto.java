package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
public class JobAdvertDetailsDto {
	
	private int id;
	
	private String companyName;
	
	private String jobPositionName;
	
	private int countOfJob;
	
	private String cityName;
	
	private int minSalary;
	
	private int maxSalary;
	
	private String jobDescription;
	
	private Date publishedDate;
	
	private Date deadline;
}
