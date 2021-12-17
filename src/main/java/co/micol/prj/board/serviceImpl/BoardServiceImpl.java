package co.micol.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.service.BoardVO;
import co.micol.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardService map = sqlSession.getMapper(BoardService.class);
	
	@Override
	public List<BoardVO> boardSelectList() {
		// 전체 게시글 가져오기
		return map.boardSelectList();
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// 하나의 글 상세조회
		return map.boardSelect(vo);
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// 글 입력
		return map.boardInsert(vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// 글 수정
		return map.boardUpdate(vo);
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// 글 삭제
		return map.boardDelete(vo);
	}

}
