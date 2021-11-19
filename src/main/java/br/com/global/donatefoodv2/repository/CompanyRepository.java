package br.com.global.donatefoodv2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.global.donatefoodv2.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	Page<Company> findByCorporateContaining(String corporate, Pageable pageable);

}
