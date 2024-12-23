<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Internship Details Form | Smart Campus</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="form.css">
</head>
<body class="bg-gray-900 min-h-screen">
    <% 
    String id = session.getAttribute("sid").toString();
    %>
    <div class="container mx-auto px-4 py-8">
    
        <div class="text-center mb-8 animate__animated animate__fadeInDown">
            <h1 class="text-3xl font-bold bg-gradient-to-r from-cyan-400 to-blue-500 bg-clip-text text-transparent">
                Internship Details Form
            </h1>
            <p class="text-gray-400 mt-2">Please fill in your internship information</p>
        </div>

       
        <div class="max-w-4xl mx-auto bg-gray-800/50 backdrop-blur-md rounded-xl p-8 border border-gray-700/50 shadow-2xl animate__animated animate__fadeInUp">
            <form id="internshipForm" action="InternInsert" method="post" class="space-y-6">
                <!-- Company Details Section -->
                <div class="p-6 bg-gray-900/50 rounded-xl mb-6">
                    <h3 class="text-xl font-semibold text-cyan-400 mb-4 flex items-center gap-2">
                        <i class="ri-building-line"></i>
                        Company Information
                    </h3>
                    <input type="text" value="<%= id %>"  name ="id" hidden="true"> 
                    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Company Name</label>
                            <input type="text" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                   name = "cname" placeholder="Enter company name">
                        </div>
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Company's Registration Number</label>
                            <input type="text" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                name="cnumber"   placeholder="Enter registration number">
                        </div>
                        <div class="form-group md:col-span-2">
                            <label class="text-gray-300 text-sm mb-2 block">Company Address</label>
                            <textarea class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                    rows="2" 
                                name="caddress"    placeholder="Enter complete address"></textarea>
                        </div>
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">City</label>
                            <input type="text" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                name="city"   placeholder="Enter city">
                        </div>
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Stipend Amount</label>
                            <input type="number" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                 name="stipendAmount"  placeholder="Enter amount">
                        </div>
                    </div>
                </div>

               
                <div class="p-6 bg-gray-900/50 rounded-xl mb-6">
                    <h3 class="text-xl font-semibold text-cyan-400 mb-4 flex items-center gap-2">
                        <i class="ri-user-star-line"></i>
                        External Mentor Details
                    </h3>
                    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Mentor Name</label>
                            <input type="text" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                               name="mentorName"    placeholder="Enter mentor's name">
                        </div>
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Contact Number</label>
                            <input type="tel" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                               name="mentorContactNumber"    placeholder="Enter contact number">
                        </div>
                        <div class="form-group md:col-span-2">
                            <label class="text-gray-300 text-sm mb-2 block">Email Address</label>
                            <input type="email" 
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200"
                                 name="mentorEmail"  placeholder="Enter email address">
                        </div>
                    </div>
                </div>

        
                <div class="p-6 bg-gray-900/50 rounded-xl mb-6">
                    <h3 class="text-xl font-semibold text-cyan-400 mb-4 flex items-center gap-2">
                        <i class="ri-calendar-line"></i>
                        Internship Details
                    </h3>
                    <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Start Date</label>
                            <input type="date" 
                                  name="startDate" class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-white focus:border-cyan-400 focus:outline-none transition-colors duration-200">
                        </div>
                        <div class="form-group">
                            <label class="text-gray-300 text-sm mb-2 block">Offer Letter</label>
                            <div class="relative">
                                <input type="file" 
                                       name="offerLetterFname"
                                       class="hidden" 
                                       id="offerLetter" 
                                       accept=".pdf,.doc,.docx">
                                <label for="offerLetter" 
                                       class="flex items-center gap-2 cursor-pointer w-full bg-gray-900/50 border border-gray-700 rounded-lg px-4 py-2.5 text-gray-400 hover:border-cyan-400 transition-colors duration-200">
                                    <i class="ri-upload-2-line"></i>
                                    <span id="fileName" >Choose file</span>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>

               
                <div class="flex justify-end gap-4">
                    <button type="button" 
                            onclick="window.history.back()" 
                            class="px-6 py-2.5 border border-gray-600 text-gray-300 rounded-lg hover:bg-gray-800 transition-all duration-200">
                        Cancel
                    </button>
                    <button type="submit" 
                            class="px-6 py-2.5 bg-gradient-to-r from-cyan-500 to-blue-500 text-white rounded-lg hover:from-cyan-600 hover:to-blue-600 transition-all duration-200 flex items-center gap-2">
                        <i class="ri-save-line"></i>
                        Submit Details
                    </button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
