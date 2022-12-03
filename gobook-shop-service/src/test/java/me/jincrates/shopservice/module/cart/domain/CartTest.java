package me.jincrates.shopservice.module.cart.domain;

import me.jincrates.shopservice.module.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Profile("test")
@Transactional
@SpringBootTest(classes = Cart.class)
class CartTest {

    @Autowired
    CartRepository cartRepository;

}