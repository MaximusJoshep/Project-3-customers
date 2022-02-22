package com.nttdata.customers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "customers")
public class Customers {

    @Id
    private String id;
    private String name;
    private String typeDoc;
    private String nroDoc;
    private String code;
    private String codProfile;
    @DateTimeFormat(pattern = "aaaa-mm-dd")
    public Date date;
    private Boolean status;

}
