package org.release.datum.api;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.release.datum.cassandra.CaRelease;
import org.release.datum.cassandra.ReleaseRepository;
import org.release.datum.model.Releases;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CaReleases implements Releases {

  private final ReleaseRepository repository;

  @Override
  public Mono<CaRelease> release(final UUID id) {
    return this.repository.findById(id);
  }

  @Override
  public Flux<CaRelease> flux() {
    return this.repository.findAll();
  }
}