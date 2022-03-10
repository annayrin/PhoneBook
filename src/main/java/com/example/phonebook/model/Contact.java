package com.example.phonebook.model;

import com.example.phonebook.model.util.Lable;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data // getter/setter
@Entity // db connection
@ToString

public class Contact {

    @Id // no se porque
    @GeneratedValue(strategy = GenerationType.AUTO) // db table i null not null automated connection //leer

    private int id;
    private String name;
    private String surname;
    private String phone;

    @Column(nullable = false) // o sea => not null
    private String email;

    @Enumerated(EnumType.STRING)
    private Lable phoneLable;

    @Enumerated(EnumType.STRING)
    private Lable emailLable;

    public String stringify() {
        return "" + name +
                "" + surname +
                "" + phone +
                "" + phoneLable +
                "" + email +
                "" + emailLable;
    }

    }

