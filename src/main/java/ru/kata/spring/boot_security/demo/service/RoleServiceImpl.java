package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.interfaces.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.interfaces.RoleService;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Set<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    public void addNewRole(Role role) {
        roleDao.addNewRole(role);
    }

    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    public Set<Role> findByIdRoles(List<Long> roles) {
        return roleDao.findByIdRoles(roles);
    }
}
