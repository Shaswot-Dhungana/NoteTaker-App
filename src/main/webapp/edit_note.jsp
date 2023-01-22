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
<meta charset="UTF-8">
<%@include file="head.jsp" %>
<title>Edit Note</title>
</head>
<body>
  <div class="container-fluid p-0 m-0">
    <%@include file="navBar.jsp" %>
 
 
 <%
int noteId = Integer.parseInt(request.getParameter("note_id"));

Session s = FactoryProvider.getFactory().openSession();
Note note = (Note)s.get(Note.class, noteId);
%>
 

<br>
<h1 class="text-uppercase text-center ">Edit Your Note.</h1>

<!--   form -->
  <form action="UpdateNote" method="post">
  <input value="<%= note.getId()%>" name="noteId" type="hidden">
  <div class="mb-3">
    <label for="NoteTitle" class="form-label">Note Title</label>
    <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Update Title of Your Note." required value="<%= note.getTitle() %>">
    <div id="emailHelp" class="form-text"><!-- We'll never share your email with anyone else. --></div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Note Content</label>
    <textarea name="content"  id="content" for="content"  palceholder="Update Content"  class="form-control" required ><%= note.getContent()%></textarea>
  </div>
 
<div class="container text-center">
  <button type="submit" class="btn btn-primary">Update Note</button>
</div>

</form>
     </div>





</body>
</html>