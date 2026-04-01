package org.example.jwt_practice.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.SneakyThrows;
import org.example.jwt_practice.model.entity.AppUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
@SecurityRequirement(name = "bearerAuth")
@PreAuthorize("hasRole('ADMIN')")
public class ProductController {

    @GetMapping
    public String getAllProducts() {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userFullName = appUser.getFullName();
        return "Product returned! user full name : " + userFullName;
    }

}
