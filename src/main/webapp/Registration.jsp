<%@ page import="Model.AcademicUnit" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.AcademicDao" %>
<%@ page import="Model.Semester" %>
<%@ page import="DAO.semesterDao" %>
<%@ page import="DAO.StudentDao" %>
<%@ page import="Model.Student" %>
<%@ page import="Model.StudentReg" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 13/03/2024
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #423423;
      padding: 20px;
    }
    .form-container {
      background-color: #fff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }
  </style>
</head>
<body>
<jsp:include page="AdminPortal.jsp"></jsp:include>
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="form-container">
        <h2 class="mb-4 text-center">Form</h2>
        <form method="post" action="RegistrationServelet">
          <div class="form-group">
            <label for="semesterSelect">Select Semester</label>
            <select class="form-control" id="semesterSelect" name="semester">
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
          <div class="form-group">
            <label for="academicSelect">Select Academic</label>
            <select class="form-control" id="academicSelect" name="academic">
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
          <div class="form-group">
            <label>Student Id</label>
            <input type="text" name="student" class="form-control" id="courseCredit" placeholder="Enter Course Credits" required>
          </div>

          <div class="form-group">
            <label for="dateInput">Date</label>
            <input type="date" class="form-control" id="dateInput" name="date">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</div>
</body>
</html>

