package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity 
@Table(name="employer")
public class Employer {

	@Id 
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_vertification")
	private boolean emailVertification;
	
	@Column(name="hrms_vertification")
	private boolean hrmsVertification;
	
	public Employer() {
		
	}

	public Employer(int id, int userId, String companyName, String webSite, String phoneNumber,
			boolean emailVertification, boolean hrmsVertification) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyName = companyName;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.emailVertification = emailVertification;
		this.hrmsVertification = hrmsVertification;
	}
	
}
