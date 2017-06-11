import $ from 'jquery';
import styles from './styles.css';

window.$ = $;

const $brand = $('#brand');
const $category = $('#category');
const $size = $('#size');
const $sizeContainer = $('#size-container');
const $calculate = $('#calculate');
const $predictionContainer = $('#prediction-container');
const $prediction = $('#prediction');
const $ok = $('#ok');

function createElement(type, className, id, text) {
  return $('<' + type + '/>', {
    class: className,
    id: id,
    text: text
  });
}

function createOption(value, text) {
  return createElement('option', null, null, text)
    .val(value);
}

function getFromApi(path) {
  return $.get('/api' + path);
}

function getBrands() {
  return getFromApi('/brands');
}

function getCategories(brand) {
  return getFromApi('/categories?brand=' + brand);
}

function getPrediction(brand, category, size) {
  var url = '/prediction?brand=' + brand + '&category=' + category + '&size=' + size;
  return getFromApi(url);
}

function appendBrands(brands) {
  const defaultOption = createOption(null, 'Select a brand')
    .attr('selected', true);
  const options = [defaultOption];

  if (brands && brands.length) {
    for (let i = 0; i < brands.length; i++) {
      options.push(createOption(brands[i].key, brands[i].name));

    }
  }

  $brand
    .empty()
    .append(options);
}

function appendCategories(categories) {
  const defaultOption = createOption(null, 'Select a category')
    .attr('selected', true);
  const options = [defaultOption];

  if (categories && categories.length) {
    for (let i = 0; i < categories.length; i++) {
      options.push(createOption(categories[i].key, categories[i].name)
        .attr('data-measurement-type', categories[i].measurement_type));

    }
  }

  $category
    .empty()
    .append(options);
}

function updateSizeCaption(measurementType) {
  $sizeContainer.find('label').text(`My ${measurementType || ''} size is`);
}

function initialize() {
  // Append default values
  appendBrands();
  appendCategories();

  // Attach event handlers
  $brand.change(event => {
    appendCategories();
    updateSizeCaption();
    $category.attr('disabled', true);
    $sizeContainer.addClass('disabled');
    $size.attr('disabled', true).val('');
    $calculate.attr('disabled', true);


    const brand = $(event.delegateTarget).val();

    if (brand) {
      getCategories(brand).then(function({categories}) {
        appendCategories(categories);
        $category.attr('disabled', false);
      });
    }
  });

  $category.change(event => {
    $sizeContainer.addClass('disabled');
    $size.attr('disabled', true).val('');
    $calculate.attr('disabled', true);

    const category = $(event.delegateTarget).val();
    const measurementType = $(event.delegateTarget)
      .find('option:selected')
      .attr('data-measurement-type');

    updateSizeCaption(measurementType);

    if (category) {
      $sizeContainer.removeClass('disabled');
      $size.attr('disabled', false);
    }
  });

  $size.on('input', event => {
    const sizeValue = $(event.delegateTarget).val();

    if (sizeValue) {
      $calculate.attr('disabled', false);
    } else {
      $calculate.attr('disabled', true);
    }
  });

  $calculate.click(event => {
    const brand = $brand.val();
    const category = $category.val();
    const size = $size.val();

    getPrediction(brand, category, size).then(function({prediction: {labels}}) {
      $prediction.text(labels.join(' or '));
      $predictionContainer.removeClass('hidden');
    });
  });

  $ok.click(() => {
    $predictionContainer.addClass('hidden');
  });
}

initialize();

getBrands().then(function({brands}) {
  appendBrands(brands);
  $brand.attr('disabled', false);
});

