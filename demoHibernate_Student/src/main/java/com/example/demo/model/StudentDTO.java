package com.example.demo.model;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class StudentDTO {

    private Long id;
    private MysqlxDatatypes.Scalar.String name;
    private MysqlxDatatypes.Scalar.String lastname;

}
