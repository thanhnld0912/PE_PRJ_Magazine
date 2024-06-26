<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Magazine</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1>Add new magazine!</h1>
            <%
                Integer hitsCount = (Integer)application.getAttribute("hitCounter");
                if (hitsCount == null || hitsCount == 0) {
                    out.print("Welcome to the website");
                    hitsCount = 1;
                } else {
                    out.print("Welcome back");
                    hitsCount += 1;
                }
                application.setAttribute("hitCounter", hitsCount);
                out.println("Total number of visits: " + hitsCount);
            %>  
            <form action="NewMagazineController" method="post">
                <div class="form-group">
                    <label for="id">Magazine ID:</label>
                    <input type="text" class="form-control" id="id" name="id">
                </div>
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="form-group">
                    <label for="publisher">Publisher:</label>
                    <input type="text" class="form-control" id="publisher" name="publisher">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" name="price">
                </div>
                <button type="submit" class="btn btn-primary">Add Magazine</button>
            </form>
            <%
                String errorMessage = (String) session.getAttribute("errorMessage");
                if (errorMessage != null) {
                    out.println("<div class='alert alert-danger'>" + errorMessage + "</div>");
                    session.removeAttribute("errorMessage");
                }

                Integer errorCounter = (Integer) session.getAttribute("errorCounter");
                if (errorCounter != null) {
                    out.println("<div>Total errors: " + errorCounter + "</div>");
                }
            %>
        </div>
    </body>
</html>
