package com.wony.account;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "account")
@EqualsAndHashCode(of = "accountId")
public class AccountEntity implements Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private long accountId;

    @Column(name = "wNumber", nullable = false)
    private String wNumber;

    @Column(name = "login_email_id", nullable = false)
    private String loginEmailId;

    @Column(name = "password", nullable = false)
    private String password;
}
