<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>Add Notes</title>
</head>
<body>

 <div class="container-fluid p-0 m-0">
    <%@include file="navBar.jsp" %>
    
    <br>
    <h1>Add Your Notes</h1>
    <br>
        
  <!--   form -->
  <form action="SaveNote" method="post">
  <div class="mb-3">
    <label for="NoteTitle" class="form-label">Note Title</label>
    <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Title of Your Note." required>
    <div id="emailHelp" class="form-text"><!-- We'll never share your email with anyone else. --></div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Note Content</label>
    <textarea name="content"  id="content" for="content"  palceholder="Enter Content"  class="form-control" required> </textarea>
  </div>
 
<div class="container text-center">
  <button type="submit" class="btn btn-primary">Add Note</button>
</div>

</form>
  
  
  </div>
    
    
</body>

</html>