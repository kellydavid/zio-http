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

sealed trait Server
sealed trait Path
sealed trait Components
sealed trait SecurityRequirement
sealed trait Tag
sealed trait ExternalDocumentation

object OpenApi {
  type Url = String
  type Email = String
}

case class Info(
                 title: String,
                 description: Option[String],
                 termsOfService: Option[String],
                 contact: Option[Info.Contact],
                 license: Option[Info.License],
                 version: String
               )

object Info {
  case class Contact(name: Option[String], url: Option[OpenApi.Url], email: Option[OpenApi.Email])
  case class License(name: String, url: Option[OpenApi.Url])
}
