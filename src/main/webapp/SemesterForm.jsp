<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Semester Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #000;
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
    <div class="col-md-6">
      <h2 class="mb-4 text-center">Semester Form</h2>
      <form method="post" action="semesterServ">
        <div class="form-group">
          <label for="semesterName">Semester Name:</label>
          <input type="text" name="name" class="form-control form-control-sm" id="semesterName" placeholder="Enter Semester Name" required>
        </div>
        <div class="form-group">
          <label for="startDate">Start Date:</label>
          <input type="date" name="start_date" class="form-control form-control-sm" id="startDate" required>
        </div>
        <div class="form-group">
          <label for="endDate">End Date:</label>
          <input type="date" name="end_date" class="form-control form-control-sm" id="endDate" required>
        </div>
        <button type="submit" class="btn btn-primary btn-sm btn-block">Submit</button>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
