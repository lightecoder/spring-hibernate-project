$(document).ready(function() {
    $("#locales").change(function () {
        const selectedOption = $('#locales').val();
        if (selectedOption !== ''){
            window.location.replace('internationalUser?lang=' + selectedOption);
        }
    });
});