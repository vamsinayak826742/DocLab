import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 
 
public class AppointDisplay extends HttpServlet   
{ 
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
 	{ 
      	res.setContentType("text/html"); 
      	PrintWriter pw=res.getWriter(); 
        String user = req.getParameter("user");
     		try 
     		{
		 		Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
                    		String qry = "select * from appoint where dname=?"; 
                    		PreparedStatement pst=c.prepareStatement(qry);
				pst.setString(1,user);
				ResultSet rs=pst.executeQuery();
				pw.println("<h1 style=color:green;><u><center>Doclab | Appointments List<center></u></h1>");
				
            		pw.println("<table border=5 cellpadding=15 align=center style=text-align:center>"); 
                    pw.println("<tr>"); 
                    pw.println("<th>Patient Id:</th>"); 
                    pw.println("<th>Doctor Name</th>"); 
            	    pw.println("<th>Patient Full Name</th>"); 
                    pw.println("<th>Email</th>"); 
                    pw.println("<th>Mobile</th>"); 
                    pw.println("<th>Department</th>"); 
		    pw.println("<th>Date</th>"); 
		    pw.println("<th>Problem/Information</th>");
		    pw.println("<th>Patient Profile</th>"); 
		   	 
				
                    pw.println("</tr>"); 
            		while(rs.next()) 
            		{ 
  						  pw.println("<tr>"); 
                                      pw.println("<td>"+rs.getString(1)+"</td>"); 
                                      pw.println("<td>"+rs.getString(2)+"</td>"); 
                                      pw.println("<td>"+rs.getString(3)+"</td>"); 
                                      pw.println("<td>"+rs.getString(4)+"</td>"); 
				      pw.println("<td>"+rs.getString(5)+"</td>"); 
                                      pw.println("<td>"+rs.getString(6)+"</td>"); 
                                      pw.println("<td>"+rs.getString(7)+"</td>"); 
                                      pw.println("<td>"+rs.getString(8)+"</td>"); 
                                      pw.println("<td><a href='ProfileP?user="+rs.getString(3)+"'>Patient Profile</a></td>");
						  	    
						
                                      pw.println("</tr>"); 
            		} 
            		pw.println ("</table>");
			
            		pw.close(); 
      	} 
     		catch (Exception e) 
            { 
           		e.printStackTrace(); 
     		} 
 	} 
}