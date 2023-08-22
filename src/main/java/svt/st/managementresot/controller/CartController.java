package svt.st.managementresot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import svt.st.managementresot.dto.service.FacilityDto;
import svt.st.managementresot.entity.CartItem;
import svt.st.managementresot.service.CartService;
import svt.st.managementresot.service.FacilityService;

@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private FacilityService facilityService;

    @Autowired
    private CartService cartService;

    @GetMapping("views")
    public  String viewCart(Model model){
        model.addAttribute("cart_items", cartService.getAllItems() );
       model.addAttribute("total", cartService.getAmount());
        return "Cart";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable("id") Long id){

        FacilityDto facility = facilityService.finFacilityById(id);

        if(facility != null) {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(id);
            cartItem.setName(facility.getName());
            cartItem.setPrice(facility.getCost());
            cartItem.setQty(1);
            cartService.add(cartItem);
        }

        return "redirect:/cart/views";
    }

    @GetMapping("/delete/{id}")
    public  String remove(@PathVariable("id") Long id){
        cartService.remove(id);
        return  "redirect:/cart/views";
    }


    @PostMapping("/update")
    public String update(@RequestParam("id") Long id, @RequestParam("qty") int quantity) {
        System.out.println(id + ", " +quantity);
        cartService.update(id,quantity);
        return  "redirect:/cart/views";
    }


}




















