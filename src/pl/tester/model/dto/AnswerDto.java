package pl.tester.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDto {

	private long id;
	private String text = "";
	private boolean checked;
}
