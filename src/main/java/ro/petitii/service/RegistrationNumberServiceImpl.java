package ro.petitii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.petitii.config.RegNoConfig;
import ro.petitii.model.RegistrationNo;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class RegistrationNumberServiceImpl implements RegistrationNumberService {
    @Autowired
    private RegNoConfig config;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public RegistrationNo generate() {
        RegistrationNo registrationNo = new RegistrationNo();
        registrationNo.setDate(new Date());
        em.persist(registrationNo);
        registrationNo.setNumber(String.format(config.getPattern(),registrationNo.getId()));
        return registrationNo;
    }

    @Override
    public RegistrationNo findById(long id) {
        return em.find(RegistrationNo.class, id);
    }
}
