package com.communities.app.services.attachable;

import com.communities.app.services.attachable.provider.IUrlService;
import com.communities.domain.dao.IActiveStorageAttachment;
import com.communities.domain.dao.IActiveStorageBlob;
import com.communities.domain.entities.ActiveStorageAttachment;
import com.communities.domain.entities.ActiveStorageBlob;
import org.springframework.stereotype.Component;

@Component
public class ActiveStorage {
    private final IActiveStorageAttachment activeStorageAttachmentDao;
    private final IActiveStorageBlob attachBlobDao;
    private final IUrlService urlService;

    public ActiveStorage(IActiveStorageAttachment activeStorageAttachmentDao,
                         IActiveStorageBlob attachBlobDao,
                         IUrlService urlService) {

        this.activeStorageAttachmentDao = activeStorageAttachmentDao;
        this.attachBlobDao = attachBlobDao;
        this.urlService = urlService;
    }

    public ActiveStorageBlob getAttachment(Long id, String recordType, String name) {
        return getBlob(id, recordType, name);
    }

    public String getUrlResource(Long id, String recordType, String name){
        ActiveStorageBlob blob = getBlob(id, recordType, name);
        return (blob != null) ? urlService.generateUrl(blob.getKey()) : "";
    }

    private ActiveStorageBlob getBlob(Long id, String recordType, String name){
        ActiveStorageAttachment attachment = activeStorageAttachmentDao.findByRecordIdAndRecordType(id, recordType, name)
                .orElse(null);

        if (attachment == null){
            return null;
        }

        return attachBlobDao.findById(attachment.getBlobId()).orElse(null);
    }
}
