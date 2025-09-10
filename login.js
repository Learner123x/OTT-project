document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('login-form');

    loginForm.addEventListener('submit', (event) => {
        // Prevent the form from actually submitting
        event.preventDefault(); 
        
        // Get the values from the form (optional, for show)
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        // For now, any login is "successful".
        // We just need to make sure the user entered something.
        if (username && password) {
            // Redirect to the main content page
            window.location.href = 'index.html';
        } else {
            alert('Please enter a username and password.');
        }
    });
});