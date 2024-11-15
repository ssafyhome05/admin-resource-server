package com.oauth2admin.controller;

import com.oauth2admin.dto.ResDto;
import com.oauth2admin.dto.ResWrapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @GetMapping("/me")
  public ResWrapper me() {

    ResDto resDto = ResDto.builder().username(SecurityContextHolder.getContext().getAuthentication().getName()).role("ADMIN").build();
    return ResWrapper.builder().response(resDto).build();
  }
}
