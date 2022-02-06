package com.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther gty
 * @Date 2022/2/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String movieName;

    private String movieUrl;

    private String movieRemark;

    private  String movieNameDesc;

    private Integer parentId;

    private Integer type;
}
