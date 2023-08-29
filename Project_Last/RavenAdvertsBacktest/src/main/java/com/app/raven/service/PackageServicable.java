package com.app.raven.service;

import java.util.List;

import com.app.raven.dto.PackageDTO;
//import com.app.raven.dto.PackageDTO;
import com.app.raven.model.PackageDetails;

public interface PackageServicable {
	PackageDetails savePackage(PackageDTO pack);
	
	PackageDetails savePackage(PackageDetails pack);

	PackageDetails updatePackage(PackageDetails updatePack);

	List<PackageDetails> findAllPackages();

	PackageDetails findPackageByID(Long id);

	PackageDetails deletePackage(Long id);

}
