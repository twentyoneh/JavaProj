package twentyoneh.site_for_vladivir.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    
    private int cartId;
    private List<CartItem> items = new ArrayList<>();

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    // Getters
    public int getCartId() {
        return cartId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    // Methods
    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProductId() == product.getProductId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(generateItemId(), product.getProductId(), quantity, product.getPrice()));
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }

    public void updateQuantity(int itemId, int newQuantity) {
        for (CartItem item : items) {
            if (item.getItemId() == itemId) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPricePerUnit() * item.getQuantity();
        }
        return totalPrice;
    }

    public void clearCart() {
        items.clear();
    }

    private int generateItemId() {
        return new ArrayList<CartItem>().size(); // Simple ID generation for demonstration
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", items=" + items +
                '}';
    }
}
