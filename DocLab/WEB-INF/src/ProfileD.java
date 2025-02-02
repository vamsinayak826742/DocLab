import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 
 
public class ProfileD extends HttpServlet  
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
                    		String qry = "select * from doctor where name=?"; 
                    		 PreparedStatement pst=c.prepareStatement(qry);
				pst.setString(1,user);
				ResultSet rs=pst.executeQuery();
            			rs.next();
                    pw.println("<h3>Id:"+rs.getString(1)+"</h3>"); 
                    pw.println("<h3>Name:"+rs.getString(2)+"</h3>");
		    pw.println("<h3>Qualification:"+rs.getString(3)+"</h3>");   
                    pw.println("<h3>Email:"+rs.getString(4)+"</h3>");   
                    pw.println("<h3>Mobile:"+rs.getString(5)+"</h3>");
                    pw.println("<h3>specialty:"+rs.getString(6)+"</h3>");  
		    pw.println("<h3>experience:"+rs.getString(7)+"</h3>");   
                    pw.println("<h3>Location:"+rs.getString(8)+"</h3>");
			pw.println("<h3>password:"+rs.getString(9)+"</h3>");
			
                                  
            		pw.close(); 
      	} 
     		catch (Exception e) 
            { 
           		e.printStackTrace(); 
     		} 
 	} 
}