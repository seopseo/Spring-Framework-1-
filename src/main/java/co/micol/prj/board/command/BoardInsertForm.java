package co.micol.prj.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;

public class BoardInsertForm implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 글 쓰기폼 호출
		return "board/boardInsertForm";
	}

}
