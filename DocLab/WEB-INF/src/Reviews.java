import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*; 
import java.io.*; 
 
public class Reviews extends HttpServlet   
{ 
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
	{ 
 		PrintWriter pw=res.getWriter(); 
  		res.setContentType("text/html");
		                
        	String un = req.getParameter("name"); 
		String mail = req.getParameter("email"); 
		String rev = req.getParameter("review"); 
        	String rat= req.getParameter("Rating"); 
            
            
        try 
  		{ 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
				String qry = "insert into review values(?,?,?,?)"; 
  				PreparedStatement pst=c.prepareStatement(qry); 
				pst.setString(1,un);
  				pst.setString(2,mail); 
				pst.setString(3,rev);
				pst.setString(4,rat); 
                
                        
                         
                int i = pst.executeUpdate(); 
                if(i!=0)
				{
					pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Review Taken successfully');");
            		pw.println("window.location.href='index1.jsp';"); // Redirect to login page
            		pw.println("</script>");
				}
				else
				{
				 	pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('Review Not Taken successfully!');");
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