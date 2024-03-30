<%@ page import="DAO.AcademicDao" %>
<%@ page import="Model.AcademicUnit" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.CourseEnum" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 12/03/2024
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bootstrap Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome for icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
  <style>
    .custom-form {
      background-color: #ffffff;
      box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.1);
      padding: 20px;
      border-radius: 10px;
    }
  </style>
</head>
<jsp:include page="AdminPortal.jsp"></jsp:include>
<body class="py-5">
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="custom-form">
        <h2 class="text-center mb-4">Academic Unit</h2>
        <form method="post" action="academicServelet">
          <div class="form-group">
            <label for="code">Code</label>
            <input type="text" class="form-control" name="code" id="code" placeholder="Enter Code" required>
          </div>
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name" required>
          </div>
          <div class="form-group">
            <label for="select1">Parent</label>
            <select class="form-control" name="parent" id="select1">
              <option value=""></option>
              <%
                AcademicDao dao = new AcademicDao();
                List<AcademicUnit> list = dao.getfacultyandprograms();
                for (AcademicUnit tp : list) {
              %>
              <option value="<%= tp.getId() %>"><%=tp.getName()%>><%= tp.getProgram_type()%></option>
              <% } %>
            </select>
          </div>
          <div class="form-group">
            <label for="select2">Type</label>
            <select class="form-control" name="type" id="select2">
              <%
                Class<CourseEnum> enumAcademicClass = CourseEnum.class;
                CourseEnum[] enumValues = enumAcademicClass.getEnumConstants();
                for (CourseEnum enumValue : enumValues) {
              %>
              <option value="<%= enumValue.toString() %>"><%= enumValue.toString() %></option>
              <% } %>
            </select>
          </div>
          <button type="submit" class="btn btn-primary btn-block"><i class="fas fa-save"></i> Save</button>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS and jQuery (required for Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>

