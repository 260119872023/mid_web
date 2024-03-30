<%@ page import="Model.Course" %>
<%@ page import="DAO.courseDao" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Qualification" %>
<%@ page import="DAO.TeacherDao" %>
<%@ page import="Model.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 15/03/2024
  Time: 00:21
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
            background-color: #f8f9fa;
        }
        .container {
            padding: 50px;
            border: 1px solid #dee2e6; /* Border color */
            border-radius: 10px; /* Border radius */
            background-color: #fff; /* Background color */
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mb-4">Teacher Information</h2>
    <%
        TeacherDao dao = new TeacherDao();
        int id = Integer.parseInt(request.getParameter("lect_Id"));

        Teacher teachers = new Teacher();
        teachers.setTeacher_id(id);
        Teacher lecture = dao.search_lecture(teachers);
    %>
    <% if (lecture != null) { %>
    <form method="post" action="editTeacherSer">
        <input type="hidden" name="put_method" value="PUT">
        <input type="hidden" name="lectid" value="<%= lecture.getTeacher_id() %>">

        <div class="form-group">
            <label for="teacherName">Teacher Name:</label>
            <input type="text" name="teacher" class="form-control" id="teacherName" value="<%= lecture.getNames() %>">
        </div>
        <div class="form-group">
            <label for="qualification">Qualification:</label>
            <select name="qual_edit" class="form-control" id="qualification">
                    <% for (Qualification qualifications : Qualification.values()) {%>
                    <option value="<%= qualifications.toString() %>" <%= lecture.getQualifications() == qualifications ? "Selected" : ""%>><%= qualifications.toString() %></option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="course">Course:</label>
            <select name="course_ed" class="form-control" id="course">

                <%
                    courseDao dao1 = new courseDao();
                    List<Course> cour = dao1.allcourses();
                    for(Course course : cour)
                    {%>
                <% Course course1 = lecture.getCourses(); %>
                <option value="<%= course.getCourse_id()%>" <%= course1 != null && course1.getCourse_id() == course.getCourse_id()? "chosen" : "" %>><%= course.getName() %></option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
    <% } else { %>
    <div class="alert alert-danger" role="alert">
        Teacher with ID <%= id %> not found.
    </div>
    <% } %>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

