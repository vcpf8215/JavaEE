package com.vcpf.jee202405110407.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Book {
    String isbn;
    Double price;
    String bname;
    String publishing;
    String author;
    String picture;
}