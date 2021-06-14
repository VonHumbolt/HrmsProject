package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name="web_site")
	@NotNull
	@NotBlank
	private String webSite;
	
	@Column(name="email")
	@NotNull
	@NotBlank
	private String email;
	
	@Column(name="phone_number")
	@NotNull
	@NotBlank 
	private String phoneNumber;
	
	@Column(name="email_vertification")
	private boolean emailVertification;
	
	@Column(name="hrms_vertification")
	private boolean hrmsVertification;
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
