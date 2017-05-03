var express = require('express');
var morgan = require('morgan');
var app = express();

var responses = {
    brands: [
        { key: "calvin-klein", name: "Calvin Klein" },
        { key: "diane-von-furstenberg", name: "Diane von Fürstenberg" },
        { key: "michael-kors", name: "Michael Kors" },
    ],
    categories: [
        { key: "dresses", name: "Dresses", measurement_type: "bust" },
        { key: "jeans", name: "Jeans", measurement_type: "waist" },
        { key: "sneakers", name: "Sneakers", measurement_type: "length" },
    ],
    prediction: { labels: ["S", "4"] },
};

app.use(morgan('dev'));
app.use(express.static('../frontend/dist'));
app.set('json spaces', 2);

app.get('/brands', function(req, res) {
    res.json({ brands: responses.brands });
});

app.get('/categories', function(req, res) {
    res.json({ categories: responses.categories });
});

app.get('/prediction', function(req, res) {
    var params = {
        brand: req.query.brand,
        category: req.query.category,
        size: req.query.size,
    };

    if (!includesKey(responses.brands, params.brand)) {
        return res.status(404).json({ error: { message: "brand was not found" } });
    }

    if (!includesKey(responses.categories, params.category)) {
        return res.status(404).json({ error: { message: "category was not found" } });
    }

    res.json({ prediction: responses.prediction });
});

app.listen(3000, function() {
    console.log('Server listening on port 3000')
});

function includesKey(array, key) {
    var keys = array.map(function(elem) { return elem.key; });
    return contains(keys, key);
}

function contains(array, element) {
    return array.indexOf(element) > -1;
}
