package com.wony.account;

import com.wony.account.port.output.AccountJoinInputPort;
import com.wony.account.port.output.AccountOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAdapter {
    private final AccountService accountService;

    public AccountOutputPort join(AccountJoinInputPort joinInputPort) {
        Account account = accountService.join(joinInputPort);
        return AccountOutput.builder()
                .loginEmailId(joinInputPort.getLoginEmailId())
                .wNumber(account.getWNumber())
                .build();
    }
}
