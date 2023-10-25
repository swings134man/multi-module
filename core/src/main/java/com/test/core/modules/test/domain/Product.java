package com.test.core.modules.test.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.core.config.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT")
@DynamicInsert
@Getter @Setter
public class Product extends BaseTimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "ID")
    private Long id;

    @JsonProperty("productName")
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @JsonProperty("price")
    @Column(name = "PRICE")
    private Long price;

    @JsonProperty("productSubject")
    @Column(name = "PRODUCT_SUBJECT")
    private String productSubject;

}
