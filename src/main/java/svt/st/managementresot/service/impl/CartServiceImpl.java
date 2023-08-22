package svt.st.managementresot.service.impl;

import org.springframework.stereotype.Service;
import svt.st.managementresot.entity.CartItem;
import svt.st.managementresot.service.CartService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service

public class CartServiceImpl implements CartService {
    Map<Long, CartItem> maps = new HashMap<>(); // cart


    @Override
    public void add(CartItem cartItem) {
        CartItem item = maps.get(cartItem.getProductId());
        if(item == null) {
            maps.put(cartItem.getProductId() , cartItem);
        }else {
            item.setQty((item.getQty() + 1));
        }
    }

    @Override
    public void remove(Long id) {
        maps.remove(id);
    }

    @Override
    public CartItem update(Long proId, int qty) {
        CartItem cartItem = maps.get(proId);
        cartItem.setQty(qty);
        return cartItem;
    }

    @Override
    public void clear() {
        maps.clear();
    }

    @Override
    public Collection<CartItem> getAllItems() {
        return maps.values();
    }

    @Override
    public Integer getCount() {
        return maps.values().size();
    }

    @Override
    public Double getAmount() {
        return maps.values().stream()
                .mapToDouble(item ->item.getQty() * item.getPrice())
                .sum();
    }


}










