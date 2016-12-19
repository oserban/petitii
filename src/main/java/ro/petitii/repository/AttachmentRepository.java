package ro.petitii.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ro.petitii.model.Attachment;

@Repository
public interface AttachmentRepository extends PagingAndSortingRepository<Attachment,Long> {
}