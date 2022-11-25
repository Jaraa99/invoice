package com.example.invoiceja.service
import com.example.invoiceas.model.Client
import com.example.invoiceas.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
@Service
class Member_eventService {
    @Autowired
    lateinit var member_eventRepository:ClientRepository

    fun list():List<Client>{
        return member_eventRepository.findAll()
    }

    fun save(client:Client):Client{
        return member_eventRepository.save(client)
    }

    fun updateName (client:Client):Client {
        try {
            val response= member_eventRepository.findById(client.id)
                ?: throw Exception("Id  existe")
            response.apply {
                fullname= client.fullname
            }
            return member_eventRepository.save(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

}