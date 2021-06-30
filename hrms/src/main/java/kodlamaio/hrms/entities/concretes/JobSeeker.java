package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor 
@AllArgsConstructor

public class JobSeeker{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="user_id")
	private int userId;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@Column(name="first_name")
	@NotNull 
	@NotBlank
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@NotBlank
	private String lastName;
	
	@Column(name="national_identity")
	@NotNull
	@NotBlank
	private String nationalIdentity;
	
	@Column(name="date_of_born")
	@NotNull
	private Date dateOfBorn;
	
	@Column(name="mernis_vertification")
	private boolean mernisVertification;
	
	@Column(name="email_vertification")
	private boolean emailVertification;
	
	@OneToOne()
	@JoinColumn(name="resume_id")
	@JsonIgnore
	private Resume resume;
	
	@OneToOne(mappedBy = "jobSeeker")
	private UserImage userImage;
	
}
