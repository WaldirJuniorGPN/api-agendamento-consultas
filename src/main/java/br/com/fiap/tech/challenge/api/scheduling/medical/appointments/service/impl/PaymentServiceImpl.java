package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.impl;

import br.com.fiap.tech.challenge.api.scheduling.medical.appointments.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void process() {
        log.info("Pagamento realizado com sucesso!");
    }
}
