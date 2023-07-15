package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.exception.SellerException;
import com.masai.exception.StoreException;

import util.EMUtils;

public class ShoppingDAOImpl implements ShoppingDAO {

	@Override
	public void addStore(Store store) {
		EntityManager em = EMUtils.getEntityManager();

		Store s = em.find(Store.class, store.getStore_id());
		if (s != null)
			throw new StoreException("Store is already Present");

		em.getTransaction().begin();
		em.persist(store);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void registerBuyer(Buyer buyer, int store_id) throws StoreException {
		EntityManager em = EMUtils.getEntityManager();

		Store s = em.find(Store.class, store_id);
		if (s == null)
			throw new StoreException("Store is Not Present");

		em.getTransaction().begin();
		buyer.getStores().add(s);
		s.getBuyers().add(buyer);
		em.persist(buyer);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void registerSeller(Seller seller) {
		EntityManager em = EMUtils.getEntityManager();

		Seller s = em.find(Seller.class, seller.getSeller_id());
		if (s != null)
			throw new StoreException("Seller is already Present");

		em.getTransaction().begin();
		em.persist(seller);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void assignSellerWithStore(int seller_id, int store_id) {
		EntityManager em = EMUtils.getEntityManager();
		Seller seller = em.find(Seller.class, seller_id);
		if (seller == null)
			throw new SellerException("Invalid seller id");

		Store store = em.find(Store.class, store_id);
		if (store == null)
			throw new StoreException("Invalid store id");
		em.getTransaction().begin();
		store.setSeller(seller);
		seller.getStores().add(store);
		em.persist(store);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Buyer> getAllBuyersByStoreName(String store_name) throws StoreException {
		EntityManager em = EMUtils.getEntityManager();
		Query query = em.createQuery("SELECT b FROM Buyer b JOIN b.stores s WHERE s.store_name = :store_name",
				Buyer.class);

		query.setParameter("store_name", store_name);

		List<Buyer> list = query.getResultList();
		if (list.isEmpty())
			throw new StoreException("No buyers found for the given store name");
		return list;
	}

}
