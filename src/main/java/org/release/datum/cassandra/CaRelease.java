package org.release.datum.cassandra;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.release.datum.model.Release;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("releases")
public class CaRelease implements Release {

  @PrimaryKey
  private UUID id;
  private String repo;
  private String owner;
  private String tag;
  private String title;
  private String body;

  @Override
  public String coordinates() {
    return this.owner + "/" + this.repo;
  }

  @Override
  public String body() {
    return this.body;
  }
}