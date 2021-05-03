package hosportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

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
import hosportal.paging.Pagination;
import hosportal.service.HosportalService;

@Controller
public class HosportalController {

	@Autowired
	private HosportalService hosportalService;
	
	 
	@RequestMapping(value = "/normal/index", method = RequestMethod.GET)
	public ModelAndView index() throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/index");
		List<HosportalHospitalMemberDto> newHospital = hosportalService.newHospitalList();
		mv.addObject("newHospital", newHospital);
		
		List<HosportalHospitalMemberDto> bestHospital = hosportalService.bestHospitalList();
		mv.addObject("bestHospital", bestHospital);
		
		List<HosportalEventDto> event = hosportalService.mainEventList();
		mv.addObject("event", event);
		
		List<HosportalCommunityDto> community = hosportalService.mainCommunityList();
		mv.addObject("community", community);
		
		return mv;
	}
	
	@RequestMapping(value = "/hospital/index", method = RequestMethod.GET)
	public ModelAndView hospitalIndex() throws Exception{
		ModelAndView mv = new ModelAndView("hospital/index");
		List<HosportalHospitalMemberDto> newHospital = hosportalService.newHospitalList();
		mv.addObject("newHospital", newHospital);
		
		List<HosportalHospitalMemberDto> bestHospital = hosportalService.bestHospitalList();
		mv.addObject("bestHospital", bestHospital);
		return mv;
	}
	@RequestMapping(value = "/normal/community/detail", method = RequestMethod.GET)
	public String detail() throws Exception{
		return "/hosportal/communityDetail";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception{
		return "/hosportal/login";
	}
	@RequestMapping(value = "/registerWrap", method = RequestMethod.GET)
	public String registerWrap() throws Exception{
		return "/hosportal/registerWrap";
	}
	@RequestMapping(value = "/normal_register", method = RequestMethod.GET)
	public String normal_register() throws Exception{
		return "/hosportal/normal_register";
	}
	@RequestMapping(value = "/hospital_register", method = RequestMethod.GET)
	public String hospital_register() throws Exception{
		return "/hosportal/hospital_register";
	}
	
	// (개인회원) 회원가입
	@RequestMapping(value = "/normal_registerProc", method = RequestMethod.POST)
	public String normal_registerProc(HosportalNormalMemberDto member, MultipartHttpServletRequest request) throws Exception{
		member.setNormalTel(member.getNormalTel1() + member.getNormalTel2() + member.getNormalTel3());
		hosportalService.insertNormalMember(member, request);
		return "redirect:/normal/index";
	}

	// (병원회원) 회원가입
	@RequestMapping(value = "/hospital/registerProc", method = RequestMethod.POST)
	public String hospital_registerProc(HosportalHospitalMemberDto Hmember, MultipartHttpServletRequest request) throws Exception{
		Hmember.setHospitalTel(Hmember.getHospitalTel1() + "-" + Hmember.getHospitalTel2() + "-" + Hmember.getHospitalTel3());
		hosportalService.insertHospitalFile(Hmember, request);
		return "redirect:/normal/index";  
	}
	
	// 병원 리스트
	@RequestMapping(value = "/normal/hosfital1", method = RequestMethod.GET)
	public ModelAndView normalHosfitalList(@ModelAttribute("params") HosportalHospitalMemberDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/hosfital1");
		List<HosportalHospitalMemberDto> hosfitalList = hosportalService.selectHosfitalList(params);
		mv.addObject("data", hosfitalList);
		return mv;
	}
	// 병원 리스트
		@RequestMapping(value = "/normal/hosfital2", method = RequestMethod.GET)
		public ModelAndView normalHosfitalList2(@ModelAttribute("params") HosportalHospitalMemberDto params) throws Exception{
			ModelAndView mv = new ModelAndView("hosportal/hosfital2");
			List<HosportalHospitalMemberDto> hosfitalList = hosportalService.selectHosfitalList(params);
			mv.addObject("data", hosfitalList);
			return mv;
		}
	// 병원 리스트 (병원 / 지역별)
	@RequestMapping(value = "/hospital/hospital2", method = RequestMethod.GET)
	public ModelAndView hospitalHospitalList2(@ModelAttribute("params") HosportalHospitalMemberDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospital2");
		List<HosportalHospitalMemberDto> hosfitalList2 = hosportalService.selectHosfitalList(params);
		mv.addObject("data", hosfitalList2);
		return mv;
	}
	
	// 병원 리스트 (병원 / 종목별)
	@RequestMapping(value = "/hospital/hospital1", method = RequestMethod.GET)
	public ModelAndView hospitalHospitalList(@ModelAttribute("params") HosportalHospitalMemberDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospital1");
		List<HosportalHospitalMemberDto> hosfitalList = hosportalService.selectHosfitalList(params);
		mv.addObject("data", hosfitalList);
		return mv;
	}

	
	
	
//	(개인회원) 이벤트
	@RequestMapping(value = "/normal/event", method = RequestMethod.GET)
	public ModelAndView selectEvents(Criteria2 cri) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/event");
		
		mv.addObject("eventList", hosportalService.selectEvents(cri));
		Pagination pagination = new Pagination();
		pagination.setCri(cri);
		pagination.setTotalCount(hosportalService.EventListCountCriteria(cri));
				
		mv.addObject("pagination", pagination);
		
		return mv;
	}
//	(병원회원) 이벤트
	@RequestMapping(value = "/hospital/event", method = RequestMethod.GET)
	public ModelAndView hospitalSelectEvents(Criteria2 cri) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/event");
		
		mv.addObject("eventList", hosportalService.selectEvents(cri));
		Pagination pagination = new Pagination();
		pagination.setCri(cri);
		pagination.setTotalCount(hosportalService.EventListCountCriteria(cri));
				
		mv.addObject("pagination", pagination);
		 
		return mv;
	}
	
	//	(개인회원)이벤트 상세보기
	@RequestMapping(value="/normal/EventDetail/{eventNo}", method=RequestMethod.GET)
	public ModelAndView normalEventDetail(@PathVariable("eventNo") int eventNo) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/EventDetail");
		HosportalEventDto item = hosportalService.selectEventDetail(eventNo);
		mv.addObject("item", item);
		
		return mv;
	}
//	(개인회원)이벤트 상세보기
	@RequestMapping(value="/hospital/EventDetail/{eventNo}", method=RequestMethod.GET)
	public ModelAndView hospitalEventDetail(@PathVariable("eventNo") int eventNo) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/EventDetail");
		HosportalEventDto item = hosportalService.selectEventDetail(eventNo);
		mv.addObject("item", item);
		
		return mv;
	}
	
	//	(병원)이벤트 수정하기 페이지
	@RequestMapping(value="/hospital/EventEdit/{eventNo}",method=RequestMethod.GET)
	public ModelAndView EventEdit(@PathVariable("eventNo") int eventNo)throws Exception{
		ModelAndView mv = new ModelAndView("hospital/EventEdit");
		HosportalEventDto item = hosportalService.selectEventDetail(eventNo);
		mv.addObject("item", item);
		return mv;
	}
	
//	(병원)이벤트 수정하기 처리 페이지
	@RequestMapping(value="/hospital/updateEvent/{eventNo}", method = {RequestMethod.PUT, RequestMethod.POST})
	public String updateEvent(HosportalEventDto event, MultipartHttpServletRequest uploadFiles) throws Exception{
		hosportalService.updateEvent(event);

		List<MultipartFile> files = uploadFiles.getFiles("files");
		if (files.get(0).getSize() > 0) {
			hosportalService.updateEventFileDelete(event.getEventNo());
			hosportalService.updateEventFileUpdate(event, uploadFiles);
		} 
		
		

		return "redirect:/hospital/event";
	}
	
	//	이벤트 글쓰기 페이지
	@RequestMapping(value="/hospital/eventWrite", method=RequestMethod.GET)
	public String writeEvent()throws Exception{
		
		return "/hospital/eventWrite";
	}
	//	이벤트 글 등록
	@RequestMapping(value="/hospital/insertEvent", method=RequestMethod.POST)
	public String insertEvent(HosportalEventDto event, MultipartHttpServletRequest uploadFiles) throws Exception{
		hosportalService.insertEvent(event, uploadFiles);
		return "redirect:/hospital/event";
	}
	
	//	이벤트글 삭제
	@RequestMapping(value="/hospital/deleteEvent/{eventNo}",method=RequestMethod.DELETE)
	public String deleteEvnet(@PathVariable("eventNo")int eventNo) throws Exception{
		hosportalService.deleteEvent(eventNo);
		return "redirect:/normal/event";
	}
	
	/*
	 * //(병원회원) 이벤트
	 * 
	 * @RequestMapping(value = "/hospital/event", method = RequestMethod.GET) public
	 * ModelAndView hospitalCommunity(@ModelAttribute("params") HosportalEventDto
	 * params) throws Exception{ ModelAndView mv = new
	 * ModelAndView("/hospital/hospitalEvent"); List<HosportalEventDto>
	 * communityList = hosportalService.selectEventList(params);
	 * mv.addObject("data", communityList); return mv; }
	 */
	
	
	
	//(개인회원) 커뮤니티
		@RequestMapping(value = "/normal/community", method = RequestMethod.GET)
		public ModelAndView normalCommunity(Criteria2 cri) throws Exception{
			ModelAndView mv = new ModelAndView("hosportal/community");
			
			mv.addObject("data", hosportalService.selectCommunityList(cri));		
			Pagination pagination = new Pagination();
			pagination.setCri(cri);
			pagination.setTotalCount(hosportalService.CommunityListCountCriteria(cri));
					
			mv.addObject("pagination", pagination);
			
			return mv;
		}
		
		//커뮤니티 상세보기
		@RequestMapping(value = "/normal/community/detail/{communityNo}", method = RequestMethod.GET)
		public ModelAndView normalDetailcommunity(@PathVariable("communityNo") int communityNo) throws Exception{
			ModelAndView mv = new ModelAndView("hosportal/communityDetail");
			HosportalCommunityDto data = hosportalService.selectCommunityDetail(communityNo);
			mv.addObject("data", data);
			mv.addObject("reCom", new ReCommunityDto());
			return mv;
		}
		
		//(병원회원) 커뮤니티 상세보기
		@RequestMapping(value = "/hospital/community/detail/{communityNo}", method = RequestMethod.GET)
		public ModelAndView hospitalDetailcommunity(@PathVariable("communityNo") int communityNo) throws Exception{
			ModelAndView mv = new ModelAndView("hospital/communityDetail");
			HosportalCommunityDto data = hosportalService.selectCommunityDetail(communityNo);
			mv.addObject("data", data);
			mv.addObject("reCom", new ReCommunityDto());
			return mv;
		}
		
		//(병원회원) 커뮤니티
		@RequestMapping(value = "/hospital/community", method = RequestMethod.GET)
		public ModelAndView hospitalCommunity(Criteria2 cri) throws Exception{
			ModelAndView mv = new ModelAndView("hospital/community");
			
			mv.addObject("data", hosportalService.selectCommunityList(cri));		
			Pagination pagination = new Pagination();
			pagination.setCri(cri);
			pagination.setTotalCount(hosportalService.CommunityListCountCriteria(cri));
					
			mv.addObject("pagination", pagination);
			
			return mv;
		}
		
		//	(개인회원)커뮤니티 수정하기 페이지
		@RequestMapping(value="/normal/communityEdit/{communityNo}",method=RequestMethod.GET)
		public ModelAndView CommunityEdit(@PathVariable("communityNo") int communityNo)throws Exception{
			ModelAndView mv = new ModelAndView("hosportal/communityEdit");
			HosportalCommunityDto item = hosportalService.selectCommunityDetail(communityNo);
			mv.addObject("item", item);
			return mv;
		}	
		
//		(개인회원)커뮤니티 수정하기 처리
		@RequestMapping(value="/normal/updateCommunity/{communityNo}", method = {RequestMethod.PUT, RequestMethod.POST})
		public String updateCommunity(HosportalCommunityDto community, MultipartHttpServletRequest uploadFiles)throws Exception{
			hosportalService.updateCommunity(community);
	
			List<MultipartFile> files = uploadFiles.getFiles("files");
			if (files.get(0).getSize() > 0) {
				hosportalService.communityFileDelete(community.getCommunityNo());
				hosportalService.communityFileUpdate(community, uploadFiles);
			} 
			
	
			return "redirect:/normal/community";
		}
		
		//	(개인회원)커뮤니티 글쓰기 페이지
		@RequestMapping(value="/normal/communityWrite", method=RequestMethod.GET)
		public String writeCommunity() throws Exception{
			
			return "/hosportal/communityWrite";
		}
		
		//	(개인회원)커뮤니티 글 등록
		@RequestMapping(value="/normal/insertCommunity", method=RequestMethod.POST)
		public String insertCommunity(HosportalCommunityDto community) throws Exception{
			hosportalService.insertCommunity(community);
			return "redirect:/normal/community";
		}
		
		//	(개인회원)커뮤니티글 삭제
		@RequestMapping(value="/normal/deleteCommunity/{communityNo}",method=RequestMethod.DELETE)
		public String deleteCommunity(@PathVariable("communityNo")int communityNo) throws Exception{
			hosportalService.deleteCommunity(communityNo);
			return "redirect:/normal/community";
		}
		
		//	(개인회원)댓글 보기
		@ResponseBody
		@RequestMapping(value="/hos/selectReCommunityList", method=RequestMethod.POST)
		public List<ReCommunityDto> selectReCommunityList(@RequestParam("commuNo") int commuNo)throws Exception {
			return hosportalService.selectReCommunityList(commuNo);
		}
		
		//	(개인회원)댓글 입력
		@ResponseBody
		@RequestMapping(value="/hosportal/insertReCommunity", method=RequestMethod.POST)
		public Object insertReCommunity(ReCommunityDto reCom)throws Exception{
			Map<String, Object> result = new HashMap<>();
			
			try {
				hosportalService.insertReCommunity(reCom);
				result.put("status", "ok");
			}catch(Exception e) {
				e.printStackTrace();
				result.put("status", "false");
			}		
			return result;
		}
		
		//	(개인회원)댓글 수정
		@ResponseBody
		@RequestMapping(value="/hosportal/updateReCommunity/{reCommunityNo}",method=RequestMethod.PUT)
		public Object updateReCommunity(ReCommunityDto reCom)throws Exception{
			Map<String, Object> result = new HashMap<>();
					
					try {
						hosportalService.updateReCommunity(reCom);
						result.put("status", "ok");
					}catch(Exception e) {
						e.printStackTrace();
						result.put("status", "false");
					}		
					return result;
		}
		
		//	(개인회원)댓글 삭제
		@ResponseBody
		@RequestMapping(value="/hosportal/deleteReCommunity/{reCommunityNo}",method=RequestMethod.DELETE)
		public Object deleteReCommunity(@PathVariable("reCommunityNo")int reCommunityNo)throws Exception{
			Map<String, Object> result = new HashMap<>();
			
			try {
				hosportalService.deleteReCommunity(reCommunityNo);
				result.put("status", "ok");
			}catch(Exception e) {
				e.printStackTrace();
				result.put("status", "false");
			}
			
			return result;
		}	
		
	
	
	
	//(개인회원) 회원가입 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/register/idCheck", method = RequestMethod.POST)
	public int idCheck(@RequestParam("normalEmail") String normalEmail) throws Exception {
		return hosportalService.normalEmailCheck(normalEmail);
	}
	
	//(병원회원) 회원가입 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/hospitalRegister/idCheck", method = RequestMethod.POST)
	public int hospitalIdCheck(@RequestParam("hospitalId") String hospitalId) throws Exception {
		return hosportalService.hospitalIdCheck(hospitalId);
	}
	
	//(개인회원) 로그인
	@RequestMapping("/login/normal/loginCheck")
	public String normalLoginCheck(@RequestParam String id, @RequestParam String pw, HttpServletRequest request) throws Exception{
		int count = hosportalService.normalLoginCheck(id, pw);
		
		if(count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("normalEmail", id);
			session.setMaxInactiveInterval(300);
			return "redirect:/normal/index";
		}
		else {
			return "redirect:/login";
		}
	}
	
	//(병원회원) 로그인
	@RequestMapping("/login/hospital/loginCheck")
	public String hospitalLoginCheck(@RequestParam String id, @RequestParam String pw, HttpServletRequest request) throws Exception{
		int count = hosportalService.hospitalLoginCheck(id, pw);
		
		if(count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("hospitalId", id);
			session.setMaxInactiveInterval(300);
			return "redirect:/hospital/index";
		}
		else {
			return "redirect:/login/loginFail";
		}
	}
	
	//로그아웃
	@RequestMapping(value="/login/normal/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("normalEmail");
		session.removeAttribute("hospitalId");
		session.invalidate();
		return "redirect:/normal/index";
	}
	
	// (개인회원)병원 상세보기
	@RequestMapping(value = "/normal/hospital/detail/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView normalDetailHospital(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("/hosportal/hospitalDetail");
		//병원정보		
		HosportalHospitalMemberDto data = hosportalService.hosportalDetail(hospitalId);
		mv.addObject("data", data);
		//리뷰
		List<HosportalReviewDto> review = hosportalService.oneHospitalReview(hospitalId);
		mv.addObject("review", review);
		return mv;
	}
	
	// (병원회원)병원 상세보기
	@RequestMapping(value = "/hospital/hospital/detail/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView hospitalDetailHospital(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("/hospital/hospitalDetail");
		//병원정보		
		HosportalHospitalMemberDto data = hosportalService.hosportalDetail(hospitalId);
		mv.addObject("data", data);
		//리뷰
		List<HosportalReviewDto> review = hosportalService.oneHospitalReview(hospitalId);
		mv.addObject("review", review);
		return mv;
	}
	
	//병원 예약하기 페이지
	@ResponseBody
	@RequestMapping(value = "/normal/hospital/reserve/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView reservePageHospital(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("/hosportal/hospitalReserve");
		HosportalHospitalMemberDto data = hosportalService.hosportalDetail(hospitalId);
		mv.addObject("data", data);
		return mv;
	}
	
	//병원 예약하기
	@RequestMapping(value = "/normal/hospital/reserveProc", method = RequestMethod.POST)
	public String reservHospital(HosportalReserveDto data) throws Exception{
		hosportalService.hospitalReserve(data);
		return "redirect:/normal/index";
	}
	
	//병원 문의하기 페이지
	@RequestMapping(value = "/normal/hospital/question/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView questionPageHospital(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("/hosportal/hospitalQuestion");
		HosportalHospitalMemberDto data = hosportalService.hosportalDetail(hospitalId);
		mv.addObject("data", data);
		return mv;
	}
	
	//병원 문의하기
	@RequestMapping(value = "/normal/hospital/questionProc", method = RequestMethod.POST)
	public String questionHospital(HosportalQuestionDto data) throws Exception{
		hosportalService.hospitalQuestion(data);
		return "redirect:/normal/index";
	}
	
	//병원 리뷰 페이지
	@RequestMapping(value = "/normal/hospital/review/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView reviewPageHospital(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("/hosportal/hospitalReview");
		HosportalHospitalMemberDto data = hosportalService.hosportalDetail(hospitalId);
		mv.addObject("data", data);
		return mv;
	}
	
	//병원 리뷰쓰기
	@RequestMapping(value = "/normal/hospital/reviewProc", method = RequestMethod.POST)
	public String reviewHospital(HosportalReviewDto data) throws Exception{
		hosportalService.hospitalReview(data);
		return "redirect:/normal/index";
	}
	//(개인회원) 마이페이지 회원 상세 정보
	@RequestMapping(value = "/normal/mypageInfo/{normalEmail}", method = RequestMethod.GET)
	public ModelAndView normalMypageInfo(@PathVariable("normalEmail") String normalEmail) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/normalMypageInfo");
		HosportalNormalMemberDto data = hosportalService.normalMemberDetail(normalEmail);
		data.setNormalTel2(data.getNormalTel().substring(3, 7));
		data.setNormalTel3(data.getNormalTel().substring(7, 11));
		mv.addObject("data", data);
		return mv;
	}

	
	//(개인회원) 회원 수정
		@RequestMapping(value = "/normal/mypageInfo/update/{normalEmail}", method = {RequestMethod.PUT, RequestMethod.POST}) 
		public String normalMypageInfoUpdate(HosportalNormalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception{
			data.setNormalTel(data.getNormalTel1() + data.getNormalTel2() + data.getNormalTel3());
			hosportalService.normalMemberUpdate(data); 
			
				List<MultipartFile> files = uploadFiles.getFiles("fileId");
				if(files.get(0).getSize() > 0) {
					hosportalService.normalFileDelete(data.getNormalEmail());
					hosportalService.normalFileUpdate(data, uploadFiles);
				}
			
			return "redirect:/normal/mypageInfo/{normalEmail}";
		}
	
	//(개인회원) 마이페이지 예약 정보
	@RequestMapping(value = "/normal/mypageReserveInfo/{normalEmail}", method = RequestMethod.GET)
	public ModelAndView normalMypageReserve(@ModelAttribute("params") HosportalReserveDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/normalMypageReserve");
		List<HosportalReserveDto> data = hosportalService.normalMypageReserve(params);
		mv.addObject("data", data);
		return mv;
	}
	//(개인회원) 마이페이지 예약 취소
	@RequestMapping(value = "/normal/hospital/review/cancel/{reserveNo}", method = RequestMethod.PUT)
	public String normalMypageReserveCancel(HosportalReserveDto data) throws Exception{
		hosportalService.normalMypageReserveCancel(data);
		String normalEmail = data.getNormalEmail();
		return "redirect:/normal/mypageReserveInfo/" + normalEmail;
	}

	
	//(개인회원) 마이페이지 문의 정보
	@RequestMapping(value = "/normal/mypageQuestionInfo/{normalEmail}", method = RequestMethod.GET)
	public ModelAndView normalMypageQuestion(@ModelAttribute("params") HosportalQuestionDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/normalMypageQuestion");
		List<HosportalQuestionDto> data = hosportalService.normalMypageQuestion(params);
		mv.addObject("data", data); 
		return mv;
	}
	
	//(개인회원) 마이페이지 문의 상세
	@RequestMapping(value="/normal/mypageQuestionDetail/{questionNo}", method=RequestMethod.GET)
	public ModelAndView normalMypageQuestion(@PathVariable("questionNo") int questionNo)throws Exception{
		ModelAndView mv = new ModelAndView("/hosportal/normalMypageQuestionDetail");
		HosportalQuestionDto data = hosportalService.normalMypageQuestionDetail(questionNo);
		mv.addObject("data", data);
		return mv;
	}
	
	//(개인회원) 마이페이지 문의 수정
	@RequestMapping(value="/normal/mypageQuesttionEdit/{questionNo}",method=RequestMethod.GET)
	public ModelAndView editMyQuestion(@PathVariable("questionNo") int questionNo)throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/normalMypageQuestionEdit");
		HosportalQuestionDto data = hosportalService.normalMypageQuestionDetail(questionNo);
		mv.addObject("data", data);
		
		return mv;
	}
	
	//(개인회원) 마이페이지 문의 수정처리
		@RequestMapping(value="/normal/mypageQuesttionUpdate/{questionNo}",method=RequestMethod.PUT)
		public String updateMyQuestion(HosportalQuestionDto question, @PathVariable("questionNo") int questionNo)throws Exception{
			HosportalQuestionDto data = hosportalService.normalMypageQuestionDetail(questionNo);
			String normalEmail = data.getNormalEmail();
			hosportalService.updateMyQuestion(question);
			return "redirect:/normal/mypageQuestionInfo/" + normalEmail;
		}	
	
	//(개인회원) 마이페이지 문의 삭제
	@RequestMapping(value="/normal/mypageQeustionDelete/{questionNo}", method=RequestMethod.DELETE)
	public String deleteQuestion(@PathVariable("questionNo") int questionNo) throws Exception{
		HosportalQuestionDto data = hosportalService.normalMypageQuestionDetail(questionNo);
		String normalEmail = data.getNormalEmail();
		hosportalService.deleteMyQuestion(questionNo);
		return "redirect:/normal/mypageQuestionInfo/" + normalEmail;
	}
	
	
	//(개인회원) 마이페이지 리뷰 정보
	@RequestMapping(value = "/normal/mypageReviewInfo/{normalEmail}", method = RequestMethod.GET)
	public ModelAndView normalMypageReview(@ModelAttribute("params") HosportalReviewDto params) throws Exception{
		ModelAndView mv = new ModelAndView("hosportal/normalMypageReview");
		List<HosportalReviewDto> data = hosportalService.normalMypageReview(params);
		mv.addObject("data", data);
		return mv; 
	}
	
	//(병원회원) 마이페이지 회원 상세
	@RequestMapping(value = "/hospital/mypageInfo/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView hospotalMypageInfo(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospitalMypageInfo");
		HosportalHospitalMemberDto data = hosportalService.hospitalMemberDetail(hospitalId);
		String tel = data.getHospitalTel();//02-1111-1111
		int firstbar = tel.indexOf("-"); // 2
		int lastbar = tel.lastIndexOf("-");data.setHospitalTel1(data.getHospitalTel().substring(0,firstbar));
		data.setHospitalTel2(data.getHospitalTel().substring(firstbar+1,lastbar));
		data.setHospitalTel3(data.getHospitalTel().substring(lastbar+1));
		mv.addObject("data", data);
	
		return mv;
	}
	
	//(병원회원) 회원 수정
	@RequestMapping(value = "/hospital/mypageInfo/update/{hospitalId}", method = {RequestMethod.PUT, RequestMethod.POST}) 
	public String hospitalMypageInfoUpdate(HosportalHospitalMemberDto data, MultipartHttpServletRequest uploadFiles) throws Exception{
		data.setHospitalTel(data.getHospitalTel1() + '-' + data.getHospitalTel2() + '-' + data.getHospitalTel3());
		hosportalService.hospitalMemberUpdate(data);
		
		// 파일 삭제 후 업데이트
		List<MultipartFile> files = uploadFiles.getFiles("fileId");
		if(files.get(0).getSize() > 0) {
			hosportalService.hospitalFileDelete(data.getHospitalId());
			hosportalService.hospitalFileUpdate(data, uploadFiles);
		}
		
		
		return "redirect:/hospital/mypageInfo/{hospitalId}";
		

	}
	
	//(병원회원) 마이페이지 예약 정보
	@RequestMapping(value = "/hospital/mypageReserveInfo/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView hospitalMypageReserve(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospitalMypageReserve");
		List<HosportalReserveDto> data = hosportalService.hospitalMypageReserve(hospitalId);
		mv.addObject("data", data);
		return mv;
	}
	
	//(병원회원) 예약완료버튼
	@RequestMapping(value = "/hospital/mypageReserveInfo/reserveFinished/{reserveNo}", method = RequestMethod.PUT)
	public String mypagereserveFinished(HosportalReserveDto data) throws Exception{
		hosportalService.mypagereserveFinished(data);
		String hospitalId = data.getHospitalId();
		return "redirect:/hospital/mypageReserveInfo/" + hospitalId;
	}
	
	//(병원회원) 마이페이지 리뷰 정보
	@RequestMapping(value = "/hospital/mypageReviewInfo/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView hospitalMypageReview(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospitalMypageReview");
		List<HosportalReviewDto> data = hosportalService.hospitalMypageReview(hospitalId);
		mv.addObject("data", data);
		return mv; 
	}
	
	//(병원회원) 마이페이지 문의 정보
	@RequestMapping(value = "/hospital/mypageQuestionInfo/{hospitalId}", method = RequestMethod.GET)
	public ModelAndView hospitalMypageQuestion(@PathVariable("hospitalId") String hospitalId) throws Exception{
		ModelAndView mv = new ModelAndView("hospital/hospitalMypageQuestion");
		List<HosportalQuestionDto> data = hosportalService.hospitalMypageQuestion(hospitalId);
		mv.addObject("data", data);
		return mv; 
	}
	
	//(병원회원) 문의 상세보기
		@RequestMapping(value="/hospital/mypageQuestionDetail/{questionNo}", method = RequestMethod.GET)
		public ModelAndView questionHospitalDetail(@PathVariable("questionNo") int questionNo)throws Exception{
			ModelAndView mv = new ModelAndView("hospital/hospitalMypageQuestionDetail");
			HosportalQuestionDto item = hosportalService.questionHospitalDetail(questionNo);
			mv.addObject("item", item);
			return mv;
		}
		
		//	(병원회원)문의글 댓글 보기
		@ResponseBody
		@RequestMapping(value="/selectReQuestionList", method=RequestMethod.POST)
		public List<ReQuestionDto> selectReQuestionList(@RequestParam("questionNo") int questionNo)throws Exception {
			return hosportalService.selectReQuestionList(questionNo);
		}
		
		// (병원회원)문의글 댓글 입력
		@ResponseBody
		@RequestMapping(value="/insertReQuestion", method=RequestMethod.POST)
		public Object insertReQuestion(ReQuestionDto reQuestion)throws Exception{
			Map<String, Object> result = new HashMap<>();
			
			try {
				hosportalService.insertReQuestion(reQuestion);
				result.put("status", "ok");
			}catch(Exception e) {
				e.printStackTrace();
				result.put("status", "false");
			}		
			return result;
		}
		
		// (병원회원)문의글 댓글 수정
		@ResponseBody
		@RequestMapping(value="/updateReQuestion/{reQuestionNo}",method=RequestMethod.PUT)
		public Object updateReQuestion(ReQuestionDto reQuestion)throws Exception{
			Map<String, Object> result = new HashMap<>();
					
					try {
						hosportalService.updateReQuestion(reQuestion);
						result.put("status", "ok");
					}catch(Exception e) {
						e.printStackTrace();
						result.put("status", "false");
					}		
					return result;
		}
		
		//(병원회원)문의글 댓글 삭제
		@ResponseBody
		@RequestMapping(value="/deleteReQuestion/{reQuestionNo}",method=RequestMethod.DELETE)
		public Object deleteReQuestion(@PathVariable("reQuestionNo")int reQuestionNo)throws Exception{
			Map<String, Object> result = new HashMap<>();
			
			try {
				hosportalService.deleteReQuestion(reQuestionNo);
				result.put("status", "ok");
			}catch(Exception e) {
				e.printStackTrace();
				result.put("status", "false");
			}
			
			return result;
		}	
			
	
	
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//피부과 Dermatology 정렬
	@RequestMapping(value = "/hosportal/Dermatology", method = RequestMethod.POST)
	@ResponseBody
	public Object Dermatology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Dermatology = hosportalService.Dermatology(search_param);
	
	return Dermatology;
	}
	
	//치과 Dentist 정렬
	@RequestMapping(value = "/hosportal/Dentist", method = RequestMethod.POST)
	@ResponseBody
	public Object Dentist(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Dentist = hosportalService.Dermatology(search_param);
	
	return Dentist;
	}
	
	//안과 Ophthalmology 정렬
	@RequestMapping(value = "/hosportal/Ophthalmology", method = RequestMethod.POST)
	@ResponseBody
	public Object Ophthalmology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Ophthalmology = hosportalService.Dermatology(search_param);
	
	return Ophthalmology;
	}
	
	//내과 medicine 정렬
	@RequestMapping(value = "/hosportal/medicine", method = RequestMethod.POST)
	@ResponseBody
	public Object medicine(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> medicine = hosportalService.Dermatology(search_param);
	
	return medicine;
	}
	
	//한의원 Orientalmedicine 정렬
	@RequestMapping(value = "/hosportal/Orientalmedicine", method = RequestMethod.POST)
	@ResponseBody
	public Object Orientalmedicine(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Orientalmedicine = hosportalService.Dermatology(search_param);
	
	return Orientalmedicine;
	}
	
	
	//산부인과 Obstetricsandgynecology 정렬
	@RequestMapping(value = "/hosportal/Obstetricsandgynecology", method = RequestMethod.POST)
	@ResponseBody
	public Object Obstetricsandgynecology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Obstetricsandgynecology = hosportalService.Dermatology(search_param);
	
	return Obstetricsandgynecology;
	}
	
	//성형외과 PlasticSurgery 정렬
	@RequestMapping(value = "/hosportal/PlasticSurgery", method = RequestMethod.POST)
	@ResponseBody
	public Object PlasticSurgery(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> PlasticSurgery = hosportalService.Dermatology(search_param);
	
	return PlasticSurgery;
	}
	
	//소아청소년과 DepartmentofPediatricsandAdolescents 정렬
	@RequestMapping(value = "/hosportal/DepartmentofPediatricsandAdolescents", method = RequestMethod.POST)
	@ResponseBody
	public Object DepartmentofPediatricsandAdolescents(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> DepartmentofPediatricsandAdolescents = hosportalService.Dermatology(search_param);
	
	return DepartmentofPediatricsandAdolescents;
	}
	
	//이비인후과 Otorhinolaryngology 정렬
	@RequestMapping(value = "/hosportal/Otorhinolaryngology", method = RequestMethod.POST)
	@ResponseBody
	public Object Otorhinolaryngology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Otorhinolaryngology = hosportalService.Dermatology(search_param);
	
	return Otorhinolaryngology;
	}
	
	//가정의학과 DepartmentofFamilyMedicine 정렬
	@RequestMapping(value = "/hosportal/DepartmentofFamilyMedicine", method = RequestMethod.POST)
	@ResponseBody
	public Object DepartmentofFamilyMedicine(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> DepartmentofFamilyMedicine = hosportalService.Dermatology(search_param);
	
	return DepartmentofFamilyMedicine;
	}
	
	//정신건강의학과 DepartmentofMentalHealthMedicine 정렬
	@RequestMapping(value = "/hosportal/DepartmentofMentalHealthMedicine", method = RequestMethod.POST)
	@ResponseBody
	public Object DepartmentofMentalHealthMedicine(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> DepartmentofMentalHealthMedicine = hosportalService.Dermatology(search_param);
	
	return DepartmentofMentalHealthMedicine;
	}
	
	//재활의학과 DepartmentofRehabilitationMedicine 정렬
	@RequestMapping(value = "/hosportal/DepartmentofRehabilitationMedicine", method = RequestMethod.POST)
	@ResponseBody
	public Object DepartmentofRehabilitationMedicine(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> DepartmentofRehabilitationMedicine = hosportalService.Dermatology(search_param);
	
	return DepartmentofRehabilitationMedicine;
	}
	
	//외과 surgery 정렬
	@RequestMapping(value = "/hosportal/surgery", method = RequestMethod.POST)
	@ResponseBody
	public Object surgery(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> surgery = hosportalService.Dermatology(search_param);
	
	return surgery;
	}
	
	//정형외과 Orthopedics 정렬
	@RequestMapping(value = "/hosportal/Orthopedics", method = RequestMethod.POST)
	@ResponseBody
	public Object Orthopedics(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Orthopedics = hosportalService.Dermatology(search_param);
	
	return Orthopedics;
	}
	
	//신경과 Neurology 정렬
	@RequestMapping(value = "/hosportal/Neurology", method = RequestMethod.POST)
	@ResponseBody
	public Object Neurology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Neurology = hosportalService.Dermatology(search_param);
	
	return Neurology;
	}
	
	//비뇨기과 urology 정렬
	@RequestMapping(value = "/hosportal/urology", method = RequestMethod.POST)
	@ResponseBody
	public Object urology(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> urology = hosportalService.Dermatology(search_param);
	
	return urology;
	}
	
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         종목별 정렬 끝                                                                        //
	//                                                         지역별 정렬 시작                                                                      //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	
	// Seoul 서울
	@RequestMapping(value = "/hosportal/Seoul", method = RequestMethod.POST)
	@ResponseBody
	public Object Seoul(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Seoul = hosportalService.Seoul(search_param);
	
	return Seoul;
	}
	
	// Incheon 인천
	@RequestMapping(value = "/hosportal/Incheon", method = RequestMethod.POST)
	@ResponseBody
	public Object Incheon(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Incheon = hosportalService.Seoul(search_param);
	
	return Incheon;
	}
	
	// Gyeonggi 경기
	@RequestMapping(value = "/hosportal/Gyeonggi", method = RequestMethod.POST)
	@ResponseBody
	public Object Gyeonggi(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Gyeonggi = hosportalService.Seoul(search_param);
	
	return Gyeonggi;
	}
	
	// Chungbuk 충북
	@RequestMapping(value = "/hosportal/Chungbuk", method = RequestMethod.POST)
	@ResponseBody
	public Object Chungbuk(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Chungbuk = hosportalService.Seoul(search_param);
	
	return Chungbuk;
	}
	
	// Chungnam 충남	
	@RequestMapping(value = "/hosportal/Chungnam", method = RequestMethod.POST)
	@ResponseBody
	public Object Chungnam(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Chungnam = hosportalService.Seoul(search_param);
	
	return Chungnam;
	}
	
	// Gangwon 강원
	@RequestMapping(value = "/hosportal/Gangwon", method = RequestMethod.POST)
	@ResponseBody
	public Object Gangwon(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Gangwon = hosportalService.Seoul(search_param);
	
	return Gangwon;
	}
	
	// Sejong 세종
	@RequestMapping(value = "/hosportal/Sejong", method = RequestMethod.POST)
	@ResponseBody
	public Object Sejong(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Sejong = hosportalService.Seoul(search_param);
	
	return Sejong;
	}
	
	// Daejeon 대전
	@RequestMapping(value = "/hosportal/Daejeon", method = RequestMethod.POST)
	@ResponseBody
	public Object Daejeon(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Daejeon = hosportalService.Seoul(search_param);
	
	return Daejeon;
	}
	
	// Gyeongbuk 경북
	@RequestMapping(value = "/hosportal/Gyeongbuk", method = RequestMethod.POST)
	@ResponseBody
	public Object Gyeongbuk(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Gyeongbuk = hosportalService.Seoul(search_param);
	
	return Gyeongbuk;
	}
	
	// Gyeongnam 경남
	@RequestMapping(value = "/hosportal/Gyeongnam", method = RequestMethod.POST)
	@ResponseBody
	public Object Gyeongnam(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Gyeongnam = hosportalService.Seoul(search_param);
	
	return Gyeongnam;
	}
	
	// Daegu 대구
	@RequestMapping(value = "/hosportal/Daegu", method = RequestMethod.POST)
	@ResponseBody
	public Object Daegu(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Daegu = hosportalService.Seoul(search_param);
	
	return Daegu;
	}
	
	// Jeollabuk 전북
	@RequestMapping(value = "/hosportal/Jeollabuk", method = RequestMethod.POST)
	@ResponseBody
	public Object Jeollabuk(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Jeollabuk = hosportalService.Seoul(search_param);
	
	return Jeollabuk;
	}
	
	// Jeollanam 전남
	@RequestMapping(value = "/hosportal/Jeollanam", method = RequestMethod.POST)
	@ResponseBody
	public Object Jeollanam(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Jeollanam = hosportalService.Seoul(search_param);
	
	return Jeollanam;
	}
	
	// Gwangju 광주
	@RequestMapping(value = "/hosportal/Gwangju", method = RequestMethod.POST)
	@ResponseBody
	public Object Gwangju(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Gwangju = hosportalService.Seoul(search_param);
	
	return Gwangju;
	}
	
	// Ulsan 울산
	@RequestMapping(value = "/hosportal/Ulsan", method = RequestMethod.POST)
	@ResponseBody
	public Object Ulsan(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Ulsan = hosportalService.Seoul(search_param);
	
	return Ulsan;
	}
	
	// Busan 부산
	@RequestMapping(value = "/hosportal/Busan", method = RequestMethod.POST)
	@ResponseBody
	public Object Busan(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Busan = hosportalService.Seoul(search_param);
	
	return Busan;
	}
	
	// Jeju 제주
	@RequestMapping(value = "/hosportal/Jeju", method = RequestMethod.POST)
	@ResponseBody
	public Object Jeju(@RequestParam("search_param") String search_param) throws Exception {
	
	List<HosportalHospitalMemberDto> Jeju = hosportalService.Seoul(search_param);
	
	return Jeju;
	}
	
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////
	//                                                         지역별 정렬 끝                                                                        //
	///////////////////////////////////////////////	///////////////////////////////////////////////	///////////////////////////////////////////////

	
	
	
	

	
}
