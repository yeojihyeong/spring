package co.micol.grj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.grj.comm.Command;
import co.micol.grj.home.command.HomeCommand;
import co.micol.grj.member.command.AjaxIdCheck;
import co.micol.grj.member.command.MemberJoinForm;
import co.micol.grj.member.command.MemberList;
import co.micol.grj.member.command.MemberSelect;
import co.micol.grj.member.command.memberJoin;



@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() { 
        super();
        map.put("/home.do", new HomeCommand()); //home.do가 요청되면 HomeCommand의 초기값을 리턴
		map.put("/memberList.do", new MemberList()); //회원목록보기
		map.put("/memberSelect.do", new MemberSelect()); //회원상세조회
		map.put("/ajaxIdCheck.do", new AjaxIdCheck()); //아이디 중복체크
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입
		map.put("/memberJoin.do", new memberJoin());
    }


	public void init(ServletConfig config) throws ServletException { //최초 1번만 실행
		// 수행할 Command들의 집합
	}


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 요쳥된 명령을 분석하고, 실행하고, 결과를 돌려주는 역활을 한다.
		request.setCharacterEncoding("utf-8"); //한글깨짐방지
		String uri = request.getRequestURI(); //URI를 얻어옴.
		String contextPath = request.getContextPath(); //ContextPath를 구함
		String page=uri.substring(contextPath.length()); //실제 요청한 명령을 출력
		
		Command command = map.get(page); //Command command = new HomeCommand(); ==> home.do일 경우
		String viewPage = command.run(request, response); //command객체를 실행 후 리턴값을 받음
		
		//View Resolve를 만든다.
		if(!viewPage.equals(null) && !viewPage.endsWith(".do")) { //endsWith -> 끝나는부분
			
			if(viewPage.startsWith("ajax")) { //ajax를 사용하는 뷰리졸브
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.append(viewPage.substring(5));
				return;
			} //비동기 호출.
			
			viewPage = "WEB-INF/views/"+ viewPage + ".jsp"; 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //이전의 요청한 값을 가지고 가기위해서는 디스패처 사용
		dispatcher.forward(request, response);
		
	}

}
