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
    private String id;

    @ApiModelProperty(value = "패스워드")
    private String password;

    @ApiModelProperty(value = "유저고유아이디")
    private int userId;
}
