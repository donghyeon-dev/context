package com.autocat.context.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    @ApiModelProperty(value = "아이디")
    String id;

    @ApiModelProperty(value = "패스워드")
    String password;

    @ApiModelProperty(value = "유저고유아이디")
//    int userId;
    Integer userId;
}
