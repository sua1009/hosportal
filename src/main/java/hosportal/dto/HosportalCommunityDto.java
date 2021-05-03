package hosportal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HosportalCommunityDto extends CommonDTO{
	private int communityNo;
	private String communityTitle;
	private String communityContents;
	private String communityCreatedDate;
	private String communityDeletedYn;
	private String normalEmail;
	private int communityHitCnt;
	private String fileName;
}
