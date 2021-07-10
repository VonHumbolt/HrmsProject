package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="resumes")
@NoArgsConstructor 
@AllArgsConstructor 
public class Resume {

	@Id
	@GeneratedValue
	@Column(name="resume_id")
	private int resumeId;

	@OneToOne(mappedBy = "resume")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "resume")
	private List<School> schools;

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "resume")
	private List<Ability> abilities;
	
	@OneToOne(mappedBy = "resume")
	private UserImage userImage;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAdress;
	
	@Column(name="cover_letter")
	private String coverLetter;

	@Column(name="job_seeker_id")
	private int jobSeekerId;
}
