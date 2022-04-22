package com.joshbarros.springproviders.controllers;

import com.joshbarros.springproviders.dtos.ServiceDTO;
import com.joshbarros.springproviders.entities.Client;
import com.joshbarros.springproviders.entities.Service;
import com.joshbarros.springproviders.repositories.ClientRepository;
import com.joshbarros.springproviders.repositories.ServiceRepository;
import com.joshbarros.springproviders.utils.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ClientRepository clientRepository;
    private final ServiceRepository serviceRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Service save(@RequestBody @Valid ServiceDTO dto) {
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer clientId = dto.getClientId();

        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client doesnt exists!" ));

        Service service = new Service();
        service.setDescription(dto.getDescription());
        service.setDate(date);
        service.setClient(client);
        service.setPrice(bigDecimalConverter.convert(dto.getPrice()));

        return serviceRepository.save(service);
    }

    @GetMapping
    public List<Service> search(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "month", required = false) Integer month
    ) {
        return serviceRepository.findByClientNameAndMonth("%" + name + "%", month);
    }
}
