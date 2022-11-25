package com.example.invoiceja.service
import com.example.invoiceas.model.Client
import com.example.invoiceas.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EventService {
    @Autowired
    lateinit var eventRepository:ClientRepository

    fun list():List<Client>{
        return eventRepository.findAll()
    }

    fun save(client:Client):Client{
        return eventRepository.save(client)
    }

    fun updateName (client:Client):Client {
        try {
            val response= eventRepository.findById(client.id)
                ?: throw Exception("Id  existe")
            response.apply {
                fullname= client.fullname
            }
            return eventRepository.save(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}