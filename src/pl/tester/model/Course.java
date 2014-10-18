package pl.tester.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static org.hibernate.annotations.FetchMode.SELECT;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Fetch;

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

	@OneToMany(mappedBy="course", fetch=EAGER, cascade=ALL)
	@Fetch(SELECT)
	private List<Exam> examList = new ArrayList<>();

	private boolean accepted = false;

	public void setUpUrl() {
		url = title.replace(" ", "_").toLowerCase();
	}
}
