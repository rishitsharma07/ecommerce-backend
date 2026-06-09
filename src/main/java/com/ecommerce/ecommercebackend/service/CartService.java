package com.ecommerce.ecommercebackend.service;

import com.ecommerce.ecommercebackend.dto.CartItemDTO;
import com.ecommerce.ecommercebackend.entity.CartItem;
import com.ecommerce.ecommercebackend.entity.Product;
import com.ecommerce.ecommercebackend.entity.User;
import com.ecommerce.ecommercebackend.repository.CartItemRepository;
import com.ecommerce.ecommercebackend.repository.ProductRepository;
import com.ecommerce.ecommercebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartItem addToCart(String email, CartItemDTO dto){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(()-> new RuntimeException("Product not found"));

        List<CartItem> existingItems = cartItemRepository.findByUser(user);
        for (CartItem item : existingItems) {
            if (item.getProduct().getId().equals(dto.getProductId())) {
                item.setQuantity(item.getQuantity() + dto.getQuantity());
                return cartItemRepository.save(item);
            }
        }

        CartItem cartItem = CartItem.builder()
                .user(user)
                .product(product)
                .quantity(dto.getQuantity())
                .build();

        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCart(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return cartItemRepository.findByUser(user);
    }

    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(User user) {
        cartItemRepository.deleteByUser(user);
    }
}
