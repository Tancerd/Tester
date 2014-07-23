package pl.tester.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {

	private long id;
	private String title;
	private String description;
	private List<Exam> examList;
}
