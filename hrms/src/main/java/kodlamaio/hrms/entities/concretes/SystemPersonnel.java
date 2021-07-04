package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="system_personnels")
@NoArgsConstructor
@AllArgsConstructor
public class SystemPersonnel{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="system_personnel_id")
	private int systemPersonnelId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
}
