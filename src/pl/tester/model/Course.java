package pl.tester.model;

import static javax.persistence.GenerationType.AUTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="courses")
public class Course {

	@Id
	@GeneratedValue(strategy=AUTO)
	private long id;

	@Column(nullable=false)
	private String title = "";

	@Column(nullable=false)
	private String url = "";

	@Column(nullable=false)
	private String description = "";

	@OneToMany(mappedBy="course")
	private List<Exam> examList;

	private boolean accepted = false;
}
