package pl.tester.model.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDto {

	private long id;
	private String text = "";
	private String author = "";
	private List<AnswerDto> answerList;
}
