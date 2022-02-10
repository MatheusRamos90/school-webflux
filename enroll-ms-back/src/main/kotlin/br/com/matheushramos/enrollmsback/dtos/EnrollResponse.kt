package br.com.matheushramos.enrollmsback.dtos

data class EnrollResponse(
    var id: String? = null,
    var course: CourseResponse? = null,
    var student: StudentResponse? = null,
    var inProgress: Boolean? = null,
    var createAt: String? = null,
    var updateAt: String? = null
)