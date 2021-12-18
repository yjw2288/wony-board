package com.wony.account;

import com.wony.account.port.output.AccountJoinInputPort;
import com.wony.account.port.output.AccountOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountWebService {
    private final AccountAdapter accountAdapter;

    public AccountOutputPort join(AccountJoinInputPort inputPort) {
        return accountAdapter.join(inputPort);
    }
}
