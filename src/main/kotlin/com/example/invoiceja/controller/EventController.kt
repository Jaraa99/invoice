package com.example.invoiceja.controller
import com.example.facturasapi.service.ClientService
import com.example.invoiceas.model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/event")
class EventController {
    @Autowired
    lateinit var eventService: ClientService

    @GetMapping
    fun list(): List<Client> {
        return eventService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid client: Client): ResponseEntity<Client> {
        return ResponseEntity(eventService.save(client), HttpStatus.OK)
    }


    @PutMapping
    fun update(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(eventService.updateName(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(eventService.updateName(client), HttpStatus.OK)
    }
}
