package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobAdvert {
	
	@Id
	@GeneratedValue
	@Column(name="advert_id")
	private int advertId;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="job_description")
	private String jobDescription;

	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="count_of_job")
	private int countOfJob;
	
	@Column(name="published_date")
	private Date publishedDate = new Date();
	
	@Column(name="deadline")
	private Date deadline;
	
	@ManyToOne()
	@JoinColumn(name="job_type_id")
	private JobType jobType;
	
	@ManyToOne()
	@JoinColumn(name="work_place_id")
	private WorkPlace workPlace;
	
	
}
