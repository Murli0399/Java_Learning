package usecases;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Address;
import model.Customer;
import util.EMUtils;

public class GetAllCustomer {
	public static void main(String[] args) {
		EntityManager em = EMUtils.getEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Customer c JOIN FETCH c.addresses WHERE c.cid = :cid", Customer.class);
		
		query.setParameter("cid", 1L);
		
		Customer cus = (Customer) query.getSingleResult();
		
		List<Address> list = cus.getAddresses();
		
		for(Address i : list) {
			System.out.println(cus.getCid()+" "+cus.getName()+" "+cus.getMobileNumber()+" "+cus.getEmail()+" "+i.getCity()+" "+i.getState());
		}
		
	}
}
