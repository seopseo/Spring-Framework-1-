package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.board.command.BoardInsert;
import co.micol.prj.board.command.BoardInsertForm;
import co.micol.prj.board.command.BoardSelect;
import co.micol.prj.board.command.BoardSelectList;
import co.micol.prj.comm.Command;
import co.micol.prj.home.command.HomeCommand;
import co.micol.prj.member.command.MemberSelect;
import co.micol.prj.member.command.MemberSelectList;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();   
   
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// 요청한 command를 저장하는 곳
		map.put("/home.do", new HomeCommand());  //처음으로 들어오면 메인페이지 보여주기
		map.put("/memberSelectList.do", new MemberSelectList());  //회원전체 조회
		map.put("/memberSelect.do", new MemberSelect());  //한명을 조회하는것
		map.put("/boardSelectList.do", new BoardSelectList()); //게시글 목록
		map.put("/boardSelect.do", new BoardSelect()); //게시글 상세조회
		map.put("/boardInsertForm.do", new BoardInsertForm()); //글 작성 폼
		map.put("/boardInsert.do", new BoardInsert());  //글 저장하기
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청을 분석하고 서비스를 수행 후 결과를 돌려준다.
		request.setCharacterEncoding("utf-8");  //한글 깨짐 방지
		String uri = request.getRequestURI();   //요청명령을 찾기 위한 uri 확인
		String contextPath = request.getContextPath();  //context path 확인
		String page = uri.substring(contextPath.length());  //실제 요청한 페이지를 찾음
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);  //처리후 돌려줄 페이지
		//간단한 view Resolve 만든다. jsp 파일을 서버에서 접근해서 브라우저로 돌려주기 위함
		
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/jsp/" + viewPage + ".jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
