package org.dnyanyog.services;

import java.util.Optional;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public ProductResponse addEditProduct(ProductRequest request) {

		ProductResponse response = new ProductResponse();

		Product pTable = new Product();

		if (request.getProductId() != null) {
			Optional<Product> productData = repo.findById(request.getProductId());

			if (productData.isPresent()) {
				Product product = productData.get();

				product.setProductName(request.getProductName());
				product.setPrice(request.getPrice());
				product.setQuantity(request.getQuantity());

				product = repo.save(product);

				response.setMessage("Product Edited Successfully");
				response.setStatus("Success");

				return response;
			}
		}
		pTable.setProductName(request.getProductName());
		pTable.setPrice(request.getPrice());
		pTable.setQuantity(request.getQuantity());

		pTable = repo.save(pTable);

		response.setMessage("Product Added Successfully");
		response.setStatus("Success");
		response.setProductId(pTable.getProductId());
		response.setProductName(pTable.getProductName());

		return response;
	}

}