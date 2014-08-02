package pl.tester.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.tester.model.Answer;
import pl.tester.model.dto.AnswerDto;

@Service
public class AnswerDtoGenerator {

	public AnswerDto generate(Answer answer) {

		AnswerDto answerDto = new AnswerDto();

		answerDto.setChecked(false);
		answerDto.setId(answer.getId());
		answerDto.setText(answer.getText());

		return answerDto;
	}

	public List<AnswerDto> generate(List<Answer> answerList) {

		List<AnswerDto> answerDtoList = new ArrayList<>();

		for (Answer answer : answerList) {
			answerDtoList.add(generate(answer));
		}

		return answerDtoList;
	}
}
