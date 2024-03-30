<%@ page import="Model.AcademicUnit" %>
<%@ page import="DAO.AcademicDao" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.semesterDao" %>
<%@ page import="Model.Semester" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 15/03/2024
  Time: 15:58
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
      background-color: #f8f9fa; /* Light grey background */
      padding: 20px;
    }
    .form-container {
      background-color: #fff; /* White background */
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Box shadow for a card-like effect */
    }
    .form-group input[type="text"],
    .form-group input[type="date"],
    .form-group select {
      border: 1px solid #ced4da; /* Grey border */
      border-radius: 5px; /* Rounded corners */
      padding: 8px; /* Padding around the input fields */
    }
    .form-group label {
      font-weight: bold; /* Make labels bold */
    }
    .btn-primary {
      background-color: #007bff; /* Blue primary button color */
      border-color: #007bff; /* Blue primary button border color */
    }
    .btn-primary:hover {
      background-color: #0056b3; /* Darker blue on hover */
      border-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="container mt-5">
    <h2 class="mb-4">Lecture's Courses</h2>
    <br><br>
    <div class="container mt-5">
      <button type="button" class="btn btn-primary" onclick="goBack()">
        <i class="fas fa-arrow-left"></i> Back
      </button>
    </div>

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>

    <script>
      function goBack() {
        window.history.back();
      }
    </script>

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
            <input type="text" name="student" class="form-control" id="courseCredit" placeholder="Enter Student ID" required>
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