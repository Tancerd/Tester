package pl.tester.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Answer {

	private long id;
	private String text = "";
	private boolean correct;
}
