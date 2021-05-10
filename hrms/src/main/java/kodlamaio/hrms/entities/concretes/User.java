package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private int email;
	
	@Column(name="password")
	private int password;

	public User() {
		
	}
	
	public User(int id, int email, int password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}
	
}
