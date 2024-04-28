package br.com.fiap.tech.challenge.api.agendamento.consultas.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@NoArgsConstructor
public class AssistantsPageResponse {

    private List<AssistantResponse> content;

    private Pageable pageable;

    private boolean last;

    private int totalElements;

    private int totalPages;

    private int size;

    private int number;

    private Sort sort;

    private boolean first;

    private int numberOfElements;

    private boolean empty;
}
