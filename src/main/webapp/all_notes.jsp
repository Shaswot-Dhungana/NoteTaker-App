
    <%@page import = "org.hibernate.Session" %>
    <%@page import = "org.hibernate.query.Query" %>
    <%@page import = "com.ShaswotDhungana.FactoryProvider.FactoryProvider" %>
     <%@page import = " java.util.List" %>
     <%@page import = "com.ShaswotDhungana.Note.*" %>
     
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>All Notes</title>
</head>
<body>

 <div class="container-fluid p-0 m-0">
    <%@include file="navBar.jsp" %>
   
   <br>
   
   <h1 class="text-uppercase text-center "> All Notes </h1>
   
   
   
   <div class="row">
   
   <div class="col-12">
   
     <%
   
   Session s = FactoryProvider.getFactory().openSession();
   
   
   Query q = s.createQuery("from Note");
   List<Note> list = q.list();
   
   for(Note note:list){
	 
	   %>
	   
	   <div class="card mt-4 " style="width: 18rem;">
	   <img src="img/notes.png" class="card-img-top p-3" style="max-width: 100px;" alt="Note Icon">
  <div class="card-body">
    <h5 class="card-title"> <%= note.getTitle() %> </h5>
    <p class="card-text"> <%= note.getContent() %>  </p>
    <a href="#" class="btn btn-danger">Delete</a>
  </div>
</div>


	   
	
   
   <%
   }
   
   
   
   s.close();
   
   %>
   
   
   <!--  out.println("<h1>"+note.getId() + note.getTitle() + note.getContent()+"</h1><br>"); -->
   
   
   </div>
   </div>
   
   
   
   
   
 
   
   
    </div>
    
    
</body>

</html>