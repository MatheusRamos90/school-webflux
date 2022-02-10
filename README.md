# school-webflux
Este é um projeto criado com intuito de realizar estudos com o Spring WebFlux.
Por enquanto não foram realizados testes automatizados, mas serão feitos.
A ideia é ver o comportamento de chamadas assíncronas não bloqueantes com o WebFlux.

Tecnologias utilizadas:
Kotlin, Gradle, Spring Boot, Spring WebFlux, MongoDB

## enroll-ms-back
DTOS DB:
Enroll(id, course_id, student_id, in_progress, createAt, updateAt)

Endpoint que executa chamadas assícronas:
"/v1/enroll" (student_id, course_id)
- Se o aluno e o curso existirem no serviço de records, será gravado uma nova matrícula (enroll)

## records-ms-back
DTOS DB:
Student(id, name, email, number_document, password, status (ENUM - ONLINE, OFFLINE), createAt, updateAt)
Course(id, name, price, status (ENUM - ONLINE, OFFLINE), createAt, updateAt)

