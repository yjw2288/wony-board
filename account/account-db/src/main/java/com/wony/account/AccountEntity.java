package com.wony.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "account")
public class AccountEntity implements Account {
    private long accountId;
    private String wNumber;
    private String loginEmailId;
    private String password;
}
