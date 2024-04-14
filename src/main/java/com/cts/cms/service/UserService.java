package com.cts.cms.service;

import com.cts.cms.dto.LoginDto;
import com.cts.cms.dto.RegisterDto;

public interface UserService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
