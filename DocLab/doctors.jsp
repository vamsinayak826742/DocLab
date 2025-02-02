<!DOCTYPE html> 
<html> 
<head> 
  <title>Doctor Dashboard</title> 
  <style> 
    body{ 
      background-image: url(dash.jpg); 
      text-decoration: none; 
    } 
    .container { 
      display: flex; 
      justify-content: center; 
      align-items: center; 
      height: 100vh; 
      text-decoration: none; 
    } 
     
    .card { 
      width: 300px; 
      padding: 20px; 
      text-align: center; 
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2); 
      text-decoration: none; 
    } 
     .image { 
      width: 200px; 
      height: 200px; 
      margin-bottom: 10px; 
      text-decoration: none; 
    } 
     
    .button { 
      padding: 10px 20px; 
      background-color: #4CAF50; 
      color: #ffffff; 
      text-align: center; 
      text-decoration: none; 
      font-size: 16px; 
      border-radius: 5px; 
      cursor: pointer; 
      margin-top: 10px; 
    } 
  </style> 
</head> 
<body> 
  <center> 
  <h1>DOCLAB | DOCTOR <mark><span style="text-transform:uppercase;"><%= session.getAttribute("user") %> </span> </mark>  DASHBOARD</h1> 
  </center> 
  <div class="container"> 
     
    
     
   <div class="card"> 
      <img class="image" src="https://img.freepik.com/premium-vector/doctor-profile-with-medical-service-icon_617655-48.jpg?w=2000" alt="Photo 3"> 
      <button class="button"><a href="/vamsi/ProfileD?user=<%= session.getAttribute("user") %>"><span style="text-transform:uppercase;"><%= session.getAttribute("user") %> </span> PROFILE</a></button> 
    </div> 
   <div class="card"> 
      <img class="image" src="https://static6.depositphotos.com/1005979/554/i/950/depositphotos_5541878-stock-photo-calendar-appointment-day-circled-for.jpg" alt="Photo 3"> 
      <button class="button"><a href="/vamsi/AppointDisplay?user=<%= session.getAttribute("user") %>">Appointments</a></button> 
    </div>
    <div class="card"> 
      <img class="image" src="https://helpdeskgeek.com/wp-content/pictures/2022/05/review-google.jpg" alt="Photo 4"> 
      <button class="button"><a href="/vamsi/Reviews1">Reviews</a></button> 
    </div> 
   <div class="card"> 
      <img class="image" src="https://previews.123rf.com/images/sarahdesign/sarahdesign1410/sarahdesign141000851/32210992-logout-icon.jpg" alt="Photo 4"> 
      <button class="button"><a href="index.html">LOGOUT</a></button> 
    </div> 
  </div> 
</body> 
</html> 