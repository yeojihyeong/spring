package co.micol.grj.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command { //컨트롤러에서 명령을 처리할 인터페이스
	public String run(HttpServletRequest request, HttpServletResponse response);
	
}
