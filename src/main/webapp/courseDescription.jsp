<%@ page import="DAO.courseDao" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Course" %><%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 12/03/2024
  Time: 20:44
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
</head>
<body>

<jsp:include page="AdminPortal.jsp"></jsp:include>

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <h2>Course Form</h2>
      <form method="post" action="CoursedesServe">
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
          <label for="descriptionTextarea">Description:</label>
          <textarea class="form-control" name="description" id="descriptionTextarea" rows="5"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

