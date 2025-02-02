import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*; 
import java.io.*; 
 
public class AppointmentSubmit extends HttpServlet   
{ 
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{ 
 		PrintWriter pw=res.getWriter(); 
  		res.setContentType("text/html");
		String pid = req.getParameter("patid");                 
        	String dname = req.getParameter("dname"); 
		String fname = req.getParameter("name"); 
		String mail = req.getParameter("email"); 
		String mobile = req.getParameter("phone");
		String dept = req.getParameter("department"); 
		String date = req.getParameter("date"); 
		String message = req.getParameter("message");
        	try 
  		{ 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
				String qry = "insert into appoint values(?,?,?,?,?,?,?,?)"; 
  				PreparedStatement pst=c.prepareStatement(qry); 
				pst.setString(1,pid);
  				pst.setString(2,dname); 
				pst.setString(3,fname);
				pst.setString(4,mail);
				pst.setString(5,mobile);
  				pst.setString(6,dept); 
				pst.setString(7,date);
				pst.setString(8,message); 
                
                        
                         
                int i = pst.executeUpdate(); 
                if(i!=0)
				{
					pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Appointment done!');");
            		pw.println("window.location.href='index1.jsp';"); // Redirect to login page
            		pw.println("</script>");
				}
				else
				{
				 	pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Appointment not successful!');");
            		pw.println("window.location.href='index1.jsp';"); // Redirect to login page
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