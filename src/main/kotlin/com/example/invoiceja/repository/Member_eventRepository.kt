package com.example.invoiceja.repository
import com.example.invoiceas.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface Member_eventRepository {
    @Repository
    interface ClientRepository:JpaRepository<Client, Long> {
        fun findById(id: Long?): Client?
    }
}