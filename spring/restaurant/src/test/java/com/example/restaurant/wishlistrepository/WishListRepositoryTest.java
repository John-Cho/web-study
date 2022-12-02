package com.example.restaurant.wishlistrepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.restaurant.wishlist.entity.WishListEntity;
import com.example.restaurant.wishlist.repository.WishListRepository;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;
    
    private WishListEntity create(){
        var wishlist = new WishListEntity();
        wishlist.setTitile("Title");
        wishlist.setCategory("categorey");
        wishlist.setAddress("address");
        wishlist.setRoadAddress("Road Address");
        wishlist.setHomePageLink("www.naver.com");
        wishlist.setImageLink("www.naver.com/naver");
        wishlist.setIsVisit(false);
        wishlist.setVisitCount(0);
        wishlist.setLastVisitDate(null);

        return wishlist;
    }

    @Test
    public void saveTest(){
        var wishListEntity = create();
        var expected = wishListRepository.Save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());
    }

    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishListRepository.Save(wishListEntity);
        
        expected.setTitile("update test");
        var saveEntity = wishListRepository.Save(expected);

        Assertions.assertEquals("update test", saveEntity.getTitile());
        Assertions.assertEquals(1, wishListRepository.listAll().size());
    }

    @Test
    public void findByIdTest(){
        var wishListEntity = create();
        wishListRepository.Save(wishListEntity);

        var expected = wishListRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());
    }

    @Test
    public void deleteTest(){
        var wishListEntity = create();
        wishListRepository.Save(wishListEntity);

        wishListRepository.deleteById(1);
        int count = wishListRepository.listAll().size();
        Assertions.assertEquals(0, count);
    }

    @Test
    public void listallTest(){
        var wishListEntity1 = create();
        wishListRepository.Save(wishListEntity1);

        var wishListEntity2 = create();
        wishListRepository.Save(wishListEntity2);

        int count = wishListRepository.listAll().size();

        Assertions.assertEquals(2, count);
    }
}
