package com.mouad.Syntax.controller;

import com.mouad.Syntax.model.Admin;
import com.mouad.Syntax.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/admin/")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping("all")
    public List<Admin> getAll() {
        return service.getAdmins();
    }

    @GetMapping("{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return service.getAdmin(id);
    }

}
