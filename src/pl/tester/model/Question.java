package pl.tester.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Question {

	private long id;
	private String text;
	private String author;
	private Date dateCreate;
	private List<Answer> answerList;
}
