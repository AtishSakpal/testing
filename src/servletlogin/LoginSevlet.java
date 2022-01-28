package servletlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

@WebServlet("/LoginPageDirected")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
				try 
				{
						
					String eName = request.getParameter("nid");
					
					String  ePassword = request.getParameter("pid");
					
					
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					
					Connection connet = DriverManager.getConnection("jdbc:mysql://localhost:1204/chupsadb","Atish", "Aasavari	" );
					
					Statement st = connet.createStatement();
					
					ResultSet rs = st.executeQuery("select * from login where name = '"+eName+"' and password = '"+ePassword+"'   ");
					
					if(rs.next())
					{
						  System.out.println( rs.next() +"Passed checked by Raja");
					}
					else
					{
						System.out.println(rs.next() +"Failed");
					}
					
					
					connet.close();
					
				}
				catch (Exception e)
				{
						e.printStackTrace();
				}
	}

}
