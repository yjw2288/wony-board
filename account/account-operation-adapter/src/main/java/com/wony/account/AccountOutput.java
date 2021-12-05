package com.wony.account;

import com.wony.account.port.output.AccountOutputPort;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
class AccountOutput implements AccountOutputPort {
    private String loginEmailId;
    private String wNumber;
}
