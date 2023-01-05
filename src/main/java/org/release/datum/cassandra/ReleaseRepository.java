package org.release.datum.cassandra;

import java.util.UUID;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface ReleaseRepository extends ReactiveCassandraRepository<CaRelease, UUID> {
}