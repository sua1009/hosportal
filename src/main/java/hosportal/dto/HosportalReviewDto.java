package hosportal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HosportalReviewDto extends CommonDTO{
	private int reviewNo;
	private String reviewComment;
	private String reviewScore;
	private String reviewDeletedYn;
	private String reviewCreatedDate;
	private String reviewImage;
	private String hospitalId;
	private String hospitalName;
	private String normalEmail;
	private String fileName;
}
