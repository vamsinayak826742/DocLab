import java.io.*; 
import java.sql.*; 
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.servlet.http.HttpSession; 
public class Signin extends HttpServlet   
{ 
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException 
	{ 
		PrintWriter out=res.getWriter(); 
		res.setContentType("text/html");
		 
		String uname=req.getParameter("id"); 
	        String pass=req.getParameter("pwd"); 
		HttpSession session = req.getSession();
		int flag=0;  
		try 
		{ 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/vamsi","root","Vamsi@727232");                  
    			Statement st=c.createStatement();
			String un="1",un1="1",un2,pwd,pwd1,pwd2,user,user1,id,hi="user",hii="doctor1";
			un2="Admin";
			pwd2="Admin";
			if(un2.equals(uname) && pwd2.equals(pass))
			{
				flag=5;
			}
			if(flag==0) 
			{ 
	    			ResultSet rs=st.executeQuery("Select * from patregtab"); 
				while(rs.next()) 
				{ 
					un = rs.getString(1);
					hi=rs.getString(2); 
				     	pwd= rs.getString(5);
					if(un.equals(uname) && pwd.equals(pass)) 
					{ 
						flag=1;
						break; 
	                   		} 	
				}
			}
			if(flag==0) 
			{  
                      		ResultSet rset=st.executeQuery("Select * from doctor"); 
				while(rset.next()) 
			       	{ 
					un1 = rset.getString(1); 
					hii=rset.getString(2);
			     		pwd1= rset.getString(9); 
                    			if(un1.equals(uname) && pwd1.equals(pass)) 
                    			{ 
					     	flag=2;	
	      					break; 
        		            	} 
				  } 
			}
			if(flag==1)
			{				  
				  out.println("<script type=\"text/javascript\">");
				  session.setAttribute("user",hi);
            		  	  out.println("alert('Patient login successful!');");
            		 	  out.println("window.location.href='index1.jsp';");	
            		  	  out.println("</script>"); 
			}
			if(flag==2)
			{
				out.println("<script type=\"text/javascript\">");
				session.setAttribute("user",hii);
            		  	out.println("alert('Doctor login successful!');");
            		 	out.println("window.location.href='doctors.jsp';");
				out.println("</script>");   
			}
			if(flag==5)
			{  
				  out.println("<script type=\"text/javascript\">");
            		  	  out.println("alert('Admin login successful!');");
            		  	  out.println("window.location.href='Admin.html';");
            		  	  out.println("</script>"); 
			}
   			if(flag==0) 
   			{  
		     	  
				  out.println("<script type=\"text/javascript\">");
	            		  out.println("alert('login Invalid');");
	            		  out.println("window.location.href='login.html';"); // Redirect to login page
	            		  out.println("</script>"); 
			} 
		     out.close(); 
  		} 
  		catch(Exception e)
		{ 
			e.printStackTrace(); 
		} 
	} 
}