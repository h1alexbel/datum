package org.release.datum.model;

import java.util.UUID;
import org.release.datum.cassandra.CaRelease;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Releases {

  Mono<CaRelease> release(UUID id);

  Flux<CaRelease> flux();
}