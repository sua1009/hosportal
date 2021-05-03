package hosportal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

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

public interface HosportalService {
	
	//최신 병원 리스트
	List<HosportalHospitalMemberDto> newHospitalList() throws Exception;
	
	//베스트뷰 병원 리스트
	List<HosportalHospitalMemberDto> bestHospitalList() throws Exception;
	
	//메인이벤트
	List<HosportalEventDto> mainEventList() throws Exception;
	
	//메인커뮤니티
	List<HosportalCommunityDto> mainCommunityList() throws Exception;
		
	
	// 개입회원 회원가입
	void insertNormalMember(HosportalNormalMemberDto member,  MultipartHttpServletRequest uploadFiles) throws Exception;
	
	// 개인회원 회원가입 아이디 중복체크
	int normalEmailCheck(String normalEmail) throws Exception;
	
	
	void insertHospitalFile(HosportalHospitalMemberDto member, MultipartHttpServletRequest uploadFiles) throws Exception;
	
	// 병원 회원가입 아이디 중복 체크
	int hospitalIdCheck(String hospitalId) throws Exception;
	
	// 병원 목록
	List<HosportalHospitalMemberDto> selectHosfitalList(HosportalHospitalMemberDto params) throws Exception;
	
	// 개인회원 로그인 체크
	int normalLoginCheck(String id, String pw) throws Exception;
	
	// 병원회원 로그인 체크
	int hospitalLoginCheck(String id, String pw) throws Exception;
	
	// 병원 상세보기
	HosportalHospitalMemberDto hosportalDetail(String hospitalId) throws Exception;
	
	
	//이벤트 목록 
	List<HosportalEventDto> selectEventList(HosportalEventDto params) throws Exception;
	
	// 이벤트 목록, 상세보기, 입력, 수정, 삭제, 페이징
		List<HosportalEventDto> selectEvents(Criteria2 cri) throws Exception;
		HosportalEventDto selectEventDetail(int eventNo) throws Exception;
		void insertEvent(HosportalEventDto event, MultipartHttpServletRequest uploadFiles)throws Exception;
		void updateEvent(HosportalEventDto event) throws Exception;
		void updateEventFileUpdate(HosportalEventDto event, MultipartHttpServletRequest uploadFiles) throws Exception;
		void updateEventFileDelete(int eventNo) throws Exception;

		
		void deleteEvent(int eventNo)throws Exception;
		int EventListCountCriteria(Criteria2 cri) throws Exception;	
		// 커뮤니티 목록, 상세보기, 입력, 수정, 삭제, 페이징
		List<HosportalCommunityDto> selectCommunityList(Criteria2 cri) throws Exception;
		HosportalCommunityDto selectCommunityDetail(int communityNo) throws Exception;
		void insertCommunity(HosportalCommunityDto community)throws Exception;
		void updateCommunity(HosportalCommunityDto community)throws Exception;
		void communityFileUpdate(HosportalCommunityDto community, MultipartHttpServletRequest uploadFiles) throws Exception;
		
		void communityFileDelete(int communityNo ) throws Exception;
		
		
		void deleteCommunity(int communityNo)throws Exception;
		int CommunityListCountCriteria(Criteria2 cri)throws Exception;
			
		//	커뮤니티 댓글 
		List<ReCommunityDto> selectReCommunityList(int commuNo) throws Exception;
		void insertReCommunity(ReCommunityDto reCommunity)throws Exception; //댓글 보기
		void updateReCommunity(ReCommunityDto reCommunity)throws Exception;	//댓글 수정
		void deleteReCommunity(int reCommunityNo)throws Exception;	//댓글 삭제
	
	// (개인회원) 마이페이지 - 회원 상세보기
	HosportalNormalMemberDto normalMemberDetail(String normalEmail) throws Exception;
	
	// (개인회원) 회원 수정
	void normalMemberUpdate(HosportalNormalMemberDto data) throws Exception;
	public void normalFileUpdate(HosportalNormalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception;
	void normalFileDelete(String normalEmail) throws Exception;
	
	// 병원 예약하기
	void hospitalReserve(HosportalReserveDto data) throws Exception;
	
	// (개인회원) 마이페이지 - 예약 정보
	List<HosportalReserveDto> normalMypageReserve(HosportalReserveDto params) throws Exception;
	
	// (개인회원) 마이페이지 리뷰 정보
	List<HosportalReviewDto> normalMypageReview(HosportalReviewDto params) throws Exception;
	
	// 병원 문의하기 
	void hospitalQuestion(HosportalQuestionDto data) throws Exception;
	
	// 병원 리뷰쓰기
	void hospitalReview(HosportalReviewDto data) throws Exception;
	
	// 병원 리뷰보기
	List<HosportalReviewDto> oneHospitalReview(String hospitalId) throws Exception;
	
	// (개인회원) 마이페이지 문의 정보
	List<HosportalQuestionDto> normalMypageQuestion(HosportalQuestionDto params) throws Exception; 
	
	// (개인회원) 마이페이지 문의 상세
	HosportalQuestionDto normalMypageQuestionDetail(int questionNo) throws Exception;
	
	// (개인회원) 마이페이지 문의 수정
	void updateMyQuestion(HosportalQuestionDto question) throws Exception;
		
	// (개인회원) 마이페이지 문의 삭제
	void deleteMyQuestion(int questionNo) throws Exception;
	
	// (병원회원) 마이페이지 - 병원정보 상세보기
	HosportalHospitalMemberDto hospitalMemberDetail(String hospitalId) throws Exception;
	
	// (병원회원) 회원 수정
	void hospitalMemberUpdate(HosportalHospitalMemberDto data) throws Exception;
	public void hospitalFileUpdate(HosportalHospitalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception;
	void hospitalFileDelete(String hospitalId) throws Exception;
	
	
	// (병원회원) 마이페이지 - 예약 정보
	List<HosportalReserveDto> hospitalMypageReserve(String hospitalId) throws Exception;
	
	// (병원회원) 예약 종료 처리
	void mypagereserveFinished(HosportalReserveDto data) throws Exception;
	
	// (병원회원) 예약 종료 처리
	void normalMypageReserveCancel(HosportalReserveDto data) throws Exception;
	
	// (병원회원) 마이페이지 리뷰 정보
	List<HosportalReviewDto> hospitalMypageReview(String hospitalId) throws Exception;
	
	//(병원회원) 마이페이지 문의 정보
	List<HosportalQuestionDto> hospitalMypageQuestion(String hospitalId) throws Exception;
	
	// 병원 문의 상세
	HosportalQuestionDto questionHospitalDetail(int questionNo)throws Exception;
	
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
	
	// (종목별) 정렬
	//피부과 Dermatology 정렬
	List<HosportalHospitalMemberDto> Dermatology(String search_param) throws Exception;
	
	//치과 Dentist 정렬
	List<HosportalHospitalMemberDto> Dentist(String search_param) throws Exception;
	
	//안과 Ophthalmology 정렬
	List<HosportalHospitalMemberDto> Ophthalmology(String search_param) throws Exception;
	
	//내과 medicine 정렬
	List<HosportalHospitalMemberDto> medicine(String search_param) throws Exception;
	
	//한의원 Orientalmedicine 정렬
	List<HosportalHospitalMemberDto> Orientalmedicine(String search_param) throws Exception;
	
	//산부인과 Obstetricsandgynecology 정렬
	List<HosportalHospitalMemberDto> Obstetricsandgynecology(String search_param) throws Exception;
	
	//성형외과 PlasticSurgery 정렬
	List<HosportalHospitalMemberDto> PlasticSurgery(String search_param) throws Exception;
	
	//소아청소년과 DepartmentofPediatricsandAdolescents 정렬
	List<HosportalHospitalMemberDto> DepartmentofPediatricsandAdolescents(String search_param) throws Exception;
	
	//이비인후과 Otorhinolaryngology 정렬
	List<HosportalHospitalMemberDto> Otorhinolaryngology(String search_param) throws Exception;
	
	//가정의학과 DepartmentofFamilyMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofFamilyMedicine(String search_param) throws Exception;
	
	//정신건강의학과 DepartmentofMentalHealthMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofMentalHealthMedicine(String search_param) throws Exception;
	
	//재활의학과 DepartmentofRehabilitationMedicine 정렬
	List<HosportalHospitalMemberDto> DepartmentofRehabilitationMedicine(String search_param) throws Exception;
	
	//외과 surgery 정렬
	List<HosportalHospitalMemberDto> surgery(String search_param) throws Exception;
	
	//정형외과 Orthopedics 정렬
	List<HosportalHospitalMemberDto> Orthopedics(String search_param) throws Exception;
	
	//신경과 Neurology 정렬
	List<HosportalHospitalMemberDto> Neurology(String search_param) throws Exception;
	
	//비뇨기과 urology 정렬
	List<HosportalHospitalMemberDto> urology(String search_param) throws Exception;
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 끝                                                                        //
	//                                                         지역별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	// Seoul 서울
	List<HosportalHospitalMemberDto> Seoul(String search_param) throws Exception;
	
	// Incheon 인천
	List<HosportalHospitalMemberDto> Incheon(String search_param) throws Exception;
	
	// Gyeonggi 경기
	List<HosportalHospitalMemberDto> Gyeonggi(String search_param) throws Exception;
	
	// Chungbuk 충북
	List<HosportalHospitalMemberDto> Chungbuk(String search_param) throws Exception;
	
	// Chungnam 충남
	List<HosportalHospitalMemberDto> Chungnam(String search_param) throws Exception;
	
	// Gangwon 강원
	List<HosportalHospitalMemberDto> Gangwon(String search_param) throws Exception;
	
	// Sejong 세종
	List<HosportalHospitalMemberDto> Sejong(String search_param) throws Exception;
	
	// Daejeon 대전
	List<HosportalHospitalMemberDto> Daejeon(String search_param) throws Exception;
	
	// Gyeongbuk 경북
	List<HosportalHospitalMemberDto> Gyeongbuk(String search_param) throws Exception;
	
	// Gyeongnam 경남
	List<HosportalHospitalMemberDto> Gyeongnam(String search_param) throws Exception;
	
	// Daegu 대구
	List<HosportalHospitalMemberDto> Daegu(String search_param) throws Exception;
	
	// Jeollabuk 전북
	List<HosportalHospitalMemberDto> Jeollabuk(String search_param) throws Exception;
	
	// Jeollanam 전남
	List<HosportalHospitalMemberDto> Jeollanam(String search_param) throws Exception;
	
	// Gwangju 광주
	List<HosportalHospitalMemberDto> Gwangju(String search_param) throws Exception;
	
	// Ulsan 울산
	List<HosportalHospitalMemberDto> Ulsan(String search_param) throws Exception;
	
	// Busan 부산
	List<HosportalHospitalMemberDto> Busan(String search_param) throws Exception;
	
	// Jeju 제주
	List<HosportalHospitalMemberDto> Jeju(String search_param) throws Exception;
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         지역별 정렬 끝                                                                        //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
}
