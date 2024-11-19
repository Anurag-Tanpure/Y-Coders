
document.addEventListener('DOMContentLoaded', function() {
   
    const formElements = document.querySelectorAll('.form-control');
    formElements.forEach((element, index) => {
        element.style.animation = `fadeInUp 0.5s ease forwards ${index * 0.1}s`;
    });

    
    formElements.forEach(element => {
        element.addEventListener('focus', function() {
            this.style.transform = 'scale(1.02)';
        });

        element.addEventListener('blur', function() {
            this.style.transform = 'scale(1)';
        });
    });

   
    const form = document.querySelector('form');
    form.addEventListener('submit', function(e) {
        e.preventDefault();
        const button = this.querySelector('button');
        button.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Logging in...';
        
        
        setTimeout(() => {
           
            console.log('Login attempted');
            button.innerHTML = 'Login';
        }, 2000);
    });
});
