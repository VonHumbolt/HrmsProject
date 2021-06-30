package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor 
@NoArgsConstructor 
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="email")
	@NotNull
	@Email
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	private int password;

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private SystemPersonnel systemPersonnel;

	@OneToOne(mappedBy = "user")
	@JsonIgnore
	private Employer employer;
	
}
