package zio.http.doc.openapi

import OpenApi._
import Components._
import Info._
import Server._

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
                contact: Option[Contact],
                license: Option[License],
                version: String)

object Info {

  // MAY be extended with Specification Extensions
  case class Contact(name: Option[String],
                     url: Option[Url],
                     email: Option[Email])

  // MAY be extended with Specification Extensions
  case class License(name: String, url: Option[Url])

}

// MAY be extended with Specification Extensions
case class Server(url: Url,
                  description: Option[String],
                  variables: Map[String, ServerVariable])

object Server {

  // MAY be extended with Specification Extensions
  case class ServerVariable(enum: List[String],
                            default: String,
                            description: Option[String])

}

// MAY be extended with Specification Extensions
case class Components(schemas: ComponentsMap[Schema],
                      responses: ComponentsMap[Response],
                      parameters: ComponentsMap[Parameter],
                      examples: ComponentsMap[Example],
                      requestBodies: ComponentsMap[RequestBody],
                      headers: ComponentsMap[Header],
                      securityScheme: ComponentsMap[SecurityScheme],
                      links: ComponentsMap[Link],
                      callbacks: ComponentsMap[Callback])

object Components {
  type ComponentsKey = String // MUST match the regular expression: ^[a-zA-Z0-9\.\-_]+$ .
  type ComponentsMap[A] = Map[ComponentsKey, A]

  sealed trait Schema
  sealed trait Response
  sealed trait Parameter
  sealed trait Example
  sealed trait RequestBody
  sealed trait Header
  sealed trait SecurityScheme
  sealed trait Link
  sealed trait Callback

}