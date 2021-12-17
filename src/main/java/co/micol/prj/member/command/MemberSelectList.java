package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class MemberSelectList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 회원 전체 목록
		MemberService memberDao = new MemberServiceImpl();
//		List<MemberVO> members = memberDao.memberSelectList();  //전체회원목록을 가져온다
		request.setAttribute("members", memberDao.memberSelectList());		
		
		return "member/memberSelectList";
	}

}
