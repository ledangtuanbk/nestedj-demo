package com.example.demo;

import org.hibernate.dialect.MySQL8Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class CustomMysql8Dialect extends MySQL8Dialect {

    public CustomMysql8Dialect() {
        super();
        registerFunction("bitWiseAnd", new SQLFunctionTemplate(StandardBasicTypes.LONG, "(?1 & ?2)"));
    }
}
