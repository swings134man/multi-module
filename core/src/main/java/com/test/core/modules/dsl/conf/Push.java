package com.test.core.modules.dsl.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.core.config.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

/************
 * @info : Push 기반 테스트 ENTITY
 * @name : Push
 * @date : 1/5/24 11:28 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
@Entity
@Table(name = "PUSH")
@DynamicInsert
@Getter @Setter
public class Push extends BaseTimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "ID")
    private Long id;

    @JsonProperty("text")
    @Column(name = "TEXT")
    private String text; //내용

    @JsonProperty("target")
    @Column(name = "TARGET")
    private Long target; //대상

    @JsonProperty("type")
    @Column(name = "TYPE")
    private String type;//타입 (mail, sms, push)

}
