package hosportal.dto;

import lombok.Data;

@Data
public class FileDto {

	private int fileNo;
	private String fileName;
	private String fileOriName;
	private String fileAddress;
	private long fileSize;
	private String fileCreatedDate;
	private String fileDeletedYn;
	private int communityNo;
	private String normalEmail;
	private int reviewNo;
	private int eventNo;
	private String hospitalId;
	
}
