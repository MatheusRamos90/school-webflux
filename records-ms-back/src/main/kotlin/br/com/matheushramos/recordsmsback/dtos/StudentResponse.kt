package br.com.matheushramos.recordsmsback.dtos

import br.com.matheushramos.recordsmsback.enums.EnumStatus

data class StudentResponse(
    var id: String? = null,
    var name: String? = null,
    var email: String? = null,
    var numberDocument: String? = null,
    var status: EnumStatus? = null,
    var createAt: String? = null,
    var updateAt: String? = null
)