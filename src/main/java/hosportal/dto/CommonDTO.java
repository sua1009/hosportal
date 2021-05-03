package hosportal.dto;

import java.time.LocalDateTime;

import hosportal.paging.Criteria;
import hosportal.paging.PaginationInfo;
import lombok.Data;


@Data
public class CommonDTO extends Criteria{

	/** 페이징 정보 */
	private PaginationInfo paginationInfo;

	/** 삭제 여부 */
	private String deleteYn;

	/** 등록일 */
	private LocalDateTime insertTime;

	/** 수정일 */
	private LocalDateTime updateTime;

	/** 삭제일 */
	private LocalDateTime deleteTime;
	
}
