# OAuth 2.0 – The Authorization Framework

## 1.1 Roles

OAuth 2.0 defines four roles:

### 1. Resource Owner
- An entity capable of granting access to a protected resource.
- When the resource owner is a person, it is referred to as an end-user.

### 2. Resource Server
- The server hosting the protected resources.
- It accepts and responds to protected resource requests using access tokens.

### 3. Client
- An application making protected resource requests on behalf of the resource owner and with their authorization.
- The client can be a web application, mobile application, desktop application, or server-side application.

### 4. Authorization Server
- The server that issues access tokens to the client.
- It authenticates the resource owner and obtains authorization before issuing access tokens.

**Important Points:**
- The Authorization Server and Resource Server can be the same server or separate entities.
- A single Authorization Server can issue access tokens accepted by multiple Resource Servers.

## 1.2 OAuth 2.0 Protocol Flow

### Textual Diagram

      +--------+                               +---------------+
      |        |--(A)- Authorization Request ->|   Resource    |
      |        |                               |     Owner     |
      |        |<-(B)-- Authorization Grant ---|               |
      |        |                               +---------------+
      |        |
      |        |                               +---------------+
      |        |--(C)-- Authorization Grant -->| Authorization |
      | Client |                               |     Server    |
      |        |<-(D)----- Access Token -------|               |
      |        |                               +---------------+
      |        |
      |        |                               +---------------+
      |        |--(E)----- Access Token ------>|    Resource   |
      |        |                               |     Server    |
      |        |<-(F)--- Protected Resource ---|               |
      +--------+                               +---------------+

### Explanation of the Flow

**(A) Authorization Request**
- The Client requests authorization from the Resource Owner.
- The request can be made directly or indirectly through the Authorization Server.

**(B) Authorization Grant**
- The Client receives an Authorization Grant.
- An Authorization Grant represents the Resource Owner's authorization to access protected resources.

**(C) Authorization Grant to Authorization Server**
- The Client sends the Authorization Grant to the Authorization Server.
- The Client authenticates itself when required.

**(D) Access Token**
- The Authorization Server validates the Authorization Grant.
- If valid, it issues an Access Token to the Client.

**(E) Access Token to Resource Server**
- The Client sends a request to the Resource Server.
- The Client includes the Access Token to access the protected resource.

**(F) Protected Resource**
- The Resource Server validates the Access Token.
- If valid, it provides the requested protected resource.

## 1.3 Authorization Grant

An Authorization Grant is a credential representing the Resource Owner's authorization.

The Client uses this grant to obtain an Access Token.

OAuth 2.0 RFC 6749 defines four grant types:

### 1. Authorization Code
- The Client redirects the Resource Owner to the Authorization Server.
- The Authorization Server authenticates the Resource Owner and obtains authorization.
- The Authorization Server sends an Authorization Code back to the Client.
- The Client exchanges the Authorization Code for an Access Token.

**Important:** The Resource Owner's credentials are never shared with the Client.

### 2. Implicit
- A simplified flow originally designed for browser-based applications.
- The Client receives an Access Token directly instead of an Authorization Code.
- It has security limitations and is no longer recommended for modern applications.

### 3. Resource Owner Password Credentials
- The Client directly uses the Resource Owner's username and password to obtain an Access Token.
- It was intended only for highly trusted applications.
- It is deprecated in modern OAuth security practices.

### 4. Client Credentials
- The Client uses its Client ID and Client Secret to obtain an Access Token.
- It is generally used for service-to-service communication.
- The Client acts on its own behalf rather than on behalf of an end-user.

## 1.4 Access Token

- An Access Token is a credential used to access protected resources.
- It represents authorization granted to the Client.
- It has specific scopes and durations of access.
- The Resource Server validates the token before providing access.
- Access Tokens can have different formats and structures.

## 1.5 Refresh Token

- A Refresh Token is a credential used to obtain new Access Tokens.
- It is issued by the Authorization Server.
- It is used when the current Access Token expires or becomes invalid.
- Issuing a Refresh Token is optional.
- Refresh Tokens are intended only for use with Authorization Servers.
- Refresh Tokens are never sent to Resource Servers.

### Refresh Token Flow – Textual Diagram

      +--------+                                           +---------------+
      |        |--(A)------- Authorization Grant --------->|               |
      |        |                                           |               |
      |        |<-(B)----------- Access Token -------------|               |
      |        |               & Refresh Token             |               |
      |        |                                           |               |
      |        |                            +----------+   |               |
      |        |--(C)---- Access Token ---->|          |   |               |
      |        |                            |          |   |               |
      |        |<-(D)- Protected Resource --| Resource |   | Authorization |
      | Client |                            |  Server  |   |     Server    |
      |        |--(E)---- Access Token ---->|          |   |               |
      |        |                            |          |   |               |
      |        |<-(F)- Invalid Token Error -|          |   |               |
      |        |                            +----------+   |               |
      |        |                                           |               |
      |        |--(G)----------- Refresh Token ----------->|               |
      |        |                                           |               |
      |        |<-(H)----------- Access Token -------------|               |
      +--------+           & Optional Refresh Token        +---------------+

### Explanation of Refresh Token Flow

**(A) Authorization Grant**
- The Client requests an Access Token by presenting an Authorization Grant.

**(B) Token Generation**
- The Authorization Server validates the grant.
- If valid, it issues an Access Token and optionally a Refresh Token.

**(C) Resource Request**
- The Client sends the Access Token to the Resource Server.

**(D) Resource Access**
- The Resource Server validates the Access Token.
- If valid, it provides the requested resource.

**(E) Repeated Requests**
- The Client continues sending requests using the Access Token until it expires.

**(F) Invalid Token Error**
- When the Access Token expires or becomes invalid, the Resource Server returns an invalid token error.

**(G) Refresh Token Request**
- The Client sends the Refresh Token to the Authorization Server to obtain a new Access Token.

**(H) New Token Generation**
- The Authorization Server validates the Refresh Token.
- If valid, it issues a new Access Token and optionally a new Refresh Token.

## 1.6 TLS Version

- OAuth 2.0 uses Transport Layer Security (TLS) to secure communication.
- The appropriate TLS version depends on current security requirements and known vulnerabilities.
- Secure communication protects sensitive information exchanged between components.

## 1.7 HTTP Redirections

- OAuth 2.0 uses HTTP redirections to redirect the Resource Owner's user agent between the Client and Authorization Server.
- HTTP 302 is one example of a redirection response.

## 1.8 Interoperability

- OAuth 2.0 provides a flexible and extensible authorization framework.
- It supports different authorization grant types and implementations.
- Additional specifications and extensions help achieve interoperability between different systems.

## 1.9 Notational Conventions

OAuth 2.0 specifications use the following keywords:

- MUST
- MUST NOT
- REQUIRED
- SHOULD
- SHOULD NOT
- RECOMMENDED
- MAY
- OPTIONAL

These keywords define the requirements and recommendations for implementing the protocol.

---

## Official Reference

RFC 6749 – The OAuth 2.0 Authorization Framework

https://datatracker.ietf.org/doc/html/rfc6749

