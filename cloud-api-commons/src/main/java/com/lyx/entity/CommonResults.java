package com.lyx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liao 2021/1/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResults<T> {
    private Integer code;
    private String message;
    private T      data;

    public CommonResults(Integer code, String message){
        this(code,message,null);
    }

}
