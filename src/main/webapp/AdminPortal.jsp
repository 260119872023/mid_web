<%--
  Created by IntelliJ IDEA.
  User: HP-
  Date: 14/03/2024
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Sidebar styling */
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            height: 100%;
            width: 250px;
            background-color: #343a40;
            padding-top: 56px;
        }
        .sidebar .nav-link {
            color: #fff;
        }
        .sidebar .nav-link:hover {
            background-color: #495057;
        }
        .sidebar .dropdown-menu {
            background-color: #343a40;
        }
        .sidebar .dropdown-item {
            color: #fff;
        }
        .sidebar .dropdown-item:hover {
            background-color: #495057;
        }
        /* Main content area styling */
        .content {
            margin-left: 250px;
            padding: 20px;
        }
    </style>
</head>
<body>
<!-- Sidebar -->
<nav class="sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" href="#">
                    Admin Dashboard
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="SemesterForm.jsp">
                    Semester
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="TeacherForm.jsp">
                   Add Teacher
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CourseForm.jsp">
                    Course
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="courseDescription.jsp">
                    Course Description
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="studentReg.jsp">
                   Add Student
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Registration.jsp">
                    Student Registration
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="academicUnit.jsp">
                    Academic Units
                </a>
            </li>
            <!-- Add more menu items as needed -->
        </ul>
    </div>
</nav>


<%--<div class="content">--%>
<%--    <h2>Admin Dashboard</h2>--%>
<%--    <p>Welcome to the admin dashboard. Here, you can manage All things happening on the web app.</p>--%>
<%--    <!-- Add more content here -->--%>
<%--</div>--%>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


