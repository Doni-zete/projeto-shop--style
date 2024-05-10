package br.shop.style.mspayment.mapper;

import br.shop.style.mspayment.dto.request.InstallmentRequestDto;
import br.shop.style.mspayment.dto.response.InstallmentResponseDto;
import br.shop.style.mspayment.entity.Installment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstallmentMapper {

    @Mapping(source = "payment.id", target = "paymentId")
    InstallmentResponseDto installmentToInstallmentResponseDto(Installment payment);

    Installment installmentRequestDtoToInstallment(InstallmentRequestDto paymentResponseDto);
}
