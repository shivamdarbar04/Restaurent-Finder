// Get user's current location using Geolocation API
navigator.geolocation.getCurrentPosition(function(position) {
    var userLatitude = position.coords.latitude;
    var userLongitude = position.coords.longitude;

    var mymap = L.map('map').setView([userLatitude, userLongitude], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '© OpenStreetMap contributors'
    }).addTo(mymap);

    // Overpass API query to find nearby restaurants within 2 km radius
    var query = `[out:json][timeout:25];
    (
      node["amenity"="restaurant"](around:5000, ${userLatitude}, ${userLongitude});
    );
    out body;`;

    fetch(`https://overpass-api.de/api/interpreter?data=${encodeURIComponent(query)}`)
        .then(response => response.json())
        .then(data => {
            data.elements.forEach(element => {
                if (element.type === "node" && element.tags.name) {
                    // Add markers for nearby restaurants
                    var restaurantLatitude = element.lat;
                    var restaurantLongitude = element.lon;
                    var restaurantName = element.tags.name;

                    var marker = L.marker([restaurantLatitude, restaurantLongitude]).addTo(mymap);
                    marker.bindPopup(restaurantName);
                }
            });
        })
        .catch(error => console.error('Error:', error));
});
