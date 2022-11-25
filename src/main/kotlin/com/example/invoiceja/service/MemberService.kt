package com.example.invoiceja.service
import com.example.invoiceas.model.Client
import com.example.invoiceas.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MemberService {
    @Autowired
    lateinit var memberRepository:ClientRepository

    fun list():List<Client>{
        return memberRepository.findAll()
    }

    fun save(client:Client):Client{
        return memberRepository.save(client)
    }

    fun updateName (client:Client):Client {
        try {
            val response= memberRepository.findById(client.id)
                ?: throw Exception("Id  existe")
            response.apply {
                fullname= client.fullname
            }
            return memberRepository.save(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}