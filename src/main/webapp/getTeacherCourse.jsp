<%@ page import="java.util.List" %>
<%@ page import="Model.Teacher" %>
<%@ page import="java.util.Objects" %>
<%@ page import="DAO.TeacherDao" %><%--
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
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Teacher/Lecture Courses Assigned</th>
            <th>Course</th>
        </tr>
        </thead>
        <tbody>
        <%
            String emaild = (String) session.getAttribute("email");
            if (emaild != null && !emaild.isEmpty()) {
                Teacher teacherObject = new Teacher();
                teacherObject.setEmail(emaild);
                TeacherDao teacherDao = new TeacherDao();
                List<Teacher> teachers = teacherDao.getTeacherscourse(teacherObject);
                if (teachers != null) {
                    for (Teacher teacherItem : teachers) {
        %>
        <tr>
            <td><%= teacherItem.getTeacher_id() %></td>
            <td><%= teacherItem.getNames() %></td>
            <td><%= teacherItem.getCourses() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3">No courses found for this teacher</td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3">Email not provided or invalid</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

<%--      <table class="table table-striped">--%>
<%--          <thead>--%>
<%--          <tr>--%>
<%--              <th>ID</th>--%>
<%--              <th>Teacher/Lecture Courses Assigned </th>--%>
<%--              <th>Course</th>--%>
<%--          </tr>--%>
<%--          </thead>--%>
<%--          <tbody>--%>
<%--          <%--%>
<%--               String emaild= request.getAttribute("email").toString();--%>
<%--               Teacher teache=new Teacher();--%>
<%--               teache.setEmail(emaild);--%>
<%--              TeacherDao teacherDao=new TeacherDao();--%>
<%--              List<Teacher> teachers = teacherDao.getTeacherscourse(teache);--%>
<%--              if(teachers == null)--%>
<%--              {--%>
<%--                  for(Teacher teacher : teachers)--%>
<%--                  {--%>
<%--          %>--%>
<%--          <tr>--%>
<%--              <td><%= teacher.getTeacher_id() %></td>--%>
<%--              <td><%= teacher.getNames() %></td>--%>
<%--              <td><%= teacher.getCourses() %></td>--%>
<%--          </tr>--%>
<%--          <%--%>
<%--                  }--%>
<%--              }--%>
<%--          %>--%>


<%--          </tbody>--%>
<%--      </table>--%>

</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

