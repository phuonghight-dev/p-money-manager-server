package com.example.moneymanagerbe.service;

import com.example.moneymanagerbe.domain.dto.request.WalletRequestDto;
import com.example.moneymanagerbe.domain.dto.response.WalletResponseDto;
import com.example.moneymanagerbe.domain.dto.response.CommonResponseDto;
import com.example.moneymanagerbe.domain.entity.Wallet;

import java.util.List;

public interface WalletService {

    Wallet getById(String id);

    WalletResponseDto getWalletResponseDtoById(String id);

    WalletResponseDto createNewWallet(String userId, WalletRequestDto walletRequestDto);

    WalletResponseDto updateWalletName(String id, String name, String userId);

    WalletResponseDto updateWalletTotal(String id, float total, String userId);

    CommonResponseDto deleteWallet(String id, String userId);

    List<Wallet> getWalletsByUser(String userId);

    List<WalletResponseDto> getWalletsDtoByUser(String userId);

}
