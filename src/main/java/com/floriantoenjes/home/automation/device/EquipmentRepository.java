package com.floriantoenjes.home.automation.device;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface EquipmentRepository extends PagingAndSortingRepository<Device, Long> {
}
