document.addEventListener('DOMContentLoaded', function() {
    // Navigation Handling
    const navLinks = document.querySelectorAll('.nav-link');
    
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            
            // Remove active class from all links
            navLinks.forEach(l => l.classList.remove('active'));
            
            // Add active class to clicked link
            this.classList.add('active');
            
            // Handle section display (to be implemented)
            const targetSection = this.getAttribute('href').substring(1);
            showSection(targetSection);
        });
    });

    // Notification Handler
    const notificationBtn = document.querySelector('.notification-btn');
    if (notificationBtn) {
        notificationBtn.addEventListener('click', function() {
            showNotification('No new notifications');
        });
    }

    // Progress Bar Animation
    const progressBars = document.querySelectorAll('.progress-fill');
    progressBars.forEach(bar => {
        const width = bar.style.width;
        bar.style.width = '0';
        setTimeout(() => {
            bar.style.width = width;
        }, 100);
    });

    // Stats Counter Animation
    const stats = document.querySelectorAll('.stat-info p');
    stats.forEach(stat => {
        const finalValue = parseInt(stat.textContent);
        animateCounter(stat, finalValue);
    });
});

// Show Notification
function showNotification(message) {
    const notification = document.createElement('div');
    notification.className = 'fixed top-4 right-4 bg-gray-800 text-white px-6 py-3 rounded-lg shadow-lg animate__animated animate__fadeInRight';
    notification.innerHTML = `
        <div class="flex items-center gap-2">
            <i class="ri-notification-2-line"></i>
            <span>${message}</span>
        </div>
    `;
    
    document.body.appendChild(notification);
    
    setTimeout(() => {
        notification.classList.remove('animate__fadeInRight');
        notification.classList.add('animate__fadeOutRight');
        setTimeout(() => notification.remove(), 1000);
    }, 3000);
}

// Animate Counter
function animateCounter(element, final) {
    let current = 0;
    const increment = final / 30;
    const timer = setInterval(() => {
        current += increment;
        if (current >= final) {
            current = final;
            clearInterval(timer);
        }
        element.textContent = Math.round(current);
    }, 50);
}

// Show Section
function showSection(sectionId) {
    // Implementation for showing different sections
    console.log(`Showing section: ${sectionId}`);
}

// Handle Responsive Menu
function toggleMenu() {
    const sidebar = document.querySelector('aside');
    sidebar.classList.toggle('show-menu');
}
