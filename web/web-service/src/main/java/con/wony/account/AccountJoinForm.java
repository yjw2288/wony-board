package con.wony.account;

import com.wony.account.port.output.AccountJoinInputPort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountJoinForm implements AccountJoinInputPort {
    private String loginEmailId;
    private String password;
}
