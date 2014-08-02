package pl.tester.model;

import static javax.persistence.GenerationType.AUTO;

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

@Data
@NoArgsConstructor
@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy=AUTO)
	private long id;

	@Column(nullable=false)
	private String text = "";

	@Column(nullable=false)
	private String author = "";

	private Date dateCreate;

	@OneToMany(mappedBy="question")
	private List<Answer> answerList;

	@ManyToOne(optional=false)
	@JoinColumn(name="exam_id")
	private Exam exam;

	private boolean accepted = false;
}
