package com.Project.RealLifeProject;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    private final ProviderRepository providerRepository;

    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }


    @PostMapping
    public Provider createProvider(Provider provider){
        return providerRepository.save(provider);
    }

    @GetMapping
    public List<Provider> getAllProviders(){
        return providerRepository.findAll();
    }

    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable Long id , @RequestBody Provider updateProvider){
        Provider provider = providerRepository.findById(id).orElseThrow();
        provider.setAvailable(updateProvider.isAvailable());
        return providerRepository.save(provider);
    }
    
}