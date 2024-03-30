<%@ page import="DAO.courseDao" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Course" %>
<%@ page import="DAO.AcademicDao" %>
<%@ page import="Model.AcademicUnit" %>
<%@ page import="Model.Semester" %>
<%@ page import="DAO.semesterDao" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 12/03/2024
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Course Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #353535; /* Different background color */
      color: #fff;
    }
    .container {
      padding: 50px;
    }
  </style>
</head>
<body>
<jsp:include page="AdminPortal.jsp"></jsp:include>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <h2 class="mb-4">Course Form Registration</h2>
      <form method="post" action="courseServ">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="courseCode">Course Code:</label>
            <input type="text" name="code" class="form-control" id="courseCode" placeholder="Enter Course Code" required>
          </div>
          <div class="form-group col-md-6">
            <label for="courseName">Course Name:</label>
            <input type="text" name="name" class="form-control" id="courseName" placeholder="Enter Course Name" required>
          </div>
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="select1">Department:</label>
            <select class="form-control" name="department" id="select1" required>
              <option value=""></option>
              <%
                AcademicDao dao = new AcademicDao();
                List<AcademicUnit> list = dao.getdepartment();
                for (AcademicUnit tp : list) {
              %>
              <option value="<%= tp.getId()%>"><%=tp.getName() %>-<%= tp.getProgram_type()%></option>.
              <% } %>
            </select>
          </div>
          <div class="form-group col-md-6">
            <label for="select2">Semester:</label>
            <select class="form-control" name="semester" id="select2" required>
              <option value=""></option>
              <%
                semesterDao dao1 = new semesterDao();
                List<Semester> sem = dao1.allsemesters();

                for (Semester sems : sem) {
              %>
              <option value="<%= sems.getSem_Id()%>"><%= sems.getName()%></option>
              <% } %>
            </select>
          </div>
          <div class="form-group col-md-12">
            <label for="courseCode">Course Credit:</label>
            <input type="text" name="credit" class="form-control" id="courseCredit" placeholder="Enter Course Credits" required>
          </div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

