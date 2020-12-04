package com.choa.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

import com.choa.util.DBConnector;

public class BoardDAO {
	private DBConnector dbConnector;
	public BoardDAO() {
		dbConnector = new DBConnector();
	}
	
	public int boardInsert(BoardDTO dto) throws Exception {
		Connection con = dbConnector.getConnect();
		String sql = "INSERT INTO board VALUES((SELECT MAX(num) FROM board)+1, "
				+ "?, ?, ?, SYSDATE, 0)";		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getTitle());
		st.setString(2, dto.getWriter());
		st.setString(3, dto.getContents());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return result;
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception{
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM board ORDER BY num";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		while(rs.next()) {
			BoardDTO b = new BoardDTO();
			b.setNum(rs.getInt("num"));
			b.setTitle(rs.getString("title"));
			b.setWriter(rs.getString("writer"));
			b.setContents(rs.getString("contents"));
			b.setRegDate(rs.getDate("regDate"));
			b.setHit(rs.getInt("hit"));
			
			arr.add(b);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return arr;
	}

}
