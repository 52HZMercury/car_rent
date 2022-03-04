package com.carRent4_0.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-27 10:35
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private String id;
    private String name;
    private String password;
    private int type;
}
