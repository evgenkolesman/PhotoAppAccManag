package ru.koleson.photoappaccmanag.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.koleson.photoappaccmanag.model.AccountDetailRequestModel;
import ru.koleson.photoappaccmanag.model.AccountRest;
import ru.koleson.photoappaccmanag.service.AccountService;
import ru.koleson.photoappaccmanag.util.Utils;

import javax.validation.Valid;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final Environment env;
    private final AccountService accountService;


    @GetMapping("/status/check")
    public String status() {
        return "Api is working well " + env.getProperty("local.server.port");
    }
    @GetMapping
    public List<AccountRest> getAllAccount() {
        return accountService.findAll();
    }

    @GetMapping(path = "/accountId", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public Optional<AccountRest> getAccount(@PathVariable String accountId) {
        return accountService.findAccount(accountId);
    }

    @PostMapping(consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity create(@RequestBody AccountDetailRequestModel model) throws ServerException {
            return new ResponseEntity(accountService.create(model), HttpStatus.OK);
    }

    @PutMapping(path ="/{accountId}", consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    }, produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity update(@PathVariable String accountId, @Valid @RequestBody AccountDetailRequestModel model) {
        return new ResponseEntity(accountService.update(model), HttpStatus.OK);

    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable String accountId) {
        if(accountService.findAccount(accountId).isPresent()) accountService.delete(accountId);
        return ResponseEntity.noContent().build();
    }

}



