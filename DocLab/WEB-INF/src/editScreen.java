import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.sql.*; 

public class editScreen extends HttpServlet {
   

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                   
                    
            String sql = "SELECT * FROM doctor WHERE id = ?";
            PreparedStatement stmt = c.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve the person's details from the database
                String Name = rs.getString(2);
                String Qualification = rs.getString(3);
                String Email = rs.getString(4);
			 String Mobile = rs.getString(5);
			String specialty = rs.getString(6);
                String Experience = rs.getString(7);
                String Location = rs.getString(8);
			 String password = rs.getString(9);

                // Display the edit form with the person's details
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><head><title>Edit Doctor Details</title>");
			 out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\'./assets/css/cssstyle1.css'>");
			 out.println("</head><body>");
			out.println("<div class='container'>");
                out.println("<h1 style=color:green;><u><center>Doclab |Edit Doctor Details<center></u></h1>");
                out.println("<form action=\"update2\" method=\"post\">");
			 out.println("<div class='form-group'>");
                out.println("<label>id:</label><input type=\"text\" name=\"id\" value=\"" + id + "\"><br></div>");
			 out.println("<div class='form-group'>");
 			 out.println("<label>Name:</label> <input type=\"text\" name=\"name\" value=\"" + rs.getString(2)+ "\"><br></div>");
			 out.println("<div class='form-group'>");
 			 out.println("<label>Qualification:</label> <input type=\"text\" name=\"Qualification\" value=\"" + rs.getString(3)+ "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<label>Email:</label> <input type=\"text\" name=\"Email\" value=\"" + rs.getString(4)+ "\"><br></div>");
			 out.println("<div class='form-group'>");
 			 out.println("<label>Mobile:</label> <input type=\"text\" name=\"mobile\" value=\"" + rs.getString(5)+ "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<label>specialty:</label> <input type=\"text\" name=\"specialty\" value=\"" + rs.getString(6) + "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<label>Experience:</label> <input type=\"text\" name=\"experience\" value=\"" + rs.getString(7) + "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<label>Location: </label><input type=\"text\" name=\"Location\" value=\"" + rs.getString(8) + "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<label>password : </label><input type=\"text\" name=\"password\" value=\"" + rs.getString(9)+ "\"><br></div>");
			 out.println("<div class='form-group'>");
                out.println("<input type=\"submit\" value=\"Update\">");
                out.println("</form>");
			 out.println("</div>");
                out.println("</body></html>");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Person not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error");
        }
    }
}
