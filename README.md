## Reactive paradigm in Spring - Reactive streams

Servlet

* IO is blocking
* thread-per-request
* thread is blocked until the response is ready

OS networking layer is asynchronous,
so it can be used.

Non-blocking

* thread is never blocked, should do work whenever possible
* event-driven architecture

Foundations

* Reactive Streams Specification (reactive-streams.org)
* publisher and consumer
* backpressure - consumer can indicate to
  producer, how much data it can handle

Spring WebFlux

* new runtime
* alternative to Spring MVC and Servlet
* ideally runs on a non-blocking runtime (Netty)

Publishers

* Mono - can produce one value
* Flux - can produce infinite amount of values
* Subscriber controls the data flow (backpressure)
* 2 programming models - annotations, functional

## Spring Security

* based on standard Servlet filters - intercepts HTTP requests before delegating to a Servle
* there is a filter chain, Spring Security provides one of the filters
    * DelegatingFilterProxy - delegates to FilterChainProxy (Spring managed bean)
        * internally contains another chain of filters - authentication, session management, exception handling, etc.
* all authenticaion info is stored in SecurityContext - thread-local per request
    * ```SecurityContextHolder.getContext().getAuthentication()```
* passwords are stored and encoded using PasswordEncoder
    * BCryptPasswordEncoder - secure, adds random salt before hashing
