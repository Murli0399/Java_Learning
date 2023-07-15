package com.masai.sevice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masai.exception.ProductNotFound;
import com.masai.model.Product;

@Service
public class ProductService {
	Map<Integer, Product> productMap = new HashMap<>();

	public ProductService() {
		productMap.put(1, new Product(1, "Mobile", "This is a mobile", 10000.25, "Electronic"));
		productMap.put(2, new Product(2, "Laptop", "This is a laptop", 34545.56, "Electronic"));
		productMap.put(3, new Product(3, "T-Shirt", "t-shirt for man", 1400.20, "Cloth"));
		productMap.put(4, new Product(4, "Shofa", "Shofa for house and offices", 5946.25, "Furniture"));
		productMap.put(5, new Product(5, "T.V.", "This is a T.V.", 45845.25, "Electronic"));
	}

	public List<Product> getAllProduct() {
		Collection<Product> collection = productMap.values();

		List<Product> students = new ArrayList<>(collection);

		if (students.isEmpty()) {
			throw new ProductNotFound("Product not Available");
		} else
			return students;
	}

	public Product addProduct(Product p) {
		if (productMap.containsKey(p.getId())) {
			throw new ProductNotFound("Product is Already Available");
		}

		productMap.put(p.getId(), p);

		return p;
	}

	public Product getProductById(Integer id) {
		if (!productMap.containsKey(id)) {
			throw new ProductNotFound("Product is Not Available");
		}

		return productMap.get(id);
	}

	public Product deleteProductById(Integer id) {
		if (!productMap.containsKey(id)) {
			throw new ProductNotFound("Product is Not Available");
		}

		Product ans = productMap.get(id);
		productMap.remove(id);
		return ans;
	}

	public Product updateProductById(Integer id, Product p) {
		if (!productMap.containsKey(id)) {
			throw new ProductNotFound("Product is Not Available");
		}

		Product old = productMap.get(id);
		old.setName(p.getName());
		old.setCategory(p.getCategory());
		old.setDescription(p.getDescription());
		old.setPrice(p.getPrice());

		productMap.put(id, old);

		return old;
	}

}
