package com.mouad.Syntax.service;

import com.mouad.Syntax.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAdmins();
    Optional<Admin> getAdmin(Long id);
}
