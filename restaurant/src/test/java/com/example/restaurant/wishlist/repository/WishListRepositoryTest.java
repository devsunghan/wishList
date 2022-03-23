package com.example.restaurant.wishlist.repository;


import com.example.restaurant.wishlist.dto.WishListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;


    private WishListDto create() {
        var wishList = new WishListDto();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("add");
        wishList.setRoadAddress("road");
        wishList.setHomePageLink("homepage");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest() {
        var wishListDto = create();
        var expected = wishListRepository.save(wishListDto);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void updateTest() {
        var wishListDto = create();
        var expected = wishListRepository.save(wishListDto);

        expected.setTitle("update test");
        var saveEntity = wishListRepository.save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitle());
        Assertions.assertEquals(1, wishListRepository.findAll().size());
    }


    @Test
    public void deleteTest() {
        var wishListDto = create();
        wishListRepository.save(wishListDto);

        wishListRepository.deleteById(1);

        int count = wishListRepository.findAll().size();

        Assertions.assertEquals(0, count);
    }

    @Test
    public void listAllTest() {
        var wishListDto1 = create();
        wishListRepository.save(wishListDto1);

        var wishListDto2 = create();
        wishListRepository.save(wishListDto2);

        int count = wishListRepository.findAll().size();
        Assertions.assertEquals(2, count);
    }

    @Test
    public void findByIdTest() {
        var wishListDto = create();
        wishListRepository.save(wishListDto);

        var expected = wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());

    }
}
