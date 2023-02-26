(function(){
    let slideIndex = 0;
    showSlides();

    function showSlides() {
        let slides = $('.slider img');

        slides.each((i, slide) => {
            $(slide).hide();
        })

        slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1
        }
        $(slides[slideIndex - 1]).show();
        setTimeout(showSlides, 5000); 
    }
})();