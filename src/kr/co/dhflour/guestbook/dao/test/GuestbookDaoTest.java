package kr.co.dhflour.guestbook.dao.test;

import java.util.List;

import kr.co.dhflour.guestbook.dao.GuestbookDao;
import kr.co.dhflour.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		//insertTest();
		
		deleteTest();
		fetcListTest();
	}

	public static void fetcListTest() {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.fetchList();
		for( GuestbookVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void deleteTest() {
		GuestbookDao dao = new GuestbookDao();
		
		//Mock 객체
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(5);
		vo.setPassword( "1234" );
		
		dao.delete(vo);
	}
	
	public static void insertTest() {
		GuestbookDao dao = new GuestbookDao();
		
		//Mock Data
		GuestbookVo vo = new GuestbookVo();
		vo.setName( "도우넛" );
		vo.setPassword( "1234" );
		vo.setContents( "테스트입니다." );
		
		dao.insert(vo);
	}
}
