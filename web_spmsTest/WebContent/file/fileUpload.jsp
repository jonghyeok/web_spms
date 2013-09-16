<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>

<%
    String uploadPath = request.getRealPath("upload");

    int size = 10 * 1024 * 1024;
    String name         = "";
    String fileName     = "";
    String origFileName = "";
    
    try{
        MultipartRequest multi = new MultipartRequest(request,
                uploadPath,size,"euc-kr",new DefaultFileRenamePolicy());  //COS라이브러리가 제공하는 업로드 클레스이다.
               //DefaultFileRenamePolicy()메서드는 파일이름이 중복될경우 test1과 같이 파일 이름을 rename해주는 역할을 한다.
        name = multi.getParameter("name");
        
        Enumeration files = multi.getFileNames();  //전송된 파일 타입의 파라미터 이름들을 Enumeration타입으로 반환한다.

        String file = (String)files.nextElement();
        fileName = multi.getFilesystemName(file);
        origFileName = multi.getOriginalFileName(file);
        
        System.out.println("name : " + name);
        System.out.println("fileName : " + fileName);
        System.out.println("origFileName : " + origFileName);
        
    }catch(Exception e){
        e.printStackTrace();
    }
%>
<html>
<body>
<form name="uploadCheck" action="uploadCheck.jsp" method="post">
    <input type="hidden" name="name" value="<%=name %>">
    <input type="hidden" name="filename" value="<%=fileName %>">
    <input type="hidden" name="origfilename" value="<%=origFileName %>">
</form>
<a href="#" onclick="javascript:uploadCheck.submit()">업로드 체크 및 다운로드 페이지로 이동</a>
</body>
</html>