package co.micol.grj.home.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.grj.comm.Command;

public class HomeCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 단순히 홈(첫번째 페이지를 돌려주는 곳)
		return "home/home";
	}

}
