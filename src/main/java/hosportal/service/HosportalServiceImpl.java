package hosportal.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hosportal.common.CommunityFileUtil;
import hosportal.common.EventFileUtil;
import hosportal.common.FileUtil;
import hosportal.common.HospitalMemberFileUtil;
import hosportal.common.NormalMemberFileUtil;
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
import hosportal.mapper.HosportalMapper;
import hosportal.paging.Criteria2;
import hosportal.paging.PaginationInfo;

@Service
public class HosportalServiceImpl implements HosportalService {
	
	@Autowired
	private HosportalMapper hosportalMapper;
	@Autowired
	private FileUtil fileUtil;
	@Autowired
	private NormalMemberFileUtil normalMemberFileUtil;
	@Autowired
	private EventFileUtil evnetFileUtil;
	@Autowired
	private HospitalMemberFileUtil hospitalMemberFileUtil;
	@Autowired
	private CommunityFileUtil communityFileUtil;
	@Autowired
	private EventFileUtil eventFileUtil; // 오타 있음
	
	
	// 최신 병원 리스트
	@Override
	public List<HosportalHospitalMemberDto> newHospitalList() throws Exception {
		return hosportalMapper.newHospitalList();
	}
	//베스트 뷰 리스트 
	@Override
	public List<HosportalHospitalMemberDto> bestHospitalList() throws Exception {
		
		return hosportalMapper.bestHospitalList();
	}
	
	//메인이벤트
	@Override
	public List<HosportalEventDto> mainEventList() throws Exception {
		return hosportalMapper.mainEventList();
	}
	
	//메인커뮤니티
	@Override
	public List<HosportalCommunityDto> mainCommunityList() throws Exception {
		return hosportalMapper.mainCommunityList();
	}
	
	// 개입회원 회원가입
	@Override
	public void insertNormalMember(HosportalNormalMemberDto member,  MultipartHttpServletRequest uploadFiles) throws Exception {
		hosportalMapper.insertNormalMember(member);
		
		List<FileDto> fileList = normalMemberFileUtil.parseFileInfo(uploadFiles, member.getNormalEmail());
		
		if(CollectionUtils.isEmpty(fileList) == false) {
			hosportalMapper.insertNormalFile(fileList);
		}
		
	}
	
	// 병원 회원가입
	@Override
	public void insertHospitalFile(HosportalHospitalMemberDto member, MultipartHttpServletRequest uploadFiles)
			throws Exception {
		
		hosportalMapper.insertHospitalMember(member);
		
		List<FileDto> fileList = fileUtil.parseFileInfo(uploadFiles, member.getHospitalId());
		
		if(CollectionUtils.isEmpty(fileList) == false) {
			hosportalMapper.insertHospitalFile(fileList);
		}
		
	}
	
	// 개인회원 회원가입 아이디 중복체크
	@Override
	public int normalEmailCheck(String normalEmail) throws Exception {
		return hosportalMapper.normalEmailCheck(normalEmail);
	}

	
	
	
	// 병원 회원가입 아이디 중복 체크
	@Override
	public int hospitalIdCheck(String hospitalId) throws Exception {
		return hosportalMapper.hospitalIdCheck(hospitalId);
	}

	// 병원 목록
	@Override
	public List<HosportalHospitalMemberDto> selectHosfitalList(HosportalHospitalMemberDto params) throws Exception {
		
		List<HosportalHospitalMemberDto> hospitalList = Collections.emptyList();
		
		int hospitalTotalCount = hosportalMapper.selectHospitalTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(hospitalTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if (hospitalTotalCount > 0) {
			hospitalList = hosportalMapper.selectHosfitalList(params);
		}
		
		return hospitalList;
	}

	// 개인회원 로그인 체크
	@Override
	public int normalLoginCheck(String id, String pw) throws Exception {
		return hosportalMapper.normalLoginCheck(id, pw);
	}

	// (개인회원)병원 상세보기
	@Override
	public HosportalHospitalMemberDto hosportalDetail(String hospitalId) throws Exception {
		//조회수 증가
		hosportalMapper.hospitalViewCount(hospitalId);
		
		return hosportalMapper.hosportalDetail(hospitalId);
	}

	// 병원회원 로그인 체크
	@Override
	public int hospitalLoginCheck(String id, String pw) throws Exception {
		return hosportalMapper.hospitalLoginCheck(id, pw);
	}



	
	// (개인회원) 이벤트 불러오기
		@Override
		public List<HosportalEventDto> selectEvents(Criteria2 cri) throws Exception{
			List<HosportalEventDto> eventList = hosportalMapper.selectEvents(cri);
			
			for (int i = 0; i < eventList.size(); i++) {
				int eventNo = eventList.get(i).getEventNo();
				List<FileDto> eventFileList = hosportalMapper.selectEventFileList(eventNo);
				
				eventList.get(i).setFileList(eventFileList); 
			}		
			return eventList;
		}
		
		// (개인회원) 이벤트 상세보기
		@Override
		public HosportalEventDto selectEventDetail(int eventNo) throws Exception{
			hosportalMapper.updateEventHitCount(eventNo);
			return hosportalMapper.selectEventDetail(eventNo);
		}
		
		// (병원) 이벤트 입력
		@Override
		public void insertEvent(HosportalEventDto event, MultipartHttpServletRequest uploadFiles)throws Exception{
			hosportalMapper.insertEvent(event);
			List<FileDto> fileList = eventFileUtil.parseFileInfo(event.getEventNo(), uploadFiles); //오타 수정

			if (CollectionUtils.isEmpty(fileList) == false) {
				hosportalMapper.insertEventFileList(fileList);
			}
		}
		@Override
		public void updateEventFileUpdate(HosportalEventDto event, MultipartHttpServletRequest uploadFiles) throws Exception {
			List<FileDto> fileList = eventFileUtil.parseFileInfo(event.getEventNo(), uploadFiles);
			
			
			if (CollectionUtils.isEmpty(fileList) == false) {
				hosportalMapper.updateEventFileUpdate(fileList);
			}
		}

		@Override
		public void updateEventFileDelete(int eventNo) throws Exception {
			hosportalMapper.updateEventFileDelete(eventNo);
		}
		
		// (개인회원) 이벤트 수정
		@Override
		public void updateEvent(HosportalEventDto event) throws Exception{
			hosportalMapper.updateEvent(event);
		}
		
		// (개인회원) 이벤트 삭제
		@Override
		public void deleteEvent(int eventNo)throws Exception{
			hosportalMapper.deleteEvent(eventNo);
		}
		
		// (개인회원) 이벤트 페이징
		@Override
		public int EventListCountCriteria(Criteria2 cri) throws Exception{
			return hosportalMapper.EventListCountCriteria(cri);
		}
		
		// (개인회원)커뮤니티 목록 불어오기
		@Override
		public List<HosportalCommunityDto> selectCommunityList(Criteria2 cri) throws Exception {
			return hosportalMapper.selectCommunityList(cri);
		}

		// (개인회원)커뮤니티 상세보기
		@Override
		public HosportalCommunityDto selectCommunityDetail(int communityNo) throws Exception {
			hosportalMapper.updateCommunityHitCount(communityNo);
			return hosportalMapper.communityDetail(communityNo);
		}
		
		// (개인회원) 커뮤니티 입력	
		@Override
		public void insertCommunity(HosportalCommunityDto community)throws Exception{
			hosportalMapper.insertCommunity(community);
			
		}
		
		// (개인회원)커뮤니티 수정
		@Override
		public void updateCommunity(HosportalCommunityDto community)throws Exception{
			hosportalMapper.updateCommunity(community);
		}
		
		@Override
		public void communityFileUpdate(HosportalCommunityDto community, MultipartHttpServletRequest uploadFiles) throws Exception {
			List<FileDto> fileList = communityFileUtil.parseFileInfo(community.getCommunityNo(), uploadFiles);
			
			
			if (CollectionUtils.isEmpty(fileList) == false) {
				hosportalMapper.communityFileUpdate(fileList);
			}
		}

		@Override
		public void communityFileDelete(int communityNo) throws Exception {
			hosportalMapper.communityFileDelete(communityNo);
		}
		
		
		// (개인회원)커뮤니티 삭제
		@Override
		public void deleteCommunity(int communityNo)throws Exception{
			hosportalMapper.deleteCommunity(communityNo);
		}
		
		// (개인회원)커뮤니티 페이징
		@Override
		public int CommunityListCountCriteria(Criteria2 cri)throws Exception{
			return hosportalMapper.CommunityListCountCriteria(cri);
		}
		
		// (개인회원)커뮤니티 댓글
		@Override
		public List<ReCommunityDto> selectReCommunityList(int commuNo) throws Exception{
			return hosportalMapper.selectReCommunityList(commuNo);
		}
//		댓글 입력
		@Override
		public void insertReCommunity(ReCommunityDto reCommunity)throws Exception{
			hosportalMapper.insertReCommunity(reCommunity);
		}
//		댓글 수정
		@Override
		public void updateReCommunity(ReCommunityDto reCommunity)throws Exception{
			hosportalMapper.updateReCommunity(reCommunity);
		}
//		댓글 삭제
		@Override
		public void deleteReCommunity(int reCommunityNo)throws Exception{
			hosportalMapper.deleteReCommunity(reCommunityNo);
		}
	
	
	
	//(개인회원) 이벤트 목록
	
	@Override
	public List<HosportalEventDto> selectEventList(HosportalEventDto params) throws Exception {
		List<HosportalEventDto> eventList = Collections.emptyList();
		
		
		
		
		return eventList;
	}

	// (개인회원) 마이페이지 - 회원 상세보기
	@Override
	public HosportalNormalMemberDto normalMemberDetail(String normalEmail) throws Exception {
		return hosportalMapper.normalMemberDetail(normalEmail);
	}
	
	// (개인회원) 회원 수정
	@Override
	public void normalMemberUpdate(HosportalNormalMemberDto data) throws Exception {
		hosportalMapper.normalMemberUpdate(data);
	}
	
	@Override
	public void normalFileUpdate(HosportalNormalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception {
		List<FileDto> fileList = normalMemberFileUtil.parseFileInfo(uploadFiles, data.getNormalEmail());
		
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			hosportalMapper.normalFileUpdate(fileList);
		}

	}
	 
	@Override
	public void normalFileDelete(String normalEmail) throws Exception {
		
		
		hosportalMapper.normalFileDelete(normalEmail);
	}
	
	
	// 병원 예약하기
	@Override
	public void hospitalReserve(HosportalReserveDto data) throws Exception {
		hosportalMapper.hospitalReserve(data);
	}
	
	// (개인회원) 마이페이지 - 예약 정보
	@Override
	public List<HosportalReserveDto> normalMypageReserve(HosportalReserveDto params) throws Exception {
		
		List<HosportalReserveDto> reserveList = Collections.emptyList();
		
		int reserveTotalCount = hosportalMapper.selectReserveTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reserveTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(reserveTotalCount > 0) {
			reserveList = hosportalMapper.normalMypageReserve(params);
		}
		
		
		return reserveList;
	}
	
	// 병원 문의하기
	@Override
	public void hospitalQuestion(HosportalQuestionDto data) throws Exception {
		hosportalMapper.hospitalQuestion(data);
		
	}
	
	// (개인회원) 마이페이지 문의 정보
	@Override
	public List<HosportalQuestionDto> normalMypageQuestion(HosportalQuestionDto params) throws Exception {
		List<HosportalQuestionDto> QuestionList = Collections.emptyList();
		
		int QuestionTotalCount = hosportalMapper.selectQuestionTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(QuestionTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(QuestionTotalCount > 0) {
			QuestionList = hosportalMapper.normalMypageQuestion(params);
		}
		
		
		return QuestionList;
	}
	
	// (개인회원) 마이페이지 문의 상세
	@Override
	public HosportalQuestionDto normalMypageQuestionDetail(int questionNo) throws Exception{
		return hosportalMapper.mypageQuestionDetail(questionNo);
	}
	
	// (개인회원) 마이페이지 문의 수정
	@Override
	public void updateMyQuestion(HosportalQuestionDto question) throws Exception{
		hosportalMapper.updateMyQuestion(question);
	}
		
	// (개인회원) 마이페이지 문의 삭제
	@Override
	public void deleteMyQuestion(int questionNo) throws Exception{
		hosportalMapper.deleteMyQuestion(questionNo);
	}
	
	
	// (개인회원) 마이페이지 리뷰 정보
	public List<HosportalReviewDto> normalMypageReview(HosportalReviewDto params) throws Exception {
		List<HosportalReviewDto> ReviewList = Collections.emptyList();
		
		int reviewTotalCount = hosportalMapper.selectReviewTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reviewTotalCount);
		
		params.setPaginationInfo(paginationInfo);
		
		if(reviewTotalCount > 0) {
			ReviewList = hosportalMapper.normalMypageReview(params);
		}
		
		
		return ReviewList;
	}
	
	// 병원 리뷰쓰기
	@Override
	public void hospitalReview(HosportalReviewDto data) throws Exception {
		hosportalMapper.hospitalReview(data);
	}
	
	// 병원 리뷰보기
	@Override
	public List<HosportalReviewDto> oneHospitalReview(String hospitalId) throws Exception {
		return hosportalMapper.oneHospitalReview(hospitalId);
	}

	

	// (병원회원) 마이페이지 - 병원정보 상세보기
	@Override
	public HosportalHospitalMemberDto hospitalMemberDetail(String hospitalId) throws Exception {
		return hosportalMapper.hospitalMemberDetail(hospitalId);
	}
	
	// (병원회원) 회원 수정
	@Override
	public void hospitalMemberUpdate(HosportalHospitalMemberDto data) throws Exception {
		hosportalMapper.hospitalMemberUpdate(data);
	}
	@Override
	public void hospitalFileUpdate(HosportalHospitalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception {
		List<FileDto> fileList = hospitalMemberFileUtil.parseFileInfo(uploadFiles, data.getHospitalId());
		
		
		if (CollectionUtils.isEmpty(fileList) == false) {
			hosportalMapper.hospitalFileUpdate(fileList);
		}

	}

	
	@Override
	public void hospitalFileDelete(String hospitalId) throws Exception {
		hosportalMapper.hospitalFileDelete(hospitalId);
	}
	
	

	// (병원회원) 마이페이지 - 예약 정보
	@Override
	public List<HosportalReserveDto> hospitalMypageReserve(String hospitalId) throws Exception {
		return hosportalMapper.hospitalMypageReserve(hospitalId);
	}

	// (병원회원) 예약 완료 처리
	@Override
	public void mypagereserveFinished(HosportalReserveDto data) throws Exception {
		hosportalMapper.mypagereserveFinished(data);
	}
	
	//(개인회원) 마이페이지 예약 취소
	@Override
	public void normalMypageReserveCancel(HosportalReserveDto data) throws Exception {
		hosportalMapper.normalMypageReserveCancel(data);
		
	}
	
	// (병원회원) 마이페이지 리뷰 정보
	@Override
	public List<HosportalReviewDto> hospitalMypageReview(String hospitalId) throws Exception {
		return hosportalMapper.hospitalMypageReview(hospitalId);
	}
	
	// (병원회원) 마이페이지 문의 정보
	@Override
	public List<HosportalQuestionDto> hospitalMypageQuestion(String hospitalId) throws Exception {
		// TODO Auto-generated method stub
		return hosportalMapper.hospitalMypageQuestion(hospitalId);
	}
	
	// 병원 문의 상세
	@Override
	public HosportalQuestionDto questionHospitalDetail(int questionNo)throws Exception{
		return hosportalMapper.questionHospitalDetail(questionNo);
	}
	
	// (병원회원)문의 댓글 리스트
	@Override	
	public List<ReQuestionDto> selectReQuestionList(int questionNo)throws Exception{
		return hosportalMapper.selectReQuestionList(questionNo);
	}
		
	// (병원회원)문의 댓글 입력
	@Override
	public void insertReQuestion(ReQuestionDto reQuestion)throws Exception{
		hosportalMapper.insertReQuestion(reQuestion);
	}
		
	// (병원회원)문의 댓글 수정
	@Override	
	public void updateReQuestion(ReQuestionDto reQuestion)throws Exception{
		hosportalMapper.updateReQuestion(reQuestion);
	}
		
	// (병원회원)문의 댓글 삭제
	@Override	
	public void deleteReQuestion(int reQuestionNo)throws Exception{
		hosportalMapper.deleteReQuestion(reQuestionNo);
	}
	
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	// (종목별) 정렬
	//피부과 Dermatology 정렬
	@Override
	public List<HosportalHospitalMemberDto> Dermatology(String search_param) throws Exception {
	return hosportalMapper.Dermatology(search_param);
	}
	
	//치과 Dentist 정렬
	@Override
	public List<HosportalHospitalMemberDto> Dentist(String search_param) throws Exception {
	return hosportalMapper.Dentist(search_param);
	}
	
	//안과 Ophthalmology 정렬
	@Override
	public List<HosportalHospitalMemberDto> Ophthalmology(String search_param) throws Exception {
	return hosportalMapper.Ophthalmology(search_param);
	}
	
	//내과 medicine 정렬
	@Override
	public List<HosportalHospitalMemberDto> medicine(String search_param) throws Exception {
	return hosportalMapper.medicine(search_param);
	}
	
	//한의원 Orientalmedicine 정렬
	@Override
	public List<HosportalHospitalMemberDto> Orientalmedicine(String search_param) throws Exception {
	return hosportalMapper.Orientalmedicine(search_param);
	}
	
	//산부인과 Obstetricsandgynecology 정렬
	@Override
	public List<HosportalHospitalMemberDto> Obstetricsandgynecology(String search_param) throws Exception {
	return hosportalMapper.Obstetricsandgynecology(search_param);
	}
	
	//성형외과 PlasticSurgery 정렬
	@Override
	public List<HosportalHospitalMemberDto> PlasticSurgery(String search_param) throws Exception {
	return hosportalMapper.PlasticSurgery(search_param);
	}
	
	//소아청소년과 DepartmentofPediatricsandAdolescents 정렬
	@Override
	public List<HosportalHospitalMemberDto> DepartmentofPediatricsandAdolescents(String search_param) throws Exception {
	return hosportalMapper.DepartmentofPediatricsandAdolescents(search_param);
	}
	
	//이비인후과 Otorhinolaryngology 정렬
	@Override
	public List<HosportalHospitalMemberDto> Otorhinolaryngology(String search_param) throws Exception {
	return hosportalMapper.Otorhinolaryngology(search_param);
	}
	
	//가정의학과 DepartmentofFamilyMedicine 정렬
	@Override
	public List<HosportalHospitalMemberDto> DepartmentofFamilyMedicine(String search_param) throws Exception {
	return hosportalMapper.DepartmentofFamilyMedicine(search_param);
	}
	
	//정신건강의학과 DepartmentofMentalHealthMedicine 정렬
	@Override
	public List<HosportalHospitalMemberDto> DepartmentofMentalHealthMedicine(String search_param) throws Exception {
	return hosportalMapper.DepartmentofMentalHealthMedicine(search_param);
	}
	
	//재활의학과 DepartmentofRehabilitationMedicine 정렬
	@Override
	public List<HosportalHospitalMemberDto> DepartmentofRehabilitationMedicine(String search_param) throws Exception {
	return hosportalMapper.DepartmentofRehabilitationMedicine(search_param);
	}
	
	//외과 surgery 정렬
	@Override
	public List<HosportalHospitalMemberDto> surgery(String search_param) throws Exception {
	return hosportalMapper.surgery(search_param);
	}
	
	//정형외과 Orthopedics 정렬
	@Override
	public List<HosportalHospitalMemberDto> Orthopedics(String search_param) throws Exception {
	return hosportalMapper.Orthopedics(search_param);
	}
	
	//신경과 Neurology 정렬
	@Override
	public List<HosportalHospitalMemberDto> Neurology(String search_param) throws Exception {
	return hosportalMapper.Neurology(search_param);
	}
	
	//비뇨기과 urology 정렬
	@Override
	public List<HosportalHospitalMemberDto> urology(String search_param) throws Exception {
	return hosportalMapper.urology(search_param);
	}
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 끝                                                                        //
	//                                                         지역별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	// Seoul 서울
	@Override
	public List<HosportalHospitalMemberDto> Seoul(String search_param) throws Exception {
	return hosportalMapper.Seoul(search_param);
	}
	
	// Incheon 인천
	@Override
	public List<HosportalHospitalMemberDto> Incheon(String search_param) throws Exception {
	return hosportalMapper.Incheon(search_param);
	}
	
	// Gyeonggi 경기
	@Override
	public List<HosportalHospitalMemberDto> Gyeonggi(String search_param) throws Exception {
	return hosportalMapper.Gyeonggi(search_param);
	}
	
	// Chungbuk 충북
	@Override
	public List<HosportalHospitalMemberDto> Chungbuk(String search_param) throws Exception {
	return hosportalMapper.Chungbuk(search_param);
	}
	
	// Chungnam 충남
	@Override
	public List<HosportalHospitalMemberDto> Chungnam(String search_param) throws Exception {
	return hosportalMapper.Chungnam(search_param);
	}
	
	// Gangwon 강원
	@Override
	public List<HosportalHospitalMemberDto> Gangwon(String search_param) throws Exception {
	return hosportalMapper.Gangwon(search_param);
	}
	
	// Sejong 세종
	@Override
	public List<HosportalHospitalMemberDto> Sejong(String search_param) throws Exception {
	return hosportalMapper.Sejong(search_param);
	}
	
	// Daejeon 대전
	@Override
	public List<HosportalHospitalMemberDto> Daejeon(String search_param) throws Exception {
	return hosportalMapper.Daejeon(search_param);
	}
	
	// Gyeongbuk 경북
	@Override
	public List<HosportalHospitalMemberDto> Gyeongbuk(String search_param) throws Exception {
	return hosportalMapper.Gyeongbuk(search_param);
	}
	
	// Gyeongnam 경남
	@Override
	public List<HosportalHospitalMemberDto> Gyeongnam(String search_param) throws Exception {
	return hosportalMapper.Gyeongnam(search_param);
	}
	
	// Daegu 대구
	@Override
	public List<HosportalHospitalMemberDto> Daegu(String search_param) throws Exception {
	return hosportalMapper.Daegu(search_param);
	}
	
	// Jeollabuk 전북
	@Override
	public List<HosportalHospitalMemberDto> Jeollabuk(String search_param) throws Exception {
	return hosportalMapper.Jeollabuk(search_param);
	}
	
	// Jeollanam 전남
	@Override
	public List<HosportalHospitalMemberDto> Jeollanam(String search_param) throws Exception {
	return hosportalMapper.Jeollanam(search_param);
	}
	
	// Gwangju 광주
	@Override
	public List<HosportalHospitalMemberDto> Gwangju(String search_param) throws Exception {
	return hosportalMapper.Gwangju(search_param);
	}
	
	// Ulsan 울산
	@Override
	public List<HosportalHospitalMemberDto> Ulsan(String search_param) throws Exception {
	return hosportalMapper.Ulsan(search_param);
	}
	
	// Busan 부산
	@Override
	public List<HosportalHospitalMemberDto> Busan(String search_param) throws Exception {
	return hosportalMapper.Busan(search_param);
	}
	
	// Jeju 제주
	@Override
	public List<HosportalHospitalMemberDto> Jeju(String search_param) throws Exception {
	return hosportalMapper.Jeju(search_param);
	}
	
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         지역별 정렬 끝                                                                        //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	

	

	



	

		
	
}
