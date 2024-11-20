<%@page import="com.yintern.dao.MentorDao"%>
<%@page import="com.yintern.dao.StudentDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Campus Login</title>

    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<body class="bg-black">
    <% 
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String status = request.getParameter("status");
        String errorMsg = null; // To hold error message

        // Log parameters for debugging (only for development, not for production)
        System.out.println("Status: " + status);
        System.out.println("ID: " + id);
        System.out.println("Password: " + pass);

        // Handle different user statuses using if-else
        if (status != null && id != null && pass != null) {
            if (status.equals("student")) {
                session.setAttribute("sid", id);
                StudentDao sd = new StudentDao();
                if (sd.checkLogin(Integer.parseInt(id), pass)) {
                    response.sendRedirect("student.jsp");
                } else {
                    errorMsg = "Invalid Student ID or Password!";
                }
            } else if (status.equals("mentor")) {
                // Redirect or handle mentor logic
                
                session.setAttribute("mid", id);
                MentorDao md= new MentorDao();
                 if(md.checkLogin(Integer.parseInt(id), pass))
                 {
                     response.sendRedirect("mentor_db.jsp");
                
                 }else
                {
                  errorMsg = "Invalid Mentor ID or Password!";
                }
            } else if (status.equals("admin")) {
                
                // Validate admin credentials
                if (id.equals("1212") && pass.equals("59#test")) {
                    response.sendRedirect("admin.html");
                } else {
                    errorMsg = "Invalid Admin ID or Password!";
                }
            } else {
                out.println("<script>alert('Invalid status selected! Please try again.');</script>");
            }
        }
    %>
    <div class="container-fluid login-container">
        <div class="row min-h-screen">
            <div class="col-md-6 mx-auto">
                <div class="login-box animate__animated animate__fadeIn">
                    <img src="logo.png" alt="Logo" class="logo animate__animated animate__pulse animate__infinite">
                    <h1 class="text-4xl font-bold text-white mb-8 text-center">Smart Campus Login</h1>
                    
                    <form class="space-y-6" action="index.jsp" method="get">
                        <div class="form-group">
                            <select class="form-control glass-effect" id="status" name="status" required>
                                <option value="" disabled selected style="color:black">Select Status</option>
                                <option value="student" style="color:black">Student</option>
                                <option value="mentor" style="color:black">Mentor</option>
                                <option value="admin" style="color:black">Admin</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control glass-effect" name="id" placeholder="Enter ID" required>
                        </div>

                        <div class="form-group">
                            <input type="password" class="form-control glass-effect" name="pass" placeholder="Enter Password" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-full hover-effect">
                            Login
                        </button>
                    </form>
                    
                    <%-- Display error message if credentials are invalid --%>
                    <% if (errorMsg != null) { %>
                        <div class="mt-4 text-center">
                            <span class="text-danger"><%= errorMsg %></span>
                        </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

    <!-- Include the external JavaScript file here -->
    <script src="login.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
