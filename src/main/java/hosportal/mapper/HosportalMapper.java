package hosportal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hosportal.dto.FileDto;
import hosportal.dto.HosportalCommunityDto;
import hosportal.dto.HosportalEventDto;
import hosportal.dto.HosportalHospitalMemberDto;
import hosportal.dto.HosportalNormalMemberDto;
import hosportal.dto.HosportalQuestionDto;
import hosportal.dto.HosportalReserveDto;
import hosportal.dto.HosportalReviewDto;
import hosportal.dto.ReCommunityDto;
import hosportal.dto.ReQuestionDto;
import hosportal.paging.Criteria2;

@Mapper
public interface HosportalMapper {
	
	//최신 병원 리스트
	List<HosportalHospitalMemberDto> newHospitalList() throws Exception;
	
	//베스트뷰 병원 리스트
	List<HosportalHospitalMemberDto> bestHospitalList() throws Exception;
	
	//메인이벤트
	List<HosportalEventDto> mainEventList() throws Exception;
	
	//메인커뮤니티
	List<HosportalCommunityDto> mainCommunityList() throws Exception;
	
	// 개인회원 회원가입
	void insertNormalMember(HosportalNormalMemberDto member) throws Exception;
	
	//개인 회원가입 파일
	void insertNormalFile(List<FileDto> fileList) throws Exception;
	
	// 개인회원 회원가입 아이디 중복체크
	int normalEmailCheck(String normalEmail) throws Exception;
	
	// 병원 회원가입
	void insertHospitalMember(HosportalHospitalMemberDto hMember) throws Exception;
	
	// 병원 회원가입 아이디 중복 체크
	int hospitalIdCheck(String hospitalId) throws Exception;
	
	// 병원회원가입 파일
	void insertHospitalFile(List<FileDto> fileList) throws Exception;
	
	// 병원 목록
	List<HosportalHospitalMemberDto> selectHosfitalList(HosportalHospitalMemberDto params) throws Exception;
	public int selectHospitalTotalCount(HosportalHospitalMemberDto params);
	
	// 개인회원 로그인 체크
	int normalLoginCheck(@Param("id") String id, @Param("pw") String pw) throws Exception;
	
	// 병원회원 로그인 체크
	int hospitalLoginCheck(@Param("id") String id, @Param("pw") String pw) throws Exception;
	
	// 병원 상세보기
	HosportalHospitalMemberDto hosportalDetail(String hospitalId) throws Exception;
	
	// 병원 조회수
	void hospitalViewCount(String hospitalId) throws Exception;
	
	// 커뮤니티 목록 불어오기
	List<HosportalCommunityDto> selectCommunityList(HosportalCommunityDto params) throws Exception;
	public int selectCommunityTotalCount(HosportalCommunityDto params);
	
	
	//이벤트 목록 
	List<HosportalEventDto> selectEventList(HosportalEventDto params) throws Exception;
	int selectEventTotalCount(HosportalEventDto params);
	
	
	// 이벤트  목록, 상세보기, 입력, 수정, 삭제, 조회수, 페이징
		List<HosportalEventDto> selectEvents(Criteria2 cri) throws Exception;
		HosportalEventDto selectEventDetail(int eventNo) throws Exception;
		void insertEvent(HosportalEventDto event) throws Exception;
		void updateEvent(HosportalEventDto event) throws Exception;
		void updateEventFileUpdate(List<FileDto> fileList) throws Exception;
		void updateEventFileDelete(@Param("eventNo") int eventNo ) throws Exception;
		
		void deleteEvent(int eventNo)throws Exception;
		void updateEventHitCount (int eventNo) throws Exception;
		int EventListCountCriteria(Criteria2 cri) throws Exception;	
//		이벤트 파일 추가
		List<FileDto> selectEventFileList(int eventNo)throws Exception;
		void insertEventFileList(List<FileDto> list) throws Exception;
		int deleteEventFile(int eventNo);
		
		// 커뮤니티 목록, 상세보기, 수정, 삭제, 조회수, 페이징
		List<HosportalCommunityDto> selectCommunityList(Criteria2 cri) throws Exception;
		HosportalCommunityDto communityDetail(int communityNo) throws Exception;
		void insertCommunity(HosportalCommunityDto community) throws Exception;
		void updateCommunity(HosportalCommunityDto community)throws Exception;
		void communityFileUpdate(List<FileDto> fileList) throws Exception;
		void communityFileDelete(@Param("communityNo") int communityNo ) throws Exception;
		
		
		void deleteCommunity(int communityNo)throws Exception;
		void updateCommunityHitCount (int communityNo) throws Exception;
		int CommunityListCountCriteria(Criteria2 cri)throws Exception;
		// 커뮤니티 파일 추가
		void insertCommunityFileList(List<FileDto> list)throws Exception;
		
		//	댓글 맵퍼
		List<ReCommunityDto> selectReCommunityList(int commuNo) throws Exception;
		void insertReCommunity(ReCommunityDto reCommunity)throws Exception; //댓글 보기
		void updateReCommunity(ReCommunityDto reCommunity)throws Exception;	//댓글 수정
		void deleteReCommunity(int reCommunityNo)throws Exception;	//댓글 삭제
	
	// (개인회원) 마이페이지 - 회원 상세보기
	HosportalNormalMemberDto normalMemberDetail(String normalEmail) throws Exception;
	
	// (개인회원) 회원 수정
	void normalMemberUpdate(HosportalNormalMemberDto data) throws Exception;
	void normalFileUpdate(List<FileDto> fileList) throws Exception;
	void normalFileDelete(@Param("normalEmail") String normalEmail) throws Exception;
	
	void updateHospitalFile(List<FileDto> fileList) throws Exception;
	
	// 병원 예약하기
	void hospitalReserve(HosportalReserveDto data) throws Exception;
	
	// (개입회원) 마이페이지 - 예약 정보
	List<HosportalReserveDto> normalMypageReserve(HosportalReserveDto params) throws Exception;
	public int selectReserveTotalCount(HosportalReserveDto params);
	
	// 병원 문의하기 
	void hospitalQuestion(HosportalQuestionDto data) throws Exception;
	
	// 병원 리뷰쓰기
	void hospitalReview(HosportalReviewDto data) throws Exception;
	
	// 병원 리뷰보기
	List<HosportalReviewDto> oneHospitalReview(String hospitalId) throws Exception;
	
	// (개인회원) 마이페이지 문의 정보
	List<HosportalQuestionDto> normalMypageQuestion(HosportalQuestionDto params) throws Exception;
	public int selectQuestionTotalCount(HosportalQuestionDto params);
	
	// (개인회원) 마이페이지 문의 상세
	HosportalQuestionDto mypageQuestionDetail(@Param("questionNo") int questionNo) throws Exception;
	
	// (개인회원) 마이페이지 문의 수정
	void updateMyQuestion(HosportalQuestionDto question) throws Exception;
	
	// (개인회원) 마이페이지 문의 삭제
	void deleteMyQuestion(int questionNo) throws Exception;
	
	
	// (개인회원) 마이페이지 리뷰 정보
	List<HosportalReviewDto> normalMypageReview(HosportalReviewDto params) throws Exception;
	public int selectReviewTotalCount(HosportalReviewDto params);
	
	// (병원회원) 마이페이지 - 병원정보 상세보기
	HosportalHospitalMemberDto hospitalMemberDetail(String hospitalId) throws Exception;
	
	// (병원회원) 회원 수정
	void hospitalMemberUpdate(HosportalHospitalMemberDto data) throws Exception;
	void hospitalFileUpdate(List<FileDto> fileList) throws Exception;
	void hospitalFileDelete(@Param("hospitalId") String hospitalId) throws Exception;
	
	
	// (병원회원) 마이페이지 - 예약 정보
	List<HosportalReserveDto> hospitalMypageReserve(String hospitalId) throws Exception;
	
	// (병원회원) 마이페이지 예약 완료 처리
	void mypagereserveFinished(HosportalReserveDto data) throws Exception;
	
	//(개인회원) 마이페이지 예약 취소
	void normalMypageReserveCancel(HosportalReserveDto data) throws Exception;
	
	// (병원회원) 마이페이지 리뷰 정보
	List<HosportalReviewDto> hospitalMypageReview(String hospitalId) throws Exception;
	
	//(병원회원) 마이페이지 문의 정보
	List<HosportalQuestionDto> hospitalMypageQuestion(String hospitalId) throws Exception;
	
	// (병원회원) 문의 상세
	HosportalQuestionDto questionHospitalDetail(@Param("questionNo") int questionNo)throws Exception;
	
	// (병원회원)문의 댓글 리스트
	List<ReQuestionDto> selectReQuestionList(int questionNo)throws Exception;
		
	// (병원회원)문의 댓글 입력
	void insertReQuestion(ReQuestionDto reQuestion)throws Exception;
	
	// (병원회원)문의 댓글 수정
	void updateReQuestion(ReQuestionDto reQuestion)throws Exception;
	
	// (병원회원)문의 댓글 삭제
	void deleteReQuestion(int reQuestionNo)throws Exception;
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	//피부과 Dermatology 정렬	
	List<HosportalHospitalMemberDto> Dermatology(@Param("search_param") String search_param) throws Exception;
	
	//치과 Dentist 정렬
	List<HosportalHospitalMemberDto> Dentist(@Param("search_param") String search_param) throws Exception;
	
	//안과 Ophthalmology 정렬
	List<HosportalHospitalMemberDto> Ophthalmology(@Param("search_param") String search_param) throws Exception;	
	
	//내과 medicine 정렬
	List<HosportalHospitalMemberDto> medicine(@Param("search_param") String search_param) throws Exception;
	
	//한의원 Orientalmedicine 정렬
	List<HosportalHospitalMemberDto> Orientalmedicine(@Param("search_param") String search_param) throws Exception;
	
	//산부인과 Obstetricsandgynecology 정렬
	List<HosportalHospitalMemberDto> Obstetricsandgynecology(@Param("search_param") String search_param) throws Exception;
	
	//성형외과 PlasticSurgery 정렬
	List<HosportalHospitalMemberDto> PlasticSurgery(@Param("search_param") String search_param) throws Exception;
	
	//소아청소년과 DepartmentofPediatricsandAdolescents 정렬
	List<HosportalHospitalMemberDto> DepartmentofPediatricsandAdolescents(@Param("search_param") String search_param) throws Exception;
	
	//이비인후과 Otorhinolaryngology 정렬
	List<HosportalHospitalMemberDto> Otorhinolaryngology(@Param("search_param") String search_param) throws Exception;
	
	//가정의학과 DepartmentofFamilyMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofFamilyMedicine(@Param("search_param") String search_param) throws Exception;
	
	//정신건강의학과 DepartmentofMentalHealthMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofMentalHealthMedicine(@Param("search_param") String search_param) throws Exception;
	
	//재활의학과 DepartmentofRehabilitationMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofRehabilitationMedicine(@Param("search_param") String search_param) throws Exception;
	
	//외과 surgery 정렬
	List<HosportalHospitalMemberDto> surgery(@Param("search_param") String search_param) throws Exception;
	
	//정형외과 Orthopedics 정렬
	List<HosportalHospitalMemberDto> Orthopedics(@Param("search_param") String search_param) throws Exception;
	
	//신경과 Neurology 정렬
	List<HosportalHospitalMemberDto> Neurology(@Param("search_param") String search_param) throws Exception;
	
	//비뇨기과 urology 정렬
	List<HosportalHospitalMemberDto> urology(@Param("search_param") String search_param) throws Exception;
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 끝                                                                        //
	//                                                         지역별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	// Seoul 서울
	List<HosportalHospitalMemberDto> Seoul(@Param("search_param") String search_param) throws Exception;
	
	// Incheon 인천
	List<HosportalHospitalMemberDto> Incheon(@Param("search_param") String search_param) throws Exception;
	
	// Gyeonggi 경기
	List<HosportalHospitalMemberDto> Gyeonggi(@Param("search_param") String search_param) throws Exception;
	
	// Chungbuk 충북
	List<HosportalHospitalMemberDto> Chungbuk(@Param("search_param") String search_param) throws Exception;
	
	// Chungnam 충남
	List<HosportalHospitalMemberDto> Chungnam(@Param("search_param") String search_param) throws Exception;
	
	// Gangwon 강원
	List<HosportalHospitalMemberDto> Gangwon(@Param("search_param") String search_param) throws Exception;
	
	// Sejong 세종
	List<HosportalHospitalMemberDto> Sejong(@Param("search_param") String search_param) throws Exception;
	
	// Daejeon 대전
	List<HosportalHospitalMemberDto> Daejeon(@Param("search_param") String search_param) throws Exception;
	
	// Gyeongbuk 경북
	List<HosportalHospitalMemberDto> Gyeongbuk(@Param("search_param") String search_param) throws Exception;
	
	// Gyeongnam 경남
	List<HosportalHospitalMemberDto> Gyeongnam(@Param("search_param") String search_param) throws Exception;
	
	// Daegu 대구
	List<HosportalHospitalMemberDto> Daegu(@Param("search_param") String search_param) throws Exception;
	
	// Jeollabuk 전북
	List<HosportalHospitalMemberDto> Jeollabuk(@Param("search_param") String search_param) throws Exception;
	
	// Jeollanam 전남
	List<HosportalHospitalMemberDto> Jeollanam(@Param("search_param") String search_param) throws Exception;
	
	// Gwangju 광주
	List<HosportalHospitalMemberDto> Gwangju(@Param("search_param") String search_param) throws Exception;
	
	// Ulsan 울산
	List<HosportalHospitalMemberDto> Ulsan(@Param("search_param") String search_param) throws Exception;
	
	// Busan 부산
	List<HosportalHospitalMemberDto> Busan(@Param("search_param") String search_param) throws Exception;
	
	// Jeju 제주
	List<HosportalHospitalMemberDto> Jeju(@Param("search_param") String search_param) throws Exception;
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         지역별 정렬 끝                                                                        //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
}
