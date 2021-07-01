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
@Table(name="job_types")
@AllArgsConstructor
@NoArgsConstructor
public class JobType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_type_id")
	private int jobTypeId;
	
	@Column(name="job_type_name")
	private String jobTypeName;
	
	@OneToMany(mappedBy = "jobType")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
