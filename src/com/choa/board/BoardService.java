package com.choa.board;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public void boardInsert(BoardDTO dto) throws Exception {
		int result = boardDAO.boardInsert(dto);
		System.out.println(result + " :1 이상이면 성공");
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception {
		ArrayList<BoardDTO> arr = boardDAO.boardList();
		return arr;
	}
}
