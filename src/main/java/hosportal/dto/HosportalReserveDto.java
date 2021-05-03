package hosportal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class HosportalReserveDto extends CommonDTO{
	private int reserveNo;
	private String reserveTel;
	private String reserveTime;
	private String reserveExplain;
	private String reserveDate;
	private String reserveFinished;
	private String normalEmail;
	private String normalName;
	private String normalBirth;
	private String hospitalId;
	private String hospitalName;
	private String hospitalAddress2;
	private String hospitalAddress3;
	
	

}
