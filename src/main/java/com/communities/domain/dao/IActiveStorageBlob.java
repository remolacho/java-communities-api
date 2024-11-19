package com.communities.domain.dao;
import com.communities.domain.entities.ActiveStorageBlob;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IActiveStorageBlob extends CrudRepository<ActiveStorageBlob, Long> {
    @Query("SELECT b FROM ActiveStorageBlob b" +
            " JOIN ActiveStorageAttachment a ON a.blobId = b.id" +
            " WHERE a.recordId = :recordId AND a.recordType = :recordType AND a.name = :name")
    Optional<ActiveStorageBlob> findByRecordIdAndRecordType(long recordId, String recordType, String name);

    @Query("SELECT b FROM ActiveStorageBlob b" +
            " JOIN ActiveStorageAttachment a ON a.blobId = b.id" +
            " WHERE a.recordId = :recordId AND a.recordType = :recordType AND a.name = :name")
    List<ActiveStorageBlob> findByAllRecordIdAndRecordType(long recordId, String recordType, String name);
}
