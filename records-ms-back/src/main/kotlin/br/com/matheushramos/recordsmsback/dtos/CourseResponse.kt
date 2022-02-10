package br.com.matheushramos.recordsmsback.dtos

import br.com.matheushramos.recordsmsback.enums.EnumStatus
import java.math.BigDecimal

data class CourseResponse(
    var id: String? = null,
    var name: String? = null,
    var price: BigDecimal? = null,
    var status: EnumStatus? = null,
    var createAt: String? = null,
    var updateAt: String? = null
)