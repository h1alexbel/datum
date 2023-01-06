/*
MIT License
Copyright (c) 2023 Aliaksei Bialiauski
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

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
 * @since 0.0.1
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
            ServerResponse.ok().body(releases.flux(), CaReleases.class)
        )
        .build();
  }
}