package br.com.matheushramos.enrollmsback.extension

import br.com.matheushramos.enrollmsback.dtos.CourseResponse
import br.com.matheushramos.enrollmsback.dtos.EnrollPostRequest
import br.com.matheushramos.enrollmsback.dtos.EnrollResponse
import br.com.matheushramos.enrollmsback.dtos.StudentResponse
import br.com.matheushramos.enrollmsback.model.Enroll
import reactor.core.publisher.Mono

fun Enroll.toResponse(): EnrollResponse {
    return EnrollResponse(
        id = this.id,
        student = this.student,
        course = this.course,
        inProgress = this.inProgress,
        createAt = this.createAt.toString(),
        updateAt = this.updateAt.toString()
    )
}

fun EnrollPostRequest.toModel(student: StudentResponse, course: CourseResponse): Enroll {
    return Enroll(
        student = student,
        course = course,
        inProgress = true
    )
}

fun Mono<StudentResponse>.toDTO(student: StudentResponse?): StudentResponse {
    return StudentResponse(
        id = student?.id,
        name = student?.name,
        email = student?.email,
        numberDocument = student?.numberDocument,
        status = student?.status,
        createAt = student?.createAt.toString(),
        updateAt = student?.updateAt.toString()
    )
}

fun Mono<CourseResponse>.toDTO(course: CourseResponse?): CourseResponse {
    return CourseResponse(
        id = course?.id,
        name = course?.name,
        price = course?.price,
        status = course?.status,
        createAt = course?.createAt.toString(),
        updateAt = course?.updateAt.toString()
    )
}