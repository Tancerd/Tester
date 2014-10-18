package pl.tester.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;
import static org.hibernate.annotations.FetchMode.SELECT;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Fetch;

@Data
@NoArgsConstructor
@Entity
@Table(name="exams")
public class Exam {

	@Id
	@GeneratedValue(strategy=AUTO)
	private long id;

	@Column(nullable=false)
	private String title = "";

	@Column(nullable=false)
	private String description = "";

	@Column(nullable=false)
	private String author = "";

	@Column(nullable=false)
	private String url = "";

	private Date dateCreate;

	@OneToMany(mappedBy="exam", fetch=EAGER, cascade=ALL)
	@Fetch(SELECT)
	private List<Question> questionList = new ArrayList<>();;

	@ManyToOne(optional=false)
	@JoinColumn(name="course_id")
	private Course course;

	private boolean accepted = false;

	public void setUpUrl() {
		url = title.replace(" ", "_").toLowerCase();
	}
}
