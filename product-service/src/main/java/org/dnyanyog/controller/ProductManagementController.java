package org.dnyanyog.controller;

import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {

	@Autowired
	ProductService productService;

	@PostMapping(path = "/api/v1/product/add/update")
	public ProductResponse productService(@RequestBody ProductRequest pRequest) {

		return productService.addEditProduct(pRequest);
	}
}
