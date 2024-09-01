package com.pathum.bank.accounts.configs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "accounts")
@Component
public class AccountBuildConfigs {

    private String env;
    private String contactPerson;
    private String version;
    private String email;
}
