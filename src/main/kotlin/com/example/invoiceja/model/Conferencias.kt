package com.example.invoiceja.model
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence. *
import javax.validation.constraints.NotBlank

@Entity
@Table(name="conferencias")

class Conferencias {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotBlank(message= "obligatorio")
    var nui :String? = null
    @NotBlank (message= "Oblogatorio")
    var fullname:String? = null
    @NotBlank (message = "obligatorio")
    var address:String? = null
}