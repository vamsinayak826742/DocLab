import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*; 
import java.io.*; 
 
public class Makeappointment extends HttpServlet   
{ 
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{ 
 		PrintWriter pw=res.getWriter(); 
  		res.setContentType("text/html");
		String did = req.getParameter("id"); 
		String Name="hi";
		
		
		try 
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");
			String sql = "select * from patregtab where id=?";
            		PreparedStatement stmt = c.prepareStatement(sql);
            		stmt.setString(1, did);
            		ResultSet rs = stmt.executeQuery(); 
			while(rs.next()) 
            		{ 
	  						   Name=rs.getString(2);
                                      
            		} 
			
            		
		} 
  		catch(Exception e)
		{ 
			e.printStackTrace(); 
		}                  
    		finally
		{
pw.println("<html>");
  pw.println("<head>");
    pw.println("<title>Doclab | Appointment Form</title>");
  pw.println("<link rel='stylesheet' type='text/css' href='./assets/css/cssstyle1.css'>");
    pw.println("</head>");
    pw.println("<body>");
      pw.println("<div class='container'>");
        pw.println("<h1>Doclab | Appointment Form</h1>");
        pw.println("<form action='AppointmentSubmit'>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='dname'>Doctor Name</label>");
            pw.println("<input type='text' id='dname' name='dname' value="+did+" required>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='name'>Full Name</label>");
            pw.println("<input type='text' id='name' name='name' placeholder='Enter your Name:' required>");
          pw.println("</div>");
	pw.println("<div class='form-group'>");
            pw.println("<label for='name'>Id:</label>");
            pw.println("<input type='text' id='name' name='patid' placeholder='Enter your id:' required>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='email'>Email</label>");
            pw.println("<input type='email' id='email' name='email' required>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='phone'>Phone Number</label>");
            pw.println("<input type='text' id='phone' name='phone' required>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='department'>Department</label>");
            pw.println("<select id='department' name='department' required>");
              pw.println("<option value=''>Select Department</option>");
              pw.println("<option value='cardiology'>Cardiology</option>");
              pw.println("<option value='orthopedics'>Orthopedics</option>");
              pw.println("<option value='neurology'>Neurology</option>");
              pw.println("<option value='Gynecologists'>Gynecologists</option>");
              pw.println("<option value='Ophthalmologists'>Ophthalmologists</option>");
              pw.println("<option value='Oncologists'>Oncologists</option>");
            pw.println("</select>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='date'>Preferred Date</label>");
            pw.println("<input type='date' id='date' name='date' required>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<label for='message'>Additional Information</label>");
            pw.println("<textarea id='message' name='message' rows='5'></textarea>");
          pw.println("</div>");
          pw.println("<div class='form-group'>");
            pw.println("<input type='submit' value='Submit'>");
          pw.println("</div>");
        pw.println("</form>");
      pw.println("</div>");
    pw.println("</body>");
  pw.println("</html>");
}
	}
}