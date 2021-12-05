package com.wony.account;

import com.wony.account.port.output.AccountJoinInputPort;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private static final List<Character> ID_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".chars()
            .mapToObj(c -> (char) c).toList();

    private final AccountRepository accountRepository;

    @NotNull
    @Transactional
    public Account join(AccountJoinInputPort inputPort) {
        AccountEntity accountEntity = new AccountEntity();
        String number = calculateWNumber();
        accountEntity.setLoginEmailId(inputPort.getLoginEmailId());
        accountEntity.setPassword(inputPort.getPassword());
        accountEntity.setWNumber("W" + number);
        return accountRepository.save(accountEntity);
    }

    @Transactional(readOnly = true)
    public Optional<? extends Account> findByIdAndPassword(String emailId, String password) {
        return accountRepository.findByLoginEmailIdAndPassword(emailId, password);
    }

    @NotNull
    private String calculateWNumber() {
        List<Character> chars = new ArrayList<>(ID_CHARS);
        Collections.shuffle(chars);
        String wNumber = chars.stream().map(String::valueOf).collect(Collectors.joining());
        return "W" + wNumber;
    }
}
