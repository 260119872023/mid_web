<%@ page import="Model.Course" %>
<%@ page import="DAO.courseDao" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.TeacherDao" %>
<%@ page import="Model.Teacher" %>
<%@ page import="Model.Qualification" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 12/03/2024
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #ffffff; /* White background */
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); /* Box shadow */
        }
        .container {
            padding: 40px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="AdminPortal.jsp"></jsp:include>
<div class="container mt-5">

  <div class="row justify-content-center">
      <div class="col-md-6">
          <h2>Teacher Form</h2>
          <form method="post" action="TeacherServelet">
              <div class="form-group">
                  <label for="teacherName">Teacher Name:</label>
                  <input type="text" name="name" class="form-control" id="teacherName" placeholder="Enter teacher name">
              </div>
              <div class="form-group">
                  <label for="teacherName">Teacher Email:</label>
                  <input type="text" name="email" class="form-control" id="teacheremail" placeholder="Enter teacher Email">
              </div>

              <div class="form-group">
                  <label for="courseSelect">Course:</label>
                  <select class="form-control" name="course" id="courseSelect">
                      <option value=""></option>
                      <%
                          courseDao dao = new courseDao();
                          List<Course> cour = dao.allcourses();
                          for(Course course : cour)
                          {
                      %>
                      <option value="<%= course.getCourse_id()%>"><%= course.getName()%></option>
                      <% } %>
                  </select>
              </div>
              <div class="form-group">
                  <label for="qualificationSelect">Qualification:</label>
                  <select class="form-control" name="qualification" id="qualificationSelect">
                      <option value=""></option>
                      <%
                          Class<Qualification> qualificationClass = Qualification.class;
                          Qualification[] qualifications = qualificationClass.getEnumConstants();
                          for(Qualification qualification : qualifications)
                          {
                      %>
                      <option value="<%= qualification.toString()%>"><%= qualification.toString()%></option>
                      <% } %>

                  </select>
              </div>
              <button type="submit" class="btn btn-primary">Save</button>
          </form>
      </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

