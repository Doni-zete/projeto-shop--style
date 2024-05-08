package br.shop.style.mspayment.controller;

import br.shop.style.mspayment.dto.request.InstallmentRequestDto;
import br.shop.style.mspayment.dto.response.InstallmentResponseDto;
import br.shop.style.mspayment.service.InstallmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/installments")
public class InstallmentController {

    private InstallmentService installmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstallmentResponseDto saveInstallment(@RequestBody InstallmentRequestDto installmentRequestDto) {
        return installmentService.create(installmentRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstallmentResponseDto updateInstallment(@RequestBody InstallmentRequestDto installmentRequestDto,
                                                    @PathVariable Long id) {
        return installmentService.update(installmentRequestDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInstallment(@PathVariable Long id) {
        installmentService.delete(id);
    }
}
