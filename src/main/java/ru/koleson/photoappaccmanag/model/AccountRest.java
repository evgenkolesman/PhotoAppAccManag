package ru.koleson.photoappaccmanag.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "accountrest")
public class AccountRest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Long accountId;

    private String firstName;

    private String lastName;

    private String email;

    public static AccountRest of(AccountDetailRequestModel account) {
        AccountRest accountRest = new AccountRest();
        accountRest.setFirstName(account.getFirstName());
        accountRest.setLastName(account.getLastName());
        accountRest.setEmail(account.getEmail());
        return accountRest;
    }
}
