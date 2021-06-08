package kodlamaio.hrms.entities.concretes;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Entity 
@Table(name="languages")
@AllArgsConstructor 
@NoArgsConstructor
public class Language {

	@Id 
	@Column(name="language_id")
	private int languageId;
	
	@ManyToOne()
	@JoinColumn(name="resume_id")
	@JsonIgnore()
	private Resume resume;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="language_level")
	private int languageLevel;
	
	private int id;
}
