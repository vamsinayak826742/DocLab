import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*; 
import java.io.*; 
 
public class PatientServlet1 extends HttpServlet   
{ 
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{ 
 		PrintWriter pw=res.getWriter(); 
  		res.setContentType("text/html");
		String id = req.getParameter("id");                 
        String un = req.getParameter("name"); 
		String mail = req.getParameter("Email"); 
		String mobile = req.getParameter("mobile"); 
        String ps = req.getParameter("password"); 
            
            
        try 
  		{ 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
				String qry = "insert into Patregtab values(?,?,?,?,?)"; 
  				PreparedStatement pst=c.prepareStatement(qry); 
				pst.setString(1,id);
  				pst.setString(2,un); 
				pst.setString(3,mail);
				pst.setString(4,mobile); 
                pst.setString(5,ps); 
                        
                         
                int i = pst.executeUpdate(); 
                if(i!=0)
				{
					pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Registration successful!');");
            		pw.println("window.location.href='login.html';"); // Redirect to login page
            		pw.println("</script>");
				}
				else
				{
				 	pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Registration not successful!');");
            		pw.println("window.location.href='PatientRegister.html';"); // Redirect to login page
            		pw.println("</script>");
				}
				 
            	pw.close();
  		} 
  		catch (Exception e)
		{ 
   			e.printStackTrace(); 
  		} 
 	} 
} 