package ru.koleson.photoappaccmanag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.koleson.photoappaccmanag.model.AccountRest;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountRest, String> {

     List<AccountRest> findAll();

}
