package com.communities.app.services.attachable;

import com.communities.app.services.attachable.provider.IUrlService;
import com.communities.domain.dao.IActiveStorageBlob;
import com.communities.domain.entities.ActiveStorageBlob;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActiveStorage {
    private final IActiveStorageBlob attachBlobDao;
    private final IUrlService urlService;

    public ActiveStorage(IActiveStorageBlob attachBlobDao,
                         IUrlService urlService) {

        this.attachBlobDao = attachBlobDao;
        this.urlService = urlService;
    }

    public ActiveStorageBlob getAttachment(Long id, String recordType, String name) {
        return getBlob(id, recordType, name);
    }

    public List<ActiveStorageBlob> getAttachments(Long id, String recordType, String name) {
        return getBlobs(id, recordType, name);
    }

    public String getUrlResource(ActiveStorageBlob blob){
        return (blob != null) ? urlService.generateUrl(blob.getKey()) : "";
    }

    private ActiveStorageBlob getBlob(Long id, String recordType, String name){
        return attachBlobDao.findByRecordIdAndRecordType(id, recordType, name).orElse(null);
    }

    private List<ActiveStorageBlob> getBlobs(Long id, String recordType, String name){
        return attachBlobDao.findByAllRecordIdAndRecordType(id, recordType, name);
    }
}
