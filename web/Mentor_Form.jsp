<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mentor Details | Smart Campus</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <link rel="stylesheet" href="mentor_form.css">
</head>
<body class="bg-gray-900 min-h-screen flex items-center justify-center">
    <div class="container mx-auto px-4 py-8">
        <!-- Form Card -->
        <div class="max-w-md mx-auto">
            <!-- Logo and Title -->
            <div class="text-center mb-8 animate__animated animate__fadeInDown">
                <div class="inline-block p-4 rounded-full bg-gradient-to-r from-teal-500/20 to-green-500/20 mb-4">
                    <i class="ri-user-settings-line text-4xl text-teal-400"></i>
                </div>
                <h1 class="text-3xl font-bold bg-gradient-to-r from-teal-400 to-green-500 bg-clip-text text-transparent">
                    Mentor Details
                </h1>
                <p class="text-gray-400 mt-2">Enter mentor information to proceed</p>
            </div>

            <!-- Form -->
            <div class="bg-gray-800/50 backdrop-blur-md rounded-xl p-8 border border-gray-700/50 shadow-2xl animate__animated animate__fadeInUp">
                <form id="mentorForm" action="MentorAdd" method="post" class="space-y-6">
                    <!-- Mentor ID -->
                    <div class="form-group">
                        <label class="text-gray-300 text-sm mb-2 block">Mentor ID</label>
                        <div class="relative">
                            <i class="ri-user-line absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                            <input type="text" name="mentor_id"
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg pl-10 pr-4 py-2.5 text-white focus:border-teal-400 focus:outline-none transition-colors duration-200"
                                   placeholder="Enter unique mentor ID">
                        </div>
                    </div>

                    <!-- Mentor Name -->
                    <div class="form-group">
                        <label class="text-gray-300 text-sm mb-2 block">Full Name</label>
                        <div class="relative">
                            <i class="ri-user-line absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                            <input type="text" name="name"
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg pl-10 pr-4 py-2.5 text-white focus:border-teal-400 focus:outline-none transition-colors duration-200"
                                   placeholder="Enter full name">
                        </div>
                    </div>

                    <!-- Mentor Email -->
                    <div class="form-group">
                        <label class="text-gray-300 text-sm mb-2 block">Email Address</label>
                        <div class="relative">
                            <i class="ri-mail-line absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                            <input type="email" name="email"
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg pl-10 pr-4 py-2.5 text-white focus:border-teal-400 focus:outline-none transition-colors duration-200"
                                   placeholder="Enter email address">
                        </div>
                    </div>

                  

                    <!-- Password -->
                    <div class="form-group">
                        <label class="text-gray-300 text-sm mb-2 block">Password</label>
                        <div class="relative">
                            <i class="ri-lock-line absolute left-3 top-1/2 -translate-y-1/2 text-gray-400"></i>
                            <input type="password" name="password"
                                   class="form-input w-full bg-gray-900/50 border border-gray-700 rounded-lg pl-10 pr-4 py-2.5 text-white focus:border-teal-400 focus:outline-none transition-colors duration-200"
                                   placeholder="Create a password">
                            <button type="button" 
                                    class="absolute right-3 top-1/2 -translate-y-1/2 text-gray-400 hover:text-teal-400"
                                    onclick="togglePassword(this)">
                                <i class="ri-eye-line"></i>
                            </button>
                        </div>
                    </div>

                  

                    <!-- Submit Button -->
                    <button type="submit" 
                            class="w-full py-3 bg-gradient-to-r from-teal-500 to-green-500 text-white rounded-lg hover:from-teal-600 hover:to-green-600 transition-all duration-200 flex items-center justify-center gap-2 group">
                        <span>Submit Details</span>
                        <i class="ri-arrow-right-line transition-transform duration-200 group-hover:translate-x-1"></i>
                    </button>
                </form>
            </div>

            <!-- Additional Info -->
            <div class="text-center mt-6 text-gray-400 animate__animated animate__fadeInUp animate__delay-1s">
                <p>Looking for a different form? <a href="#" class="text-teal-400 hover:underline">Go back</a></p>
            </div>
        </div>
    </div>

    <script src="mentor_form.js"></script>
</body>
</html>
