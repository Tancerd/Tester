package pl.tester.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="answers")
public class Answer {

	@Id
	@GeneratedValue(strategy=AUTO)
	private long id;

	@Column(nullable=false)
	private String text = "";

	private boolean correct;

	@ManyToOne(optional=false)
	@JoinColumn(name="question_id")
	private Question question;
}
