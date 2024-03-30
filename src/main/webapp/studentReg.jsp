<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student Information Form</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome for icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
  <style>
    .shadow-background {
      background-color: #f8f9fa;
      box-shadow: 0px 0px 10px 2px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<jsp:include page="AdminPortal.jsp"></jsp:include>
<body class="py-5">
<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6 shadow-background p-4 rounded-lg">
      <h2 class="text-center mb-4">Student Information Form</h2>
      <form method="post" action="studentReg">
        <div class="form-group">
          <label for="studentID">Student ID</label>
          <input type="text" class="form-control" name="id" id="studentID" placeholder="Enter Student ID" required>
        </div>
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" class="form-control" name="names" id="name" placeholder="Enter Name" required>
        </div>
        <div class="form-group">
          <label for="dob">Date of Birth</label>
          <input type="date" class="form-control" name="dob" id="dob" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block"><i class="fas fa-save"></i> Save</button>
      </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS and jQuery (required for Bootstrap) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
