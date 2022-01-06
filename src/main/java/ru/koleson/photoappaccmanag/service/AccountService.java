package ru.koleson.photoappaccmanag.service;

import org.springframework.stereotype.Service;
import ru.koleson.photoappaccmanag.model.AccountDetailRequestModel;
import ru.koleson.photoappaccmanag.model.AccountRest;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    AccountRest create(AccountDetailRequestModel account);

    AccountRest update(AccountDetailRequestModel account);

    void delete(String accountId);

    Optional<AccountRest> findAccount(String id);

    List<AccountRest> findAll();
}
