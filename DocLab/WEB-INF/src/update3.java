import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 
public class update3 extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
           PrintWriter pw=res.getWriter(); 
  		res.setContentType("text/html");                     
          String id = req.getParameter("id");                
        String un = req.getParameter("name"); 
		String mail = req.getParameter("Email"); 
		String mobile = req.getParameter("mobile"); 
		String ps = req.getParameter("password"); 

       try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");
            String sql = "UPDATE patregtab SET  username = ?,email = ?,mobile =?,password= ? WHERE id = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            
            stmt.setString(1, un);
		  stmt.setString(2, mail);
		  stmt.setString(3, mobile);
            stmt.setString(4, ps);
		  stmt.setString(5, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                pw.println("<script type=\"text/javascript\">");
            		pw.println("alert('update successful!');");
            		pw.println("window.location.href='Admin.html';"); // Redirect to login page
            		pw.println("</script>");
            } else {
                res.sendError(HttpServletResponse.SC_NOT_FOUND, "Person not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        }
    }
}
