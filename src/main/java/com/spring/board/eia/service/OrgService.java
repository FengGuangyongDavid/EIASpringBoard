package com.spring.board.eia.service;


import com.spring.board.eia.entity.Organization;

import java.util.List;

public interface OrgService {
    void createNewOrg(Organization org);
    List<Organization> getAllOrgs();
    void deleteOrg(String id);
    Organization editOrg(int id, Organization org);
}
