package ro.petitii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.petitii.model.Petition;
import ro.petitii.model.PetitionStatus;
import ro.petitii.model.User;
import ro.petitii.repository.PetitionStatusRepository;

import java.util.Date;

@Service
public class PetitionStatusServiceImpl implements PetitionStatusService {
    @Autowired
    private PetitionStatusRepository petitionStatusRepository;

    @Autowired
    private PetitionService petitionService;

    // private method, not for external use
    private PetitionStatus save(PetitionStatus petitionStatus) {
        return petitionStatusRepository.save(petitionStatus);
    }

    @Override
    public PetitionStatus create(PetitionStatus.Status status, Petition petition, User user) {
        petition.setCurrentStatus(status);
        petitionService.save(petition); // how was this not needed until now?
        PetitionStatus petitionStatus = new PetitionStatus();
        petitionStatus.setDate(new Date());
        petitionStatus.setPetition(petition);
        petitionStatus.setUser(user);
        petitionStatus.setStatus(status);
        this.save(petitionStatus);
        return petitionStatus;
    }
}
