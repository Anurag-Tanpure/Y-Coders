document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('internshipForm');
    const fileInput = document.getElementById('offerLetter');
    const fileLabel = document.getElementById('fileName');


    fileInput.addEventListener('change', function(e) {
        const fileName = e.target.files[0]?.name || 'Choose file';
        fileLabel.textContent = fileName;
    });


    form.addEventListener('submit', function(e) {
        e.preventDefault();
        

        const submitBtn = form.querySelector('button[type="submit"]');
        submitBtn.disabled = true;
        submitBtn.innerHTML = `
            <svg class="animate-spin h-5 w-5 mr-3" viewBox="0 0 24 24">
                <circle class="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" stroke-width="4"></circle>
                <path class="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
            </svg>
            Submitting...
        `;

       
        setTimeout(() => {
       
            showNotification('Form submitted successfully!');
            
     
            submitBtn.disabled = false;
            submitBtn.innerHTML = `
                <i class="ri-save-line"></i>
                Submit Details
            `;
            
          
        }, 2000);
    });
});

function showNotification(message) {
    const notification = document.createElement('div');
    notification.className = 'fixed top-4 right-4 bg-green-500 text-white px-6 py-3 rounded-lg shadow-lg animate__animated animate__fadeInRight';
    notification.innerHTML = `
        <div class="flex items-center gap-2">
            <i class="ri-checkbox-circle-line"></i>
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
