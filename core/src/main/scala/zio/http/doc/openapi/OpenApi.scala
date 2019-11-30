package zio.http.doc.openapi

case class OpenApi(
                  openapi: String = "3.0.2",
                  info: Info,
                  servers: List[Server],
                  paths: List[Path],
                  components: Option[Components],
                  security: List[SecurityRequirement],
                  tags: List[Tag],
                  externalDocs: Option[ExternalDocumentation]
                  )

sealed trait Info
sealed trait Server
sealed trait Path
sealed trait Components
sealed trait SecurityRequirement
sealed trait Tag
sealed trait ExternalDocumentation