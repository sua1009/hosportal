package hosportal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HosportalHospitalMemberDto extends CommonDTO {
	
	private String hospitalId;
	private String hospitalPassword;
	private String hospitalName;
	private String hospitalTel;
	private String hospitalTel1;
	private String hospitalTel2;
	private String hospitalTel3;
	private String hospitalAddress1;
	private String hospitalAddress2;
	private String hospitalAddress3;
	private String hospitalOpenTime;
	private String hospitalCloseTime;
	private String hospitalSkill;
	private String hospitalIntroduce;
	private String hospitalCategory1;
	private String hospitalCategory2;
	private String hospitalCategory3;
	private String hospitalClosed;
	private String memberAuthority;
	private String fileName;
	private String hospitalRegisterDate;
	private int hospitalViewCount;
	private int rownum;
	
	
}
