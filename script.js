document.addEventListener('DOMContentLoaded', () => {
    const mockData = [
    { id: 1, title: 'Inception', posterUrl: 'images/poster-inception.jpg', contentType: 'Movie' },
    { id: 2, title: 'Breaking Bad', posterUrl: 'images/poster-breakingbad.jpg', contentType: 'TVShow' },
    { id: 3, title: 'The Matrix', posterUrl: 'images/poster-matrix.jpg', contentType: 'Movie' },
    { id: 4, title: 'Game of Thrones', posterUrl: 'images/poster-got.jpg', contentType: 'TVShow' },
    { id: 5, title: 'Forrest Gump', posterUrl: 'images/poster-forrestgump.jpg', contentType: 'Movie' }
];
    const trendingContainer = document.getElementById('trending-container');
    const tvShowsContainer = document.getElementById('tvshows-container');

    function createContentCard(content) {
        return `
            <a href="#" class="flex-shrink-0 group">
                <div class="w-40 h-60 bg-gray-900 rounded-lg overflow-hidden transform group-hover:scale-105 transition-transform duration-300">
                    <img src="${content.posterUrl}" alt="${content.title} Poster" class="w-full h-full object-cover">
                </div>
            </a>
        `;
    }

    function populateCarousels(data) {
        const movies = data.filter(item => item.contentType === 'Movie');
        const tvShows = data.filter(item => item.contentType === 'TVShow');

        trendingContainer.innerHTML = movies.map(createContentCard).join('');
        tvShowsContainer.innerHTML = tvShows.map(createContentCard).join('');
    }

    populateCarousels(mockData);
});