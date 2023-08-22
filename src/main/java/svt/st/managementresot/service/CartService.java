package svt.st.managementresot.service;


import svt.st.managementresot.entity.CartItem;

import java.util.Collection;

public interface CartService {
    void add(CartItem cartItem);

    void remove(Long id);

    CartItem update(Long proId, int qty);

    void clear();

    Collection<CartItem> getAllItems();

    Integer getCount();

    Double getAmount();

}
