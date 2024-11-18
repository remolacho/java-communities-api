package com.communities.domain.dao;

import com.communities.domain.entities.ActiveStorageAttachment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IActiveStorageAttachment  extends CrudRepository<ActiveStorageAttachment, Long> {
    @Query("SELECT a FROM ActiveStorageAttachment a WHERE a.recordId = :recordId AND a.recordType = :recordType AND a.name = :name")
    Optional<ActiveStorageAttachment> findByRecordIdAndRecordType(long recordId, String recordType, String name);
}
