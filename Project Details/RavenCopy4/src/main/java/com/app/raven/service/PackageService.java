package com.app.raven.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raven.dto.PackageDTO;
import com.app.raven.model.PackageDetails;
import com.app.raven.repository.PackageRepository;

@Service
@Transactional
public class PackageService implements PackageServicable {

	@Autowired
	PackageRepository packageRepo;
	
	@Autowired
	private ModelMapper mapper;

	public PackageService(PackageRepository packageRepo) {
		this.packageRepo = packageRepo;
	}

	@Override
	public PackageDetails savePackage(PackageDetails pack) {
		packageRepo.save(pack);
		return pack;
	}

	@Override
	public PackageDetails updatePackage(PackageDetails updatePack) {
		PackageDetails pack = this.packageRepo.findById(updatePack.getId()).orElse(null);
		if(pack != null) {
			pack.setPName(updatePack.getPName());
			pack.setPCost(updatePack.getPCost());
			pack.setPValidity(updatePack.getPValidity());
			pack.setpLogo(updatePack.getpLogo());
			this.packageRepo.save(pack);
		}else {
			System.out.println("The Product is not persistant");
		}
		
		return pack;
	}

	@Override
	public List<PackageDetails> findAllPackages() {
		return packageRepo.findAll();
	}

	@Override
	public PackageDetails findPackageByID(Long id) {
		return packageRepo.findById(id).orElse(null);
	}

	@Override
	public PackageDetails deletePackage(Long id) {
		PackageDetails pack = packageRepo.findById(id).orElse(null);
		if(pack != null)
		{
			packageRepo.deleteById(id);
		}
		else
			System.out.println("The package is not found in the repository.");

		return pack;
	}
	
	@Override
	public PackageDetails savePackage(PackageDTO pack) {
	PackageDetails newPackage=mapper.map(pack, PackageDetails.class);
	packageRepo.save(newPackage);
	return newPackage;


}
	}
