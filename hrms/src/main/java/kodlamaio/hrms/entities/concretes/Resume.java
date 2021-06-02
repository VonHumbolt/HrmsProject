package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name="resume_id")
	private int resumeId;

	@OneToMany(mappedBy = "resume")
	private List<School> schools;

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "resume")
	private List<Ability> abilities;
	
	@Column(name="github_address")
	private String githubAddress;
	
	@Column(name="linkedin_address")
	private String linkedinAdress;
	
	@Column(name="cover_letter")
	private String coverLetter;
}
