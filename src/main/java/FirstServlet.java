import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        Integer counter = 1;

        Object counterAttribute = session.getAttribute("COUNTER");

        if (counterAttribute == null) {
            session.setAttribute("COUNTER" , counter);
        }else {
            counter = (Integer) counterAttribute;
            session.setAttribute("COUNTER", ++counter);
        }

        resp.getWriter()
                .println("Hello from first servlet for:" + counter + " times");
//        resp.sendRedirect("https://www.google.pl");
//        req.getRequestDispatcher("/second").forward(req, resp);
    }
            }
