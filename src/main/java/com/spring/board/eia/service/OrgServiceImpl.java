package com.spring.board.eia.service;

import com.spring.board.eia.entity.Organization;
import com.spring.board.eia.entity.Person;
import com.spring.board.eia.repository.OrgRepository;
import com.spring.board.eia.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgRepository repository;

    @Override
    public void createNewOrg(Organization org) {
        repository.addPerson(org);
    }

    @Override
    public List<Organization> getAllOrgs() {
        return repository.findOrgs();
    }

    @Override
    public void deleteOrg(String id) {
        Organization org = repository.findOrgById(id);
        repository.deleteOrg(org);
    }

    @Override
    public Organization editOrg(int id, Organization org) {
        return null;
    }
}
