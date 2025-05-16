// custom.js

document.addEventListener('DOMContentLoaded', function() {
  // Create a toast container if not present
  if (!document.getElementById('toast-container')) {
    const container = document.createElement('div');
    container.id = 'toast-container';
    document.body.appendChild(container);
  }

  // Show toast on form submissions
  document.querySelectorAll('form').forEach(form => {
    form.addEventListener('submit', function(e) {
      // Delay showing toast until after redirect
      // Use sessionStorage flag to detect redirect
      const action = form.getAttribute('action');
      sessionStorage.setItem('lastAction', action);
    });
  });

  // After page load, show toast based on lastAction
  const last = sessionStorage.getItem('lastAction');
  if (last === '/book' || last === '/create-meeting' || last === '/approve') {
    let message = '';
    if (last === '/create-meeting') message = 'Meeting successfully created!';
    if (last === '/book') message = 'Your booking has been submitted!';
    if (last === '/approve') message = 'Booking approved!';

    // Clear flag
    sessionStorage.removeItem('lastAction');

    // Build toast element
    const toastHTML = `
      <div class="toast align-items-center text-white bg-success border-0 mb-2" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="d-flex">
          <div class="toast-body">
            ${message}
          </div>
          <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
      </div>`;
    const container = document.getElementById('toast-container');
    container.insertAdjacentHTML('beforeend', toastHTML);

    // Initialize and show
    const toastEl = container.querySelector('.toast:last-child');
    const bsToast = new bootstrap.Toast(toastEl, { delay: 3000 });
    bsToast.show();
  }
});
