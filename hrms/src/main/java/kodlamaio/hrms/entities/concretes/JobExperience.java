package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="job_experiences")
@AllArgsConstructor 
@NoArgsConstructor
public class JobExperience {

	@Id 
	@GeneratedValue
	@Column(name="job_experience_id")
	private int experienceId;

	@ManyToOne()
	@JoinColumn(name="resume_id")
	@JsonIgnore()
	private Resume resume;
	
	@Column(name="workplace_name")
	private String workPlaceName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;
	
}

