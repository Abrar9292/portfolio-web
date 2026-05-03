package com.example.portfolio_web.controller;

import com.example.portfolio_web.entity.Portfolio;
import com.example.portfolio_web.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    // Save Portfolio
    @PostMapping("/create")
    public String createPortfolio(@RequestBody Portfolio portfolio) {

        portfolioRepository.save(portfolio);

        return "Portfolio Created Successfully";
    }

    // Get Portfolio by username
    @GetMapping("/{username}")
    public Portfolio getPortfolio(@PathVariable String username) {

        return portfolioRepository.findByUsername(username).orElse(null);
    }
}