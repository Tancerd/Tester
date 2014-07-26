package pl.tester.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Exam {

	private long id;
	private String title = "";
	private String description = "";
	private String author = "";
	private String url = "";
	private Date dateCreate;
	private List<Question> questionList;
	private boolean accepted = false;
}
