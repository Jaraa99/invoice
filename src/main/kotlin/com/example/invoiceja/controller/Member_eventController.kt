package com.example.invoiceja.controller
import com.example.invoiceas.model.Client
import com.example.invoiceja.service.MemberService
import com.example.invoiceja.service.Member_eventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/member_event")

class Member_eventController {
    @Autowired
    lateinit var member_eventService: Member_eventService

    @GetMapping
    fun list(): List<Client> {
        return member_eventService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid client: Client): ResponseEntity<Client> {
        return ResponseEntity(member_eventService.save(client), HttpStatus.OK)
    }


    @PutMapping
    fun update(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(member_eventService.updateName(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody client: Client): ResponseEntity<Client> {
        return ResponseEntity(member_eventService.updateName(client), HttpStatus.OK)
    }
}