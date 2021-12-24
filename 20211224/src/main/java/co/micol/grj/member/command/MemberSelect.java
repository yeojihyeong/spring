package co.micol.grj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.grj.comm.Command;
import co.micol.grj.member.service.MemberService;
import co.micol.grj.member.service.MemberVO;
import co.micol.grj.member.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		
		vo=memberService.memberSelect(vo);
		
		if(vo != null) {
			request.setAttribute("member", vo);
		}
		return "member/memberSelect";
	}

}
