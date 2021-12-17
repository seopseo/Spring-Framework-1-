package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {
	String returnPage;
	
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberService = new MemberServiceImpl();
		MemberVO memberVO = new MemberVO();
		memberVO.setId(request.getParameter("id"));
		
		
		memberVO = memberService.memberSelect(memberVO);
		if(memberVO != null) {
			request.setAttribute("member", memberVO);
			returnPage = "member/memberSelect";
		} else {
			request.setAttribute("message", "회원 세부 정보 불러오기가 실패했다.");
			returnPage = "member/memberFail";
		}
		
		return returnPage;
	}

}
