package Controllers;

import Model.Magazine;
import Model.MagazinesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HELLO
 */
public class NewMagazineController extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String publisher = request.getParameter("publisher");
            String p = request.getParameter("price");

            String validationMessage = Validation(id, title, publisher, p);
            if (validationMessage.isEmpty()) {
                Magazine m = new Magazine(id, title, publisher, Double.parseDouble(p));
                try {
                    MagazinesDAO dao = new MagazinesDAO();
                    if (dao.newMagazine(m)) {
                        // Redirect to the home page after successful insertion
                        response.sendRedirect("index.jsp");
                    } else {
                        out.print("Insertion failed");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.print("ERROR: " + e.getMessage());
                }
            } else {
                // Set error message in session and redirect back to the form
                request.getSession().setAttribute("errorMessage", validationMessage);
                // Increment the error counter
                Integer errorCounter = (Integer) request.getSession().getAttribute("errorCounter");
                if (errorCounter == null) {
                    errorCounter = 1;
                } else {
                    errorCounter++;
                }
                request.getSession().setAttribute("errorCounter", errorCounter);
                response.sendRedirect("Magazine.jsp");
            }
        }
    }

    public String Validation(String id, String title, String publisher, String price) {
        if (!id.matches("^M\\d{3}$")) return "ID must follow M + 3 digits";
        MagazinesDAO dao = new MagazinesDAO();
        ArrayList<Magazine> list = dao.getAll(id);
        if (!list.isEmpty()) return "This ID already exists";
        if (title.isEmpty()) return "Please input title";
        if (publisher.isEmpty()) return "Please input publisher";
        try {
            Double.parseDouble(price);
        } catch (Exception e) {
            return "Price must be a number";
        }
        return "";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
