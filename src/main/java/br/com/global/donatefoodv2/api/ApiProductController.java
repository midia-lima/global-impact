package br.com.global.donatefoodv2.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.global.donatefoodv2.model.Company;
import br.com.global.donatefoodv2.repository.CompanyRepository;

@RestController
@RequestMapping("/api/product")
public class ApiProductController {

	@Autowired
	private CompanyRepository repository;

	@GetMapping
	@Cacheable("products")
	public Page<Company> index(@RequestParam(required = false) String corporate, @PageableDefault Pageable pageable) {
		if (corporate == null) {
			return repository.findAll(pageable);
		}
		return repository.findByCorporateContaining(corporate, pageable);
	}

	@PostMapping
	@CacheEvict(value = "products", allEntries = true)
	public ResponseEntity<Company> create(@RequestBody @Valid Company company, UriComponentsBuilder uriBuilder) {
		repository.save(company);
		URI uri = uriBuilder.path("/api/product/{id}").buildAndExpand(company.getId()).toUri();
		return ResponseEntity.created(uri).body(company);
	}

	@GetMapping("{id}")
	public ResponseEntity<Company> show(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id));
	}

	@DeleteMapping("{id}")
	@CacheEvict(value = "products", allEntries = true)
	public ResponseEntity<Company> destroy(@PathVariable Long id) {
		Optional<Company> company = repository.findById(id);
		if (company.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("{id}")
	@CacheEvict(value = "products", allEntries = true)
	public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company newCompany) {
		Optional<Company> optional = repository.findById(id);
		if (optional.isEmpty())
			return ResponseEntity.notFound().build();

		Company company = optional.get();

		company.setCorporate(newCompany.getCorporate());
		company.setCnpj(newCompany.getCnpj());
		company.setEmail(newCompany.getEmail());
		company.setQuantity(newCompany.getQuantity());
		company.setProduct(newCompany.getProduct());
		company.setContact(newCompany.getContact());

		repository.save(company);

		return ResponseEntity.ok(company);
	}

}
