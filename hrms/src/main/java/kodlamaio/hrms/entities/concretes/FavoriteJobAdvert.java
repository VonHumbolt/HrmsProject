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
@Table(name="favorite_job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="favorite_id")
	private int favoriteId;
	
	@Column(name="job_seeker_id")
	private int jobSeekerId;
	
	@Column(name="job_advert_id")
	private int advertId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="deadline")
	private Date deadline;
	
	
	
}
