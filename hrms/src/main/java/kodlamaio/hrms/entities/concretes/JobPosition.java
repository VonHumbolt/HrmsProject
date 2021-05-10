package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data 
@Entity 
@Table(name="job_position")
public class JobPosition {
	
	@Id 
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="position_name")
	private String jobPositionName;
	
	public JobPosition() {
		
	}

	public JobPosition(int id, String jobPositionName) {
		super();
		this.id = id;
		this.jobPositionName = jobPositionName;
	}
	
	
}
