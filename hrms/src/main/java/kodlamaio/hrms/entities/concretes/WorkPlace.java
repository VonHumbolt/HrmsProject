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
@Table(name="work_places")
@NoArgsConstructor
@AllArgsConstructor
public class WorkPlace {

	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="work_place_id")
	private int workPlaceId;
	
	@Column(name="work_place_name")
	private String workPlaceName;
	
	@OneToMany(mappedBy = "workPlace")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
