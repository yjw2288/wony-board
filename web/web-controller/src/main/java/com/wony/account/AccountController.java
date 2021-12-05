package com.wony.account;

import com.wony.account.port.output.AccountOutputPort;
import con.wony.account.AccountJoinForm;
import con.wony.account.AccountWebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountWebService accountWebService;

    @PostMapping("/join")
    public AccountOutputPort join(@RequestBody AccountJoinForm joinForm) {
        return accountWebService.join(joinForm);
    }
}
