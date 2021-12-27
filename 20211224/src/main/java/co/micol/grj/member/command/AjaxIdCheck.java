package co.micol.grj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.grj.comm.Command;
import co.micol.grj.member.service.MemberService;
import co.micol.grj.member.serviceImpl.MemberServiceImpl;

public class AjaxIdCheck implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// Ajax로 아이디 중복체크 하는 것
		
		MemberService memberService = new MemberServiceImpl();
		String id = request.getParameter("id");
		boolean b = memberService.isIdCheck(id); //0이면 존재하는 값(가입불가), 1이면 존재하지 않는 값(가입가능)
		
		String str = null;
		
		if(!b) {
			//"이미 존재하는 아이디 입니다."
			str = "0";
		}else {
			//"사용가능한아이디"
			str = "1";
		}
		
		return "ajax:"+str;
	}

}
