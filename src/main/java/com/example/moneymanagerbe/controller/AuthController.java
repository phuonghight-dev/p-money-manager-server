package com.example.moneymanagerbe.controller;

import com.example.moneymanagerbe.base.RestApiV1;
import com.example.moneymanagerbe.base.VsResponseUtil;
import com.example.moneymanagerbe.constant.UrlConstant;
import com.example.moneymanagerbe.domain.dto.request.ForgotPasswordRequestDto;
import com.example.moneymanagerbe.domain.dto.request.LoginRequestDto;
import com.example.moneymanagerbe.domain.dto.request.UserCreateDto;
import com.example.moneymanagerbe.service.AuthService;
import com.example.moneymanagerbe.validator.annotation.ValidFileImage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RequiredArgsConstructor
@Validated
@RestApiV1
public class AuthController {

  private final AuthService authService;

  @Operation(summary = "API Login")
  @PostMapping(UrlConstant.Auth.LOGIN)
  public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto request) {
    return VsResponseUtil.success(authService.login(request));
  }

  @Operation(summary = "API Register")
  @PostMapping(UrlConstant.Auth.REGISTER)
  public ResponseEntity<?> register(@Valid @RequestBody UserCreateDto request) {
    return VsResponseUtil.success(authService.register(request));
  }

  @Operation(summary = "API Logout")
  @GetMapping(UrlConstant.Auth.LOGOUT)
  public ResponseEntity<?> logout(HttpServletRequest request,
                                  HttpServletResponse response, Authentication authentication) {
    return VsResponseUtil.success(authService.logout(request, response, authentication));
  }

  @Operation(summary = "API Forgot password")
  @PostMapping(UrlConstant.Auth.RESET_PASSWORD)
  public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequestDto requestDto) {
    return VsResponseUtil.success(authService.forgotPassword(requestDto));
  }

  @Operation(summary = "API test")
  @PostMapping("auth/test")
  public String login(@ValidFileImage MultipartFile multipartFile) {
    return multipartFile.getContentType();
  }

}
