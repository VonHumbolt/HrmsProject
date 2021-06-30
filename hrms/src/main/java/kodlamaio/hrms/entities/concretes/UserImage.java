package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name="user_images")
public class UserImage {
	
	@Id 
	@GeneratedValue
	@Column(name="image_id")
	private int userImageId;
	
	@JoinColumn(name="job_seeker_id")
	@OneToOne
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToOne
	@JoinColumn(name="resume_id")
	@JsonIgnore
	private Resume resume;
}
