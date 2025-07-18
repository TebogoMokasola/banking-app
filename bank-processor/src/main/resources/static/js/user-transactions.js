function toggleAccordion(element) {
    const body = element.nextElementSibling;
    body.style.display = body.style.display === 'block' ? 'none' : 'block';
}