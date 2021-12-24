package co.micol.grj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.grj.comm.Command;
import co.micol.grj.member.service.MemberService;
import co.micol.grj.member.serviceImpl.MemberServiceImpl;

public class MemberList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberService /* memberDao */ = new MemberServiceImpl(); //memberDao 도 사용가능
		request.setAttribute("members", memberService.memberSelectList());
		return "member/memberList";
	}

}
