package hosportal.dto;

import java.util.List;

import lombok.Data;

@Data
public class HosportalEventDto {
	
	private int eventNo;
	private String eventTitle;
	private String eventComment;
	private int eventHitCnt;
	private String eventCreatedDate;
	private String hospitalName;
	private String hosId;
	private String fileName;
	private List<FileDto> fileList;
}
