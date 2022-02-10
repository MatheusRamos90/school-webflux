package br.com.matheushramos.recordsmsback.models

import br.com.matheushramos.recordsmsback.enums.EnumStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.*

@Document
data class Student(
    @Id
    var id: String? = null,

    var name: String? = null,
    var email: String? = null,
    var numberDocument: String? = null,
    var password: String? = null,
    var status: EnumStatus? = null,
    var createAt: Date? = Date.from(Instant.now()),
    var updateAt: Date? = null
)