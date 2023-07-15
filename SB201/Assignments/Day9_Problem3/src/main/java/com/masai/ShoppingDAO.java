package com.masai;

import java.util.List;

import com.masai.exception.SellerException;
import com.masai.exception.StoreException;

public interface ShoppingDAO {
    void addStore(Store store);
    void registerBuyer(Buyer buyer, int store_id) throws StoreException;
    void registerSeller(Seller seller);
    void assignSellerWithStore(int seller_id, int store_id) throws SellerException, StoreException;
    List<Buyer> getAllBuyersByStoreName(String store_name) throws StoreException;
}
