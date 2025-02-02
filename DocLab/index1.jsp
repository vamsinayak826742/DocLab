<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- 
    - primary meta tags
  -->
  <title>Doclab - home</title>
  <meta name="title" content="Doclab - home">
  <meta name="description" content="This is a madical html template made by codewithsadee">

  <!-- 
    - favicon
  -->
  <link rel="shortcut icon" href="./favicon.svg" type="image/svg+xml">

  <!-- 
    - google font link
  -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@500;700&family=Rubik:wght@400;500;700&display=swap"
    rel="stylesheet">

  <!-- 
    - custom css link
  -->
  <link rel="stylesheet" href="./assets/css/style.css">

  <!-- 
    - preload images
  -->
  <link rel="preload" as="image" href="./assets/images/hero-banner.png">
  <link rel="preload" as="image" href="./assets/images/hero-bg.png">
<style>
      p {
  margin-top: 20px;
  margin-right: 20px;
  
  margin-left: 20px;
  
  color: white;
  font-size: 18px;
}
h1 {
  color: red;
  font-size: 24px;
  font-weight: bold;
  margin-right: 20px;
  margin-left: 20px;
}
h2 {
  color: red;
  font-size: 20px;
  font-weight: bold;
  margin-right: 20px;
  margin-left: 20px;
}

    </style>
 
</head>

<body id="top">

  <!-- 
    - #PRELOADER
  -->

  <div class="preloader" data-preloader>
    <div class="circle"></div>
  </div>





  <!-- 
    - #HEADER
  -->

  <header class="header" data-header>
    <div class="container">

      <a href="index1.html" class="logo">
        <img src="./assets/images/logo.svg" width="136" height="46" alt="Doclab home">
      </a>

      <nav class="navbar" data-navbar>

        <div class="navbar-top">

          <a href="index1.html" class="logo">
            <img src="./assets/images/logo.svg" width="136" height="46" alt="Doclab home">
          </a>

          <button class="nav-close-btn" aria-label="clsoe menu" data-nav-toggler>
            <ion-icon name="close-outline" aria-hidden="true"></ion-icon>
          </button>

        </div>

        <ul class="navbar-list">

          <li class="navbar-item">
            <a href="index1.jsp" class="navbar-link title-md">Home</a>
          </li>

          <li class="navbar-item">
		
            <a href="Search.jsp" class="navbar-link title-md">Doctors</a>
          </li>

          <li class="navbar-item">
            <a href="about.html" class="navbar-link title-md">About</a>
          </li>

	  


          <li class="navbar-item">
            <a href="Review.html" class="navbar-link title-md">Review</a>
          </li>
	
	
	
	<li class="navbar-item">
            <a href="index.html" class="navbar-link title-md">Logout</a>
          </li>

        </ul>

        
          
      </nav>
 
	

      <button class="nav-open-btn" aria-label="open menu" data-nav-toggler>
        <ion-icon name="menu-outline"></ion-icon>
      </button>

      <a href="/vamsi/ProfileP?user=<%= session.getAttribute("user") %>" class="btn has-before title-md">Welcome <%= session.getAttribute("user") %></a>

      <div class="overlay" data-nav-toggler data-overlay></div>

    </div>
  </header>





  <main>
    <article>

      <!-- 
        - #HERO
      -->

      <section class="section hero" style="background-image: url('./assets/images/hero-bg.png')" aria-label="home">
        <div class="container">

          <div class="hero-content">

            <p class="hero-subtitle has-before" data-reveal="left">Welcome <mark><%= session.getAttribute("user") %> </mark>To Doclab</p>

            <h1 class="headline-lg hero-title" data-reveal="left">
              Find Nearest <br>
              Doctor.
            </h1>

            <div class="hero-card" data-reveal="left">

              <p class="title-lg card-text">
                Search doctors
              </p>
		<form action="DoctorSearch?sessionName=<%= session.getAttribute("user") %>">
              <div class="wrapper">
		  
                <div class="input-wrapper title-lg">
		    
                  <input type="text" id="Location" name="Location" required placeholder="Locations" class="input-field">

                  <ion-icon name="location"></ion-icon>
                </div>

                <button class="btn has-before">
                  <ion-icon name="search"></ion-icon>

                  <input class="span title-md" type="submit" value="Search">
                </button>

              </div>
			

            </div>
	</form>
          </div>

          <figure class="hero-banner" data-reveal="right">
            <img src="./assets/images/hero-banner.png" width="590" height="517" loading="eager" alt="hero banner"
              class="w-100">
          </figure>

        </div>
      </section>




      





  





  <!-- 
    - custom js link
  -->
  <script src="./assets/js/script.js"></script>

  

</body>

</html>