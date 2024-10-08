package com.mouad.syntax.service;

import com.mouad.syntax.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAdmins();
    Optional<Admin> getAdmin(Long id);
}
