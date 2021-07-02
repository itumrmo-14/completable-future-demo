package com.tut.completablefuturedemo.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class Customer {
    private String firstname;
    private String lastname;
}
