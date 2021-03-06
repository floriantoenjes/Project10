package com.floriantoenjes.home.automation.device;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource()
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long> {

    @RestResource(rel = "search", path = "search")
    Page<Device> findByNameContaining(@Param("name") String name, Pageable page);
}
