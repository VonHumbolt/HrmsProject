package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="job_positions")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_position_id")
	private int jobPositionId;
	
	@Column(name="position_name")
	private String jobPositionName;
	
	@OneToMany(mappedBy = "jobPosition")
	@JsonIgnore()
	private List<JobAdvert> jobAdverts;
	
	@OneToMany(mappedBy="jobPosition")
	@JsonIgnore()
	private List<JobSeeker> jobSeekers;
	
}
