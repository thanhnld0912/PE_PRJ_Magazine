<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Magazine"%>
<%@page import="Model.MagazinesDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Magazine List</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>MAGAZINE!</h1>
            <%
                Integer hitsCount = (Integer)application.getAttribute("hitCounter");
                if (hitsCount == null || hitsCount == 0) {
                    out.print("Welcome to the website");
                    hitsCount = 1;
                } else {
                    out.print("Welcome back to the website");
                    hitsCount += 1;
                }
                application.setAttribute("hitCounter", hitsCount);
                out.println("Total number of visits: " + hitsCount);
            %>    
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Publisher</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        try {
                            MagazinesDAO ls = new MagazinesDAO();
                            ArrayList<Magazine> list = ls.getAll("");

                            if (list == null || list.isEmpty()) {
                                out.print("<tr><td colspan='4'>No magazines available</td></tr>");
                            } else {
                                for (Magazine m : list) {
                                    out.print("<tr>"
                                        + "<td>" + m.getID() + "</td>"
                                        + "<td>" + m.getTitle() + "</td>"
                                        + "<td>" + m.getPublisher() + "</td>"
                                        + "<td>" + m.getPrice() + "</td>"
                                        + "</tr>");
                                }
                            }
                        } catch (Exception e) {
                            out.print("<tr><td colspan='4'>Error: " + e.getMessage() + "</td></tr>");
                            e.printStackTrace(new java.io.PrintWriter(out));
                        }
                    %> 
                </tbody>
            </table>
            <form action="Magazine.jsp">
                <input type="submit" value="Add new Magazine" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
