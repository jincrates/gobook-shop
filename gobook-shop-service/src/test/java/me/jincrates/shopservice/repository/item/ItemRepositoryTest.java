package me.jincrates.shopservice.repository.item;

import me.jincrates.shopservice.domain.enumtype.ItemSellStatus;
import me.jincrates.shopservice.domain.item.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    public void createItemList() {
        List<Item> itemList = new ArrayList<>();
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 * i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .stockNumber(100 * i)
                    .build();
            itemList.add(item);
        });
        itemRepository.saveAll(itemList);
    }

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

    @Test
    @DisplayName("상품명 조회 테스트")
    void find_by_item_nm() {
        //given
        this.createItemList();

        //when
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");

        //then
        for (Item item : itemList) {
            System.out.println(item.toString());
            assertEquals("테스트 상품1", item.getItemNm());
        }
    }
}