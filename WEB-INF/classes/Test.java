import java.io.IOException; 
import java.io.PrintWriter; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.*;

@WebServlet("/Test") // optional annotation to map servlet
public class Test extends HttpServlet { 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        HttpSession session = request.getSession(); 
        String username = request.getParameter("username"); 
        Integer count = (Integer) session.getAttribute("count"); 

        if (count == null) { 
            count = 1; 
        } else { 
            count++; 
        } 

        session.setAttribute("count", count); 
        session.setAttribute("username", username); 

        response.setContentType("text/html"); 
        PrintWriter out = response.getWriter(); 

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Login Info</title></head>");
        out.println("<body style='font-family: Arial, sans-serif; background-color: #f2f2f2; text-align: center; padding-top: 50px;'>");

        out.println("<div style='background-color: white; border-radius: 10px; width: 400px; margin: auto; padding: 20px; box-shadow: 0px 0px 10px #ccc;'>");
        out.println("<h2 style='color: #333;'>Hello, <span style='color: #0066cc;'>" + username + "</span>!</h2>");
        out.println("<p style='font-size: 18px;'>You have logged in <strong>" + count + "</strong> times.</p>");
        out.println("</div>");

        out.println("</body></html>");
    } 
}
