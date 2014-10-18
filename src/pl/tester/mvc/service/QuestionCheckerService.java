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

			Question question = getQuestionById(questionList, questionDto.getId());

			for (AnswerDto answerDto : questionDto.getAnswerList()) {

				Answer answer = getAnswerById(question.getAnswerList(), answerDto.getId());
				answerDto.setChecked(answerDto.isChecked() == answer.isCorrect());
			}
		}

		return usersAnswers;
	}

	private Question getQuestionById(List<Question> questions, long id) {

		for (Question question : questions) {
			if (question.getId() == id) 
				return question;
		}

		return null;
	}

	private Answer getAnswerById(List<Answer> answers, long id) {

		for (Answer answer : answers) {
			if (answer.getId() == id) 
				return answer;
		}

		return null;
	}
}
