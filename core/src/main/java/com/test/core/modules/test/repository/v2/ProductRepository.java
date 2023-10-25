package com.test.core.modules.test.repository.v2;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.core.modules.test.common.CommonRepository;
import com.test.core.modules.test.domain.Product;
import com.test.core.modules.test.domain.QProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepository extends CommonRepository<Product, Long> {

    private final QProduct product;

    private final JPAQueryFactory queryFactory;

    public ProductRepository(JPAQueryFactory queryFactory, EntityManager entityManager) {
        super(Product.class, QProduct.product, queryFactory, entityManager);
        this.product = (QProduct) super.getEntity();
        this.queryFactory = super.getQueryFactory();
    }

    public List<Product> listProduct() {
        return queryFactory.selectFrom(product)
                .where(product.productName.isNotNull())
                .orderBy(product.id.desc())
                .fetch();
    }

}
