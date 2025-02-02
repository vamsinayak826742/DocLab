import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 
 
public class DoctorSearch extends HttpServlet   
{ 
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException 
 	{ 
      	res.setContentType("text/html"); 
      	PrintWriter pw=res.getWriter(); 
        String Location=req.getParameter("Location"); 
	
	
     		try 
     		{
		 		Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
                    		String qry = "select * from doctor where Location=?"; 
                    		PreparedStatement pst=c.prepareStatement(qry);
				pst.setString(1,Location);
				ResultSet rs=pst.executeQuery();
				if (!rs.isBeforeFirst()) 
				{
    					pw.println("<h1>"+Location+" Doctors list is empty.<h1>"); 
				}
				else
				{
				pw.println("<h1 style=color:green;><u><center>Doclab |"+Location+" Doctors List<center></u></h1>");
				
           
            		pw.println("<table border=5 cellpadding=15 align=center style=text-align:center>"); 
                    pw.println("<tr>"); 
                    pw.println("<th>Id</th>"); 
                    pw.println("<th>Name</th>"); 
            		pw.println("<th>Qualification</th>"); 
                    pw.println("<th>Email</th>"); 
                    pw.println("<th>Mobile</th>"); 
                    pw.println("<th>specialty</th>"); 
				pw.println("<th>Experience</th>"); 
				pw.println("<th>Location</th>");
				
				pw.println("<th>Make Appointment</th>"); 
				
				
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
				      pw.println("<td><a href='Makeappointment?id="+rs.getString(2)+"'>Make Appointment</a></td>");
						  	  
						
                                      pw.println("</tr>"); 
            		} }
            		pw.println ("</table>"); 
            		pw.close(); 
      	} 
     		catch (Exception e) 
            { 
           		e.printStackTrace(); 
     		} 
 	} 
}