package com.microservices.shoppingcart.controller;

import com.microservices.shoppingcart.model.Cart;
import com.microservices.shoppingcart.model.Item;
import com.microservices.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item){
        Optional<Cart> saveCart = cartRepository.findById(id);
        Cart cart;
        if(saveCart.isEmpty()){
            cart = new Cart(id);
        }else{
            cart = saveCart.get();
        }

        cart.getItems().add(item);

        return cartRepository.save(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Cart> findById(@PathVariable("id") Long id){
        return cartRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable Long id){
        cartRepository.deleteById(id);
    }
}
