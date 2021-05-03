package hosportal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HosportalQuestionDto extends CommonDTO{
	private int questionNo;
	private String questionContents;
	private String questionCreatedDate;
	private String questionFinished;
	private String questionTitle;
	private String normalEmail;
	private String hospitalId;
	private String hospitalName;
	private String writer;
}
