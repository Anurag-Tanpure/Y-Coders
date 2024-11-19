document.addEventListener('DOMContentLoaded', function() {
    // Get all form control elements for animation and styling
    const formElements = document.querySelectorAll('.form-control');
    
    // Apply animation to form fields on page load
    formElements.forEach((element, index) => {
        element.style.animation = `fadeInUp 0.5s ease forwards ${index * 0.1}s`;
    });

    // Event listeners for focus and blur effects on form fields
    formElements.forEach(element => {
        element.addEventListener('focus', function() {
            this.style.transform = 'scale(1.02)';
        });

        element.addEventListener('blur', function() {
            this.style.transform = 'scale(1)';
        });
    });

    // Handle form submission with a loading spinner
    const form = document.querySelector('form');
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        
        // Change button text to show loading spinner
        const button = this.querySelector('button');
        button.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Logging in...';
        
        // Simulating a login process with a timeout
        setTimeout(() => {
            console.log('Login attempted');
            button.innerHTML = 'Login';  // Reset button text after timeout
        }, 2000);  // Simulate a 2-second delay for login
    });
});
