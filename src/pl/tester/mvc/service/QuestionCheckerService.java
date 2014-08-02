package pl.tester.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.tester.model.Answer;
import pl.tester.model.Question;
import pl.tester.model.dto.AnswerDto;
import pl.tester.model.dto.QuestionDto;

@Service
public class QuestionCheckerService {

	public List<QuestionDto> check(List<Question> questionList, List<QuestionDto> usersAnswers) {

		for (QuestionDto questionDto : usersAnswers) {

			Question question = questionList.get((int) questionDto.getId());

			for (AnswerDto answerDto : questionDto.getAnswerList()) {

				Answer answer = question.getAnswerList().get((int) answerDto.getId());
				answerDto.setChecked(answerDto.isChecked() == answerDto.isChecked());
			}
		}

		return usersAnswers;
	}
}
