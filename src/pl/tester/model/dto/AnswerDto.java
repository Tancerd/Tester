package pl.tester.model.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDto implements Serializable {

	private long id;
	private String text = "";
	private boolean checked;
}
