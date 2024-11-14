package com.oauth2admin.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResWrapper {

  private ResDto response;
}
