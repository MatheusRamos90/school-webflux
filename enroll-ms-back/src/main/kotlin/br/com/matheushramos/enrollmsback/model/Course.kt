package br.com.matheushramos.enrollmsback.model

import br.com.matheushramos.recordsmsback.enums.EnumStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Document
data class Course(
    @Id
    var id: String? = null,

    var name: String? = null,
    var price: BigDecimal? = null,
    var status: EnumStatus? = null,
    var createAt: Date? = Date.from(Instant.now()),
    var updateAt: Date? = null
)