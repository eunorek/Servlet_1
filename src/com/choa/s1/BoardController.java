package com.choa.s1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getRequestURI();
		System.out.println(path);
		path = path.substring(path.lastIndexOf("/"));
		String info = "";
		
		if(path.equals("/boardList.board")) {
			ArrayList<BoardDTO> arr = null;
			try {
				arr = boardService.boardList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("contentList", arr);
			info = "./boardList.jsp";
		}else if(path.equals("/boardWrite.board")) {
			info = "./boardWrite.jsp";
		}else if(path.equals("/boardWriteSubmit.board")) {
			BoardDTO dto = new BoardDTO();
			dto.setTitle(request.getParameter("title"));
			dto.setWriter(request.getParameter("writer"));
			dto.setContents(request.getParameter("contents"));
			
			try {
				boardService.boardInsert(dto);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			request.getRequestDispatcher(path)
//			info = "./boardList.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(info);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
