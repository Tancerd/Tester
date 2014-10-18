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

	public Answer generateBack(AnswerDto answerDto) {

		Answer answer = new Answer();

		answer.setCorrect(answerDto.isChecked());
		answer.setText(answerDto.getText());

		return answer;
	}

	public List<Answer> generateBack(List<AnswerDto> answersDto) {

		List<Answer> answers = new ArrayList<Answer>();

		for (AnswerDto answerDto : answersDto) {

			Answer answer = new Answer();
	
			answer.setCorrect(answerDto.isChecked());
			answer.setText(answerDto.getText());

			answers.add(answer);
		}

		return answers;
	}
}
