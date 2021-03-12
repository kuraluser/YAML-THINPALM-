/* Licensed at AlphaOri Technologies */
package com.cpdss.common.springdata;

import com.cpdss.common.utils.Doc;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

/**
 * Generic Common DAO spring data repository
 *
 * @author r.krishnakumar
 * @param <T>
 * @param <Long>
 */
@DependsOn("SpringDataConfig")
@NoRepositoryBean
public interface CommonCrudRepository<T extends Doc, Long> extends JpaRepository<T, Long> {

  <S extends T> S save(S entity);

  Optional<T> findById(Long primaryKey);

  List<T> findAll();

  List<T> findAll(Sort sort);

  Page<T> findAll(Pageable pageable);

  long count();

  void delete(T entity);

  boolean existsById(Long primaryKey);

  @Query("select t from #{#entityName} t where t.createdDateTime >= :createdDateTime")
  List<T> findAllByCreatedDate(@Param("createdDateTime") LocalDateTime createdDateTime);

  @Query("select t from #{#entityName} t where t.lastModifiedDateTime >= :lastModifiedDateTime")
  List<T> findAllByLastModifiedDate(
      @Param("lastModifiedDateTime") LocalDateTime lastModifiedDateTime);

  @Modifying
  @Query("delete from #{#entityName} t where t.id = ?1")
  void deleteById(Long id);

  @Query("select t from #{#entityName} t")
  List<T> findAllBySorted(Sort sort);
}
