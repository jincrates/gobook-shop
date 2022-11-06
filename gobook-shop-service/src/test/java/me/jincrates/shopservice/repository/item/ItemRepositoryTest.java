package me.jincrates.shopservice.repository.item;

import me.jincrates.shopservice.domain.enumtype.ItemSellStatus;
import me.jincrates.shopservice.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    
    @Test
    @DisplayName("상품 저장 테스트")
    void create_item() {
        //given
        Item item = Item.builder()
                .itemNm("테스트 상품")
                .price(10000)
                .itemDetail("테스트 상품 상세 설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(100)
                .build();

        //when
        Item savedItem = itemRepository.save(item);
        //then
        assertNotNull(savedItem);
        assertEquals(item.getId(), savedItem.getId());
    }
}