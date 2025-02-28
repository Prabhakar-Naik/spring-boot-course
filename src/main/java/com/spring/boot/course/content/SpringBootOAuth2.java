package com.spring.boot.course.content;

/**
 * @author prabhakar, @Date 27-02-2025
 */

public class SpringBootOAuth2 {

    // OAuth2.0

    /*
        OAuth 2.0 (Open Authorization) is an industry-standard protocol for authorization
        that allows applications to securely access user data without exposing login
        credentials. It is widely used for authentication and authorization in modern
        web applications and APIs.

        Key Concepts in OAuth 2.0
            Resource Owner – The user who grants permission to access their data.
            Client – The application that wants to access the resource owner's data.
            Authorization Server – The server that authenticates the user and issues
            access tokens.
            Resource Server – The API or service that holds the user's data and
            requires authentication.

        OAuth 2.0 Flow (Grant Types)
        Authorization Code Flow (Most Secure)

        The user logs in via an authorization server.
        The client gets an authorization code.
        The client exchanges the code for an access token.
        The access token is used to access the resource.
        Client Credentials Flow (For Machine-to-Machine Auth)

        Used when there’s no user, only services communicating (e.g., backend-to-backend).
        The client directly gets an access token using its credentials.
        Implicit Flow (Deprecated)

        Tokens are directly issued via the browser (not recommended due to security risks).
        Password Grant Type (Deprecated)

        The user provides a username and password directly to the client (not recommended).
        Refresh Token Flow

        A refresh token is used to get a new access token without
        requiring user login again.

        OAuth 2.0 in Real-World Scenarios
        Google Login – Apps use OAuth 2.0 to authenticate users via Google.
        Microsoft Teams Integration – Uses OAuth 2.0 to grant permission to schedule meetings.
        API Access – Securely grant access to APIs without exposing credentials.

    */
}
