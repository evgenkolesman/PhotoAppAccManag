package ru.koleson.photoappaccmanag.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.koleson.photoappaccmanag.model.AccountDetailRequestModel;
import ru.koleson.photoappaccmanag.model.AccountRest;
import ru.koleson.photoappaccmanag.repository.AccountRepository;
import ru.koleson.photoappaccmanag.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public AccountRest create(AccountDetailRequestModel account) {
        return repository.save(AccountRest.of(account));
    }

    @Override
    public AccountRest update(AccountDetailRequestModel account) {
        return null;
    }

    @Override
    public void delete(Long accountId) {
        if (repository.existsById(accountId))
        repository.deleteById(accountId);
    }

    @Override
    public Optional<AccountRest> findAccount(Long accountId) {
        return repository.findById(accountId);
    }

    @Override
    public List<AccountRest> findAll() {
        return (List<AccountRest>) repository.findAll();
    }
}
