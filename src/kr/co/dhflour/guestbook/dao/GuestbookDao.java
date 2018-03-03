package kr.co.dhflour.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.dhflour.guestbook.vo.GuestbookVo;

public class GuestbookDao {
	
	public List<GuestbookVo> fetchList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//1. JDBC 드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		
			//2. Connection 가져오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			stmt = conn.createStatement();
			
			String sql = 
				"   select no," + 
				"          name," + 
				"          to_char(reg_date, 'yyyy-mm-dd hh:mi:ss')," + 
				"          contents" + 
				"     from guestbook" + 
				" order by reg_date desc";
			
			rs = stmt.executeQuery( sql );
			while( rs.next() ) {
				long no = rs.getLong(1);
				String name = rs.getString( 2 );
				String regDate = rs.getString( 3 );
				String contents = rs.getString( 4 );

				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setRegDate(regDate);
				vo.setContents(contents);
				
				list.add( vo );
			}
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "드라이버 로딩 실패 :" + e );
		} catch( SQLException e ) {
			System.out.println( "에러:" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( stmt != null ) {
					stmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException e ) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
