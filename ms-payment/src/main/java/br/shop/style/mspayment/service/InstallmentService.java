package br.shop.style.mspayment.service;

import br.shop.style.mspayment.dto.request.InstallmentRequestDto;
import br.shop.style.mspayment.dto.response.InstallmentResponseDto;

public interface InstallmentService {
    InstallmentResponseDto create(InstallmentRequestDto installmentRequestDto);

    InstallmentResponseDto update(InstallmentRequestDto installmentRequestDto, Long id);

    void delete(Long id);
}
