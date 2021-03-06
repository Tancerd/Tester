package pl.tester.mvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.tester.model.Answer;
import pl.tester.model.Question;
import pl.tester.model.dto.QuestionDto;

@Service
public class QuestionDtoGenerator {

	@Autowired private AnswerDtoGenerator answerDtoGenerator;

	public QuestionDto generate(Question question) {

		QuestionDto questionDto = new QuestionDto();

		questionDto.setAuthor(question.getAuthor());
		questionDto.setText(question.getText());
		questionDto.setId(question.getId());
		questionDto.setAnswerList(answerDtoGenerator.generate(question.getAnswerList()));

		return questionDto;
	}

	public List<QuestionDto> generate(List<Question> questionList) {

		List<QuestionDto> questionDtoList = new ArrayList<>();

		for (Question question : questionList) {
			questionDtoList.add(generate(question));
		}

		return questionDtoList;
	}

	public Question generateBack(QuestionDto questionDto) {

		Question question = new Question();

		question.setAuthor(questionDto.getAuthor());
		question.setDateCreate(new Date());
		question.setText(questionDto.getText());
		question.setAnswerList(answerDtoGenerator.generateBack(questionDto.getAnswerList()));

		for (Answer answer : question.getAnswerList()) {
			answer.setQuestion(question);
		}

		return question;

	}
}
