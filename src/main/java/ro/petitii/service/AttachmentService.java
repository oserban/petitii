package ro.petitii.service;

import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;
import ro.petitii.model.Attachment;
import ro.petitii.model.Petition;
import ro.petitii.model.rest.RestAttachmentResponse;

import java.util.List;

public interface AttachmentService {
    // save and download from email BodyPart
    Attachment saveFromEmail(Attachment e);

    // save from webform
    List<Attachment> saveFromForm(MultipartFile[] files, Long petitionId);

    // save attachment to db
    Attachment save(Attachment e);

    // delete attachment
    void deleteFromDisk(Attachment attachment);

    // delete attachment from petition
    void deleteFromPetition(long attachmentId);

    // delete attachment from email
    void deleteFromEmail(long attachmentId);

    // get attachment by id
    Attachment findById(Long id);

    // get attachment table content for a petition
    RestAttachmentResponse getTableContent(Petition petition, int startIndex, int size, Sort.Direction sortDirection, String sortColumn);
}
