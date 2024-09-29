package com.scm.entities;

import org.aspectj.apache.bcel.classfile.Module.Provide;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 10000)
    private String about;
    @Column(length = 10000)
    private String profilePic;
    private String phoneNumber;

    // Information

    private boolean enable = false;
    private boolean emailVerified = false;
    private boolean phoneVerifies = false;

    // How does user logged in 

    private Providers provider = Providers.SELF;
    private String providerUserInd;
}
