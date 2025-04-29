// Массив товаров
const products = [
    { id: 1, name: "Товар 1", price: "1000₽" },
    { id: 2, name: "Товар 2", price: "1500₽" },
    { id: 3, name: "Товар 3", price: "2000₽" },
  ];
  
  const productList = document.getElementById('product-list');
  const favoriteList = document.getElementById('favorite-list');
  let favorites = [];
  
  function renderProducts() {
    productList.innerHTML = '';
    products.forEach(product => {
      const div = document.createElement('div');
      div.className = 'product';
      div.innerHTML = `
        <h3>${product.name}</h3>
        <p>${product.price}</p>
        <button onclick="addToFavorites(${product.id})">Добавить в избранное</button>
      `;
      productList.appendChild(div);
    });
  }
  
  function addToFavorites(productId) {
    const product = products.find(p => p.id === productId);
    if (!favorites.includes(product)) {
      favorites.push(product);
      renderFavorites();
    }
  }
  
  function renderFavorites() {
    favoriteList.innerHTML = '';
    favorites.forEach(product => {
      const div = document.createElement('div');
      div.className = 'favorite';
      div.innerHTML = `
        <h3>${product.name}</h3>
        <p>${product.price}</p>
      `;
      favoriteList.appendChild(div);
    });
  }
  
  // Стартовая отрисовка
  renderProducts();
  