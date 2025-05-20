import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*;
import java.util.*;
public class Test extends HttpServlet { 
    protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
            throws ServletException, IOException { 
        String firstname = request.getParameter("firstname"); 
        String lastname = request.getParameter("lastname"); 
        String dob = request.getParameter("dob");  
        String age = request.getParameter("age"); 
        String city = request.getParameter("city"); 
        String email = request.getParameter("email"); 
        String username = request.getParameter("username"); 
        String password = request.getParameter("password"); 
        String key = "";
        // Generate key: first two letters of firstname + dob 
        if (firstname.length() >= 2) { 
            key = firstname.substring(0, 2) + dob; 
        } else { 
            key = firstname+ dob; 
        } 
        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 
        out.println("<h2>Registration Successful!</h2>"); 
        out.println("<p>Name: " + firstname + " " + lastname + "</p>"); 
        out.println("<p>Username: " + username + "</p>"); 
        out.println("<p>Key: " + key + "</p>"); 
        out.println("<p>DOB: " + dob + "</p>"); 
        out.println("<p>Age: " + age + "</p>"); 
        out.println("<p>City: " + city + "</p>"); 
        out.println("<p>Email: " + email + "</p>"); 
    } 
} 