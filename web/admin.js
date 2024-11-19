document.addEventListener('DOMContentLoaded', function() {
   
    const navItems = document.querySelectorAll('.nav-item');
    const sections = document.querySelectorAll('.dashboard-section');

    navItems.forEach(item => {
        item.addEventListener('click', function() {
            const targetSection = this.dataset.section;
            
         
            if (this.classList.contains('logout')) {
                handleLogout();
                return;
            }

           
            navItems.forEach(nav => nav.classList.remove('active'));
            this.classList.add('active');

      
            sections.forEach(section => {
                section.classList.remove('active');
                if (section.id === targetSection) {
                    section.classList.add('active');
                }
            });
        });
    });

  
    const counters = document.querySelectorAll('.counter');
    counters.forEach(counter => {
        const target = parseInt(counter.innerText);
        let count = 0;
        const speed = 2000 / target;
        
        function updateCount() {
            if (count < target) {
                count++;
                counter.innerText = count;
                setTimeout(updateCount, speed);
            }
        }
        
        updateCount();
    });
});


function showModal(type) {
    const modal = document.getElementById('modal');
    const modalTitle = document.getElementById('modal-title');
    const modalBody = document.getElementById('modal-body');
    
    modal.style.display = 'block';
    
  
    switch(type) {
        case 'student':
            modalTitle.textContent = 'Add New Student';
            modalBody.innerHTML = `
                <form class="modal-form">
                    <div class="form-group">
                        <input type="text" placeholder="Student ID" required>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Full Name" required>
                    </div>
                    <div class="form-group">
                        <input type="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <select required>
                            <option value="">Select Department</option>
                            <option value="cs">Computer Science</option>
                            <option value="it">Information Technology</option>
                            <option value="ec">Electronics</option>
                        </select>
                    </div>
                    <button type="submit" class="submit-btn">Add Student</button>
                </form>
            `;
            break;
        case 'mentor':
            modalTitle.textContent = 'Add New Mentor';
            modalBody.innerHTML = `
                <form class="modal-form">
                    <div class="form-group">
                        <input type="text" placeholder="Mentor ID" required>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Full Name" required>
                    </div>
                    <div class="form-group">
                        <input type="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <select required>
                            <option value="">Select Department</option>
                            <option value="cs">Computer Science</option>
                            <option value="it">Information Technology</option>
                            <option value="ec">Electronics</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Specialization" required>
                    </div>
                    <button type="submit" class="submit-btn">Add Mentor</button>
                </form>
            `;
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


window.onclick = function(event) {
    const modal = document.getElementById('modal');
    if (event.target === modal) {
        hideModal();
    }
}


document.addEventListener('submit', function(e) {
    if (e.target.classList.contains('modal-form')) {
        e.preventDefault();
        
        hideModal();
  
        showNotification('Operation completed successfully!');
    }
});

function showNotification(message) {
    const notification = document.createElement('div');
    notification.className = 'notification animate__animated animate__fadeInRight';
    notification.textContent = message;
    document.body.appendChild(notification);
    
    setTimeout(() => {
        notification.classList.remove('animate__fadeInRight');
        notification.classList.add('animate__fadeOutRight');
        setTimeout(() => {
            notification.remove();
        }, 1000);
    }, 3000);
}
