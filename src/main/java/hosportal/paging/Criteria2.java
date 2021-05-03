package hosportal.paging;

import lombok.Data;

@Data
public class Criteria2 {
	private int page;
	private int perPageNum;
	
	public Criteria2(){
		//초기값 설정
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum >100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" +page + ",perPageNum=" + perPageNum + "]";
	}
}
