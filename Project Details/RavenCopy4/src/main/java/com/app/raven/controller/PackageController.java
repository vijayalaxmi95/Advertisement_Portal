package com.app.raven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.raven.model.Customer;
import com.app.raven.model.PackageDetails;
import com.app.raven.service.PackageServicable;
import com.app.raven.utils.Sorter;

@CrossOrigin("*")
@RestController
public class PackageController {
	@Autowired
	private PackageServicable packageSer;
//	private CustomerServicable custSer;
	private Sorter sort;

	public PackageController(PackageServicable packageSer/* , CustomerServicable custSer */) {
		this.packageSer = packageSer;
//		this.custSer = custSer;
		this.sort = new Sorter();
	}

	@PostMapping("/add1package")
	public PackageDetails addPackage(@RequestBody PackageDetails packNew) {
		packNew.setpLogo(sort.urlSorter(packNew.getpLogo()));
		this.packageSer.savePackage(packNew);
		return packNew;
	}

	/*
	 * Get the list of all the Packages
	 */
	@GetMapping("/allpackage")
	public List<PackageDetails> getPackageList() {
		return this.packageSer.findAllPackages();
	}

	// Method to find Package by Id
	@PostMapping("/getpackage/{package_id}")
	public PackageDetails getPackageById(@PathVariable Long package_id) {
		return this.packageSer.findPackageByID(package_id);
	}

	// Method to update Package Details
	@PostMapping("/updatepackage")
	public PackageDetails updatePackage(@RequestBody PackageDetails pack) {
		pack.setpLogo(sort.urlSorter(pack.getpLogo()));
		System.out.println("in update product " + pack.getId() + " product : " + pack);
		return this.packageSer.updatePackage(pack);
	}

	@PostMapping("/delete1package/{pack_id}")
	public PackageDetails delete1Package(@PathVariable Long pack_id) {
		PackageDetails pack = this.packageSer.findPackageByID(pack_id);
		for(Customer c : pack.getAllSubscribers()) {
			c.setPack(null);
		}
		return this.packageSer.deletePackage(pack_id);
	}
}
