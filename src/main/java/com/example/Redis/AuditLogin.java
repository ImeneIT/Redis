package com.example.Redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditLogin {
    private String applicationVersion;
    private String clientIPAddress;
    private String constructor;
    private String deviceId;
    private String jailBreakIndicator;
    private String osUsed;
    private String osVersion;
}
