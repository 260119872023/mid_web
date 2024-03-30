<%@ page import="java.util.List" %>
<%@ page import="Model.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 14/03/2024
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Table</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Add custom styles here if needed */
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Bootstrap Table</h2>
      <table class="table table-striped">
          <thead>
          <tr>
              <th>ID</th>
              <th>Teacher/Lecture Names </th>
              <th>Course</th>
              <th>Qualification</th>
          </tr>
          </thead>
          <tbody>
          <%
              List<Teacher> teachers = (List<Teacher>) request.getAttribute("all_teachers");
              if(teachers == null)
              {
                  request.getRequestDispatcher("/TeacherServelet").forward(request,response);
              }
              else
              {
                  for(Teacher teacher : teachers)
                  {
          %>
          <tr>
              <td><%= teacher.getTeacher_id() %></td>
              <td><%= teacher.getNames() %></td>
              <td><%= teacher.getCourses() %></td>
              <td><%= teacher.getQualifications() %></td>
              <td>
                  <a href="lectureEdit.jsp?lect_Id=<%= teacher.getTeacher_id() %>" class="btn btn-success">Edit</a>
                  <form method="post" action="allServelet"  style="display: inline">
                      <input type="hidden" name="id" value="<%= teacher.getTeacher_id() %>">
                      <button type="submit" name="action" value="delete" class="btn btn-danger">Delete</button>
                  </form>
              </td>
          </tr>
          <%
                  }
              }
          %>


          </tbody>
      </table>

</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

