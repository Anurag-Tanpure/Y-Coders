<%@page import="com.yintern.models.Student"%>
<%@page import="com.yintern.dao.StudentDao"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard | Smart Campus</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="student.css">
</head>
<body class="bg-gray-900">
    <%
        StudentDao sd =new StudentDao();
        String id = session.getAttribute("sid").toString();
        Student s=sd.getStudentById(Integer.parseInt(id));
        
    %>
    
    <nav class="fixed top-0 left-0 right-0 bg-gray-900 border-b border-gray-800 z-50">
        <div class="flex justify-between items-center px-6 py-3">
         
            <div class="flex items-center gap-3">
                <img src="logo.png" alt="Logo" class="w-10 h-10 animate-pulse">
                <div>
                    <h1 class="text-xl font-bold text-white bg-gradient-to-r from-cyan-400 to-blue-500 bg-clip-text text-transparent">
                        Smart Campus
                    </h1>
                    <p class="text-xs text-gray-400">Student Dashboard</p>
                </div>
            </div>

           
            <div class="flex items-center space-x-6">
                <button data-section="profile" 
                        class="nav-item flex items-center gap-2 px-4 py-2 text-gray-300 rounded-lg transition-all duration-200 hover:text-cyan-400">
                    <i class="ri-dashboard-line text-xl"></i>
                    <span>Dashboard</span>
                </button>
                
                <button data-section="internship" 
                        class="nav-item flex items-center gap-2 px-4 py-2 text-gray-300 rounded-lg transition-all duration-200 hover:text-cyan-400 highlight-internship">
                    <i class="ri-file-add-line text-xl"></i>
                    <span>Insert Internship Detail</span>
                    <span class="flex h-2 w-2 relative">
                        <span class="animate-ping absolute inline-flex h-full w-full rounded-full bg-cyan-400 opacity-75"></span>
                        <span class="relative inline-flex rounded-full h-2 w-2 bg-cyan-500"></span>
                    </span>
                </button>
                
                <button data-section="report" 
                        class="nav-item flex items-center gap-2 px-4 py-2 text-gray-300 rounded-lg transition-all duration-200 hover:text-cyan-400">
                    <i class="ri-file-text-line text-xl"></i>
                    <span>Reports</span>
                </button>
                
                <button data-section="progress" 
                        class="nav-item flex items-center gap-2 px-4 py-2 text-gray-300 rounded-lg transition-all duration-200 hover:text-cyan-400">
                    <i class="ri-bar-chart-line text-xl"></i>
                    <span>Progress</span>
                </button>
                
                <button data-section="notifications" 
                        class="nav-item flex items-center gap-2 px-4 py-2 text-gray-300 rounded-lg transition-all duration-200 hover:text-cyan-400">
                    <i class="ri-notification-line text-xl"></i>
                    <span>Notifications</span>
                    <span class="px-2 py-1 text-xs font-medium bg-cyan-500 text-white rounded-full">3</span>
                </button>
            </div>

          
            <div class="flex items-center gap-4">
                <div class="flex items-center gap-3">
                    <img src="student-avatar.png" alt="Profile" 
                         class="w-10 h-10 rounded-full border-2 border-cyan-400 p-[2px]">
                    <div class="hidden md:block">
                        <h2 class="text-sm font-semibold text-white"><% out.print(s.getSname());%></h2>
                        <p class="text-xs text-gray-400"><% out.print(s.getSid());%></p>
                    </div>
                </div>
                <button class="nav-item logout p-2 text-gray-300 rounded-lg hover:text-red-400 transition-colors duration-200">
                    <i class="ri-logout-box-line text-xl"></i>
                </button>
            </div>
        </div>
    </nav>


    <main class="pt-20 px-6 min-h-screen">
<%
    String status =null;
    switch(s.getInternstatus())
    {
        case -1 : status = "Pending";break;
        case 0 : status = "In Progress";break;
        case 1 : status = "Completed";break;
    }
%>
        <div class="dashboard-section active" id="profile">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
           
                <div class="bg-gray-800/50 backdrop-blur-md rounded-xl p-6 border border-gray-700/50">
                    <h3 class="text-xl font-semibold text-white mb-4">Internship Status</h3>
                    <div class="flex items-center gap-3 bg-gray-900/50 p-4 rounded-lg">
                        <i class="ri-information-line text-cyan-400 text-xl"></i>
                        <span class="status-text text-gray-200"><% out.print(status);%></span>
                    </div>
                </div>

            
                <div class="bg-gray-800/50 backdrop-blur-md rounded-xl p-6 border border-gray-700/50">
                    <h3 class="text-xl font-semibold text-white mb-4">Internal Mentor Details</h3>
                    <div class="space-y-3 bg-gray-900/50 p-4 rounded-lg">
                        <div class="flex items-center gap-3">
                            <i class="ri-user-star-line text-cyan-400"></i>
                            <span class="text-gray-200">Dr. Sarah Johnson</span>
                        </div>
                        <div class="flex items-center gap-3">
                            <i class="ri-phone-line text-cyan-400"></i>
                            <span class="text-gray-200">+1 234 567 8900</span>
                        </div>
                        <div class="flex items-center gap-3">
                            <i class="ri-mail-line text-cyan-400"></i>
                            <span class="text-gray-200">sarah.j@campus.edu</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    
        <div class="dashboard-section" id="internship">
            <div class="mb-8">
                <h2 class="text-2xl font-bold text-white bg-gradient-to-r from-cyan-400 to-blue-500 bg-clip-text text-transparent mb-2">
                    Insert Internship Details
                </h2>
                <p class="text-gray-400">Please click the button below to add your internship information</p>
            </div>
            
          
            <div class="flex justify-center">
                <a href="form.jsp" 
                   class="px-6 py-3 bg-gradient-to-r from-cyan-500 to-blue-500 text-white rounded-lg hover:from-cyan-600 hover:to-blue-600 transition-all duration-200 flex items-center gap-2">
                    <i class="ri-file-add-line text-xl"></i>
                    Add Internship Details
                </a>
            </div>
        </div>
    </main>
</body>
</html>
