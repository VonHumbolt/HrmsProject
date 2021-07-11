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
@Table(name="ability")
@NoArgsConstructor 
@AllArgsConstructor 
public class Ability {

	@Id 
	@GeneratedValue
	@Column(name="ability_id")
	private int abilityId;
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	@JsonIgnore()
	private Resume resume;
	
	@Column(name="technology")
	private String technology;
	
}
