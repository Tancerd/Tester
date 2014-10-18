package pl.tester.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto implements Serializable {

	private long id;
	private String text = "";
	private String author = "";
	private List<AnswerDto> answerList;
}
