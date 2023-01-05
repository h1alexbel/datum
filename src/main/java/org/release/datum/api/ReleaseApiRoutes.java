package org.release.datum.api;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.release.datum.cassandra.CaRelease;
import org.release.datum.model.Releases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class ReleaseApiRoutes implements ApiRoutes {

  @Bean
  @Override
  public RouterFunction<ServerResponse> release(final Releases releases) {
    return RouterFunctions.route()
        .GET("/api/releases/v1/{id}", rq ->
            ServerResponse.ok().body(
                releases.release(UUID.fromString(rq.pathVariable("id"))),
                CaRelease.class
            )
        )
        .build();
  }

  @Bean
  @Override
  public RouterFunction<ServerResponse> flux(final Releases releases) {
    return RouterFunctions.route()
        .GET("/api/releases/v1", rq ->
            ServerResponse.ok().body(releases.flux(), CaReleases.class))
        .build();
  }
}