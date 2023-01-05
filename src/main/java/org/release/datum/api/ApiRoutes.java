package org.release.datum.api;

import org.release.datum.model.Releases;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface ApiRoutes {

  RouterFunction<ServerResponse> release(Releases releases);

  RouterFunction<ServerResponse> flux(Releases releases);
}