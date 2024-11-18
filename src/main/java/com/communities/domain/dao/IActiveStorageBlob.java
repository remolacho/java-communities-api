package com.communities.domain.dao;
import com.communities.domain.entities.ActiveStorageAttachment;
import com.communities.domain.entities.ActiveStorageBlob;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IActiveStorageBlob extends CrudRepository<ActiveStorageBlob, Long> { }
