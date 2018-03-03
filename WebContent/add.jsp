<%@page import="kr.co.dhflour.guestbook.vo.GuestbookVo"%>
<%@page import="kr.co.dhflour.guestbook.dao.GuestbookDao"%>
<%
	request.setCharacterEncoding( "utf-8" );

	String name = request.getParameter( "name" );
	String password = request.getParameter( "password" );
	String contents = request.getParameter( "contents" );
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setContents(contents);
	
	GuestbookDao dao = new GuestbookDao();
	dao.insert(vo);
	
	response.sendRedirect( "/guestbook" );
%>