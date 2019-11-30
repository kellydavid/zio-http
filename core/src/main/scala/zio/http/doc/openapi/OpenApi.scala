package zio.http.doc.openapi

// MAY be extended with Specification Extensions
case class OpenApi(openapi: String = "3.0.2",
                   info: Info,
                   servers: List[Server],
                   paths: List[Path],
                   components: Option[Components],
                   security: List[SecurityRequirement],
                   tags: List[Tag],
                   externalDocs: Option[ExternalDocumentation])

sealed trait Path
sealed trait Components
sealed trait SecurityRequirement
sealed trait Tag
sealed trait ExternalDocumentation

object OpenApi {
  type Url = String
  type Email = String
}

// MAY be extended with Specification Extensions
case class Info(title: String,
                description: Option[String],
                termsOfService: Option[String],
                contact: Option[Info.Contact],
                license: Option[Info.License],
                version: String)

object Info {

  // MAY be extended with Specification Extensions
  case class Contact(name: Option[String],
                     url: Option[OpenApi.Url],
                     email: Option[OpenApi.Email])

  // MAY be extended with Specification Extensions
  case class License(name: String, url: Option[OpenApi.Url])

}

// MAY be extended with Specification Extensions
case class Server(url: OpenApi.Url,
                  description: Option[String],
                  variables: Map[String, Server.ServerVariable])

object Server {

  // MAY be extended with Specification Extensions
  case class ServerVariable(enum: List[String],
                            default: String,
                            description: Option[String])

}