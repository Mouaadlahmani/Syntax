package com.mouad.Syntax.service.impl;

import com.mouad.Syntax.model.Admin;
import com.mouad.Syntax.repository.AdminRepository;
import com.mouad.Syntax.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {


    private final AdminRepository adminRepository;

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdmin(Long id) {
        return adminRepository.findById(id);
    }
}
