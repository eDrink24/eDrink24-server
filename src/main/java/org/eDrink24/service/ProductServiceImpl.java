package org.eDrink24.service;

import org.eDrink24.domain.product.Product;
import org.eDrink24.dto.product.ProductDTO;
import org.eDrink24.repository.product.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAll() {
        ModelMapper mapper = new ModelMapper();
        List<Product> list = productRepository.findAll();
        List<ProductDTO> productList =
                list.stream().map(e->mapper.map(e, ProductDTO.class)).collect(Collectors.toList());
        return productList;
    }
}
