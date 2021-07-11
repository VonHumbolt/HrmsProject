package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="schools")
@NoArgsConstructor 
@AllArgsConstructor
public class School {
	
	@Id
	@GeneratedValue
	@Column(name="school_id")
	private int schoolId;
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	@JsonIgnore
	private Resume resume;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="school_department")
	private String schoolDepartment;
	
	@Column(name= "start_year")
	private int startYear;
	
	@Column(name="graduation_year")
	private int graduationYear;
	
}
