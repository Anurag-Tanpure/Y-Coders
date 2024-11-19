document.addEventListener('DOMContentLoaded', function() {
    const navItems = document.querySelectorAll('.nav-item');
    const sections = document.querySelectorAll('.dashboard-section');

    
    const currentSection = localStorage.getItem('currentSection') || 'profile';
    setActiveSection(currentSection);

    navItems.forEach(item => {
        item.addEventListener('click', function() {
            const targetSection = this.dataset.section;
            
            if (this.classList.contains('logout')) {
                handleLogout();
                return;
            }

            setActiveSection(targetSection);
            localStorage.setItem('currentSection', targetSection);
        });
    });

    function setActiveSection(sectionId) {

        navItems.forEach(nav => nav.classList.remove('active'));
        sections.forEach(section => section.classList.remove('active'));


        const currentNav = document.querySelector(`[data-section="${sectionId}"]`);
        const currentSection = document.getElementById(sectionId);

        if (currentNav && currentSection) {
            currentNav.classList.add('active');
            currentSection.classList.add('active');
            
      
            currentSection.style.animation = 'fadeIn 0.5s ease forwards';
        }
    }


    const progressCircle = document.querySelector('.progress-circle');
    if (progressCircle) {
        const progress = progressCircle.dataset.progress;
        progressCircle.style.setProperty('--progress', progress);
    }

  
    updateStatus('In Progress');

    const fileInput = document.querySelector('input[type="file"]');
    if (fileInput) {
        fileInput.addEventListener('change', function(e) {
            const fileName = e.target.files[0]?.name;
            const uploadText = this.parentElement.querySelector('p');
            if (fileName && uploadText) {
                uploadText.textContent = fileName;
            }
        });
    }
});

function showReportModal(type) {
    const modal = document.getElementById('modal');
    const modalTitle = document.getElementById('modal-title');
    const modalBody = document.getElementById('modal-body');
    
    modal.style.display = 'block';
    
    switch(type) {
        case 'weekly':
            modalTitle.textContent = 'Submit Weekly Report';
            modalBody.innerHTML = `
                <form class="modal-form">
                    <div class="form-group">
                        <label>Week Number</label>
                        <input type="number" min="1" max="12" required>
                    </div>
                    <div class="form-group">
                        <label>Tasks Completed</label>
                        <textarea required rows="4"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Challenges Faced</label>
                        <textarea required rows="4"></textarea>
                    </div>
                    <div class="form-group">
                        <label>Upload Report Document</label>
                        <input type="file" required>
                    </div>
                    <button type="submit" class="submit-btn">Submit Report</button>
                </form>
            `;
            break;
        case 'monthly':
            
            break;
        case 'final':
   
            break;
    }
}

function hideModal() {
    const modal = document.getElementById('modal');
    modal.style.display = 'none';
}

function handleLogout() {
    window.location.href = 'index.html';
}


document.addEventListener('submit', function(e) {
    if (e.target.classList.contains('modal-form')) {
        e.preventDefault();
  
        hideModal();
        showNotification('Report submitted successfully!');
    }
});

function showNotification(message) {
    const notification = document.createElement('div');
    notification.className = 'notification animate__animated animate__fadeInRight';
    notification.innerHTML = `
        <i class="ri-checkbox-circle-line"></i>
        <span>${message}</span>
    `;
    document.body.appendChild(notification);
    
    setTimeout(() => {
        notification.classList.remove('animate__fadeInRight');
        notification.classList.add('animate__fadeOutRight');
        setTimeout(() => notification.remove(), 1000);
    }, 3000);
}


document.addEventListener('DOMContentLoaded', function() {
    const circles = document.querySelectorAll('.progress-circle');
    circles.forEach(circle => {
        const progress = circle.getAttribute('data-progress');
        const circumference = 2 * Math.PI * 65;
        const offset = circumference - (progress / 100) * circumference;
        const progressCircle = circle.querySelector('circle:last-child');
        progressCircle.style.strokeDasharray = `${circumference} ${circumference}`;
        progressCircle.style.strokeDashoffset = offset;
    });
});


function switchSection(sectionId) {
    const sections = document.querySelectorAll('.dashboard-section');
    sections.forEach(section => {
        if (section.id === sectionId) {
            section.style.animation = 'fadeIn 0.5s forwards';
            section.classList.add('active');
        } else {
            section.style.animation = 'fadeOut 0.3s forwards';
            section.classList.remove('active');
        }
    });
}


function showLoading() {
    const loader = document.createElement('div');
    loader.className = 'loading-spinner';
    document.body.appendChild(loader);
    setTimeout(() => loader.remove(), 1000);
}


function updateStatus(status) {
    const statusText = document.querySelector('.status-text');
    if (statusText) {
        statusText.textContent = status;
        
        const icon = statusText.previousElementSibling;
        switch(status.toLowerCase()) {
            case 'pending':
                icon.style.color = '#f1c40f'; 
                break;
            case 'in progress':
                icon.style.color = '#4ECDC4'; 
                break;
            case 'completed':
                icon.style.color = '#2ecc71'; 
                break;
            default:
                icon.style.color = '#4ECDC4'; 
        }
    }
}
