package br.shop.style.mspayment.controller;

import br.shop.style.mspayment.dto.request.InstallmentRequestDto;
import br.shop.style.mspayment.dto.response.InstallmentResponseDto;
import br.shop.style.mspayment.service.InstallmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/installments")
public class InstallmentController {

    private InstallmentService installmentService;

    @PostMapping
    public ResponseEntity<InstallmentResponseDto> saveInstallment(@RequestBody InstallmentRequestDto installmentRequestDto) {
        var response = installmentService.create(installmentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstallmentResponseDto> updateInstallment(@RequestBody InstallmentRequestDto installmentRequestDto,
                                                                    @PathVariable Long id) {
        var response = installmentService.update(installmentRequestDto, id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstallment(@PathVariable Long id) {
        installmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
