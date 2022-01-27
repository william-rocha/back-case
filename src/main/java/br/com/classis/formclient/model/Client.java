package br.com.classis.formclient.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clients")
@Setter
@Getter
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String cpf;

    @Column(nullable = true)
    private Date birth;

    @Column(nullable = true)
    private String telPhone;


    @Column(nullable = true)
    private String telFixed;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String userEmailAlert;


    @Column(nullable = true,  length = 64)
    private String logo;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String number;

    @Column(nullable = true)
    private String district;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private String emailAlert;



    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

}
