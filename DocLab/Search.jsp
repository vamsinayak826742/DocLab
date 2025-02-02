
<!DOCTYPE html>
<html>
<head>
  <title>Doclab - Doctor Search Form</title>
  <meta name="title" content="Doclab - home">
  <meta name="description" content="This is a madical html template made by codewithsadee">
  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="./favicon.svg" type="image/svg+xml">

  <style>
    body {
      background-color: #f1f1f1;
      font-family: Arial, sans-serif;
    }
    
    h1 {
      color: green;
    }
    
    .container {
      max-width: 400px;
      margin: 0 auto;
	margin-top:150px;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
	
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    .form-group {
      margin-bottom: 20px;
	
    }
    
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    
    
    
    input[type="submit"] {
      background-color: #4CAF50;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
	
      cursor: pointer;
    }
    
    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>


  <div class="container">
    <h1>Doclab | Doctor Search Form</h1>
    <form action="DoctorSearch">
      <div class="form-group">
        <label for="name">Location</label>
        <input type="text" id="Location" name="Location" placeholder="Enter Location" required>
      </div>
 
	
	
	
        <input type="submit" value="Search"><br><br>
	   
      </div>
    </form>
  </div>
</body>
</html>
