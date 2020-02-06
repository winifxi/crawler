package com.baomidou.ant.crawler-webmagic.entity;

import 你自己的父类实体,没有就不用设置!;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yutin
 * @since 2020-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Av extends 你自己的父类实体,没有就不用设置! {

    private static final long serialVersionUID = 1L;

    /**
     * 番号，通过url获取
     */
    private String fanhao;

    /**
     * data-original-title
     */
    private String name;

    /**
     * 标题
     */
    private String title;

    private String categories;

    private String tags;

    private String image;

    private String url;

    private Integer pageView;

    private Integer like;

    private LocalDate marketDate;

    private LocalDateTime lastTime;

    private LocalDateTime creatTime;


}
