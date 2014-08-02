package pl.tester.mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.tester.model.Exam;
import pl.tester.model.Question;

@Service
public class QuestionsService {

	public List<Question> getRandomQuestions(Exam exam, int number) {

		List<Question> allQuestions = exam.getQuestionList();

		if (number > allQuestions.size()) {
			number = allQuestions.size();
		}

		List<Question> randomQuestions = new ArrayList<>(number);

		Collections.shuffle(allQuestions);
		randomQuestions = allQuestions.subList(0, number);

		for (Question question : randomQuestions) {
			Collections.shuffle(question.getAnswerList());
		}

		return randomQuestions;
	}
}
