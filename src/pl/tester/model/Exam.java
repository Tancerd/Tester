package pl.tester.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Exam {

	private long id;
	private String description;
	private String author;
	private Date dateCreate;
	private List<Question> questionList;
}
