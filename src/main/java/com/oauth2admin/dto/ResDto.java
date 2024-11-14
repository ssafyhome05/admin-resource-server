package com.oauth2admin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResDto {

  private String username;
  private String role = "ADMIN";
}

