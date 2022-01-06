package ru.koleson.photoappaccmanag.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generatedUserId() {
        return UUID.randomUUID().toString();
    }
}
