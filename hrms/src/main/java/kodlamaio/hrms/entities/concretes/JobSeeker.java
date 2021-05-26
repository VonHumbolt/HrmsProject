package kodlamaio.hrms.entities.concretes;

import java.util.Date;

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
@Table(name="job_seeker")
@NoArgsConstructor 
@AllArgsConstructor
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="date_of_born")
	private Date dateOfBorn;
	
	@Column(name="mernis_vertification")
	private boolean mernisVertification;
	
	@Column(name="email_vertification")
	private boolean emailVertification;

}
