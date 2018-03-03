package kr.co.dhflour.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.dhflour.guestbook.vo.GuestbookVo;

public class GuestbookDao {
	
	public List<GuestbookVo> fetchList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		Connection conn = null;
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		
			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		
		} catch( ClassNotFoundException e ) {
			System.out.println( "드라이버 로딩 실패 :" + e );
		} catch( SQLException e ) {
			System.out.println( "에러:" + e);
		}
		
		return list;
	}
}
