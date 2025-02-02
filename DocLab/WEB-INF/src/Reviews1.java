import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 
 
public class Reviews1 extends HttpServlet  
{ 
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
 	{ 
      	res.setContentType("text/html"); 
      	PrintWriter pw=res.getWriter(); 
        
	
     		try 
     		{
		 		Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
                    		String qry = "select * from review"; 
                    		 Statement stmt = c.createStatement(); 
            			ResultSet rs=stmt.executeQuery(qry); 
            			pw.println("<h1 style=color:green;><u><center>Doclab | Reviews <center></u></h1>");
				
            		pw.println("<table border=5 cellpadding=15 align=center style=text-align:center>"); 
                    while(rs.next()) 
            		{ 
  						  pw.println("<tr>"); 
						pw.println("<th>Name:</th>");
						pw.println("<td>"+rs.getString(1)+"</td>"); 
						pw.println("<th>Email</th>");
						pw.println("<td>"+rs.getString(2)+"</td>"); 
						pw.println("<th>Reviews</th>");
						pw.println("<td>"+rs.getString(3)+"</td>"); 
						pw.println("<th>Ratings</th>");
						pw.println("<td>"+rs.getString(4)+"</td>"); 
						pw.println("</tr>"); 

			}
                    
                  
			
                                  
            		pw.close(); 
      	} 
     		catch (Exception e) 
            { 
           		e.printStackTrace(); 
     		} 
 	} 
}