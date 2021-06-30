package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employer_for_update")
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForUpdate {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "updatedEmployerId")
	private int updatedEmployerId;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name= "new_company_name")
	private String newCompanyName;
	
	@Column(name= "new_web_site")
	private String newWebSite;
	
	@Column(name="new_phone_number")
	private String newPhoneNumber;
	
	@Column(name="new_email")
	private String newEmail;
	
}
