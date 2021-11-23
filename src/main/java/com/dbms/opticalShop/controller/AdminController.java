package com.dbms.opticalShop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbms.opticalShop.dto.BrandDTO;
import com.dbms.opticalShop.dto.SpectaclesDTO;
import com.dbms.opticalShop.model.AdminLog;
import com.dbms.opticalShop.model.Brand;
import com.dbms.opticalShop.model.Spectacles;
import com.dbms.opticalShop.model.User;
import com.dbms.opticalShop.service.AdminLogService;
import com.dbms.opticalShop.service.BrandService;
import com.dbms.opticalShop.service.SpectaclesService;
import com.dbms.opticalShop.service.UserService;

@Controller
public class AdminController {
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	SpectaclesService spectaclesService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AdminLogService adminLogService;
	
	@GetMapping("/admin")
	public String adminHome(){
		return "adminHome";
	}
	
	@GetMapping("/admin/logs")
	public String adminLogs(Model model){
		List<AdminLog> adminLogs=adminLogService.getAllAdminLogs();
		model.addAttribute("adminLogs",adminLogs);
		return "adminLogs";
	}
	
	@GetMapping("/admin/brands")
	public String getBrands(Model model) {
		List<Brand> brands=brandService.getAllBrands();
		List<BrandDTO> brandDTOs=new ArrayList<BrandDTO>();
		
		for (int i = 0; i < brands.size(); i++) {
			BrandDTO brandDTO = new BrandDTO();
			
			int modelCount=spectaclesService.getAllSpectaclesByBrandId(brands.get(i).getId()).size();
			brandDTO.setId(brands.get(i).getId());
			brandDTO.setName(brands.get(i).getName());
			brandDTO.setCostLevel(brands.get(i).getCostLevel());
			brandDTO.setModelsCount(modelCount);
			
			brandDTOs.add(brandDTO);
		}
		model.addAttribute("brands", brandDTOs);
		return "brands";
	}
	
	@GetMapping("/admin/brands/add")
	public String brandsAdd(Model model) {
		model.addAttribute("brand",new Brand());
		return "brandsAdd";
	}
	
	@PostMapping("/admin/brands/add")
	public String postBrandAdd(@ModelAttribute("brand") Brand brand) {
		brandService.addBrand(brand);
		
//		AdminLog adminLog = new AdminLog();
//		adminLog.setName("UPDATED BRANDS");
//		adminLog.setActionDate(new Date());
//		adminLogService.addLog(adminLog);
//		
		return "redirect:/admin/brands";
	}
	
	@GetMapping("/admin/brands/delete/{id}")
	public String deleteBrand(@PathVariable("id") int id,Model model) {
		
		boolean zeroSpectacles=spectaclesService.getAllSpectaclesByBrandId(id).isEmpty();
		
		System.out.println("ZeroSpectacles: "+zeroSpectacles);
		String brand = "shreyas";
		brand= brandService.getBrandById(id).get().getName();
		model.addAttribute("brand",brand);
		if(zeroSpectacles==false) {
			return "thisBrandHasSpecs";
		}
		
//		AdminLog adminLog = new AdminLog();
//		adminLog.setName("DELETED BRAND");
//		adminLog.setActionDate(new Date());
//		adminLogService.addLog(adminLog);
//		
		brandService.removeBrandById(id);
		return "redirect:/admin/brands";
	}
	
	@GetMapping("/admin/brands/update/{id}")
	public String updateBrand(@PathVariable int id,Model model) {
		Optional<Brand> brand = brandService.getBrandById(id);
		if(brand.isPresent())
		{
			model.addAttribute("brand", brand.get());
			return "brandsAdd";
		}
		else
			return "404";
	}
	
	// Spectacles
	
	@GetMapping("/admin/spectacles")
	public String getSpectacles(Model model) {
		model.addAttribute("spectacles", spectaclesService.getAllSpectacles());
		return "spectacles";
	}
	
	@GetMapping("/admin/spectacles/add")
	public String addSpectacles(Model model) {
		model.addAttribute("spectaclesDTO", new SpectaclesDTO());
		model.addAttribute("brands", brandService.getAllBrands());
		return "spectaclesAdd";
	}
	
	@PostMapping("/admin/spectacles/add")
	public String spectaclesAddPost(@ModelAttribute("SpectaclesDTO") SpectaclesDTO spectaclesDTO) {
		Spectacles spectacles= new Spectacles();
		spectacles.setId(spectaclesDTO.getId());
		spectacles.setName(spectaclesDTO.getName());
		spectacles.setBrand(brandService.getBrandById(spectaclesDTO.getBrandId()).get());
		spectacles.setPrice(spectaclesDTO.getPrice());
		spectacles.setInStockCount(spectaclesDTO.getInStockCount());
		
//		String imageUUID;
//		if(!file.isEmpty())
//		{
//			imageUUID = file.getOriginalFilename();
//			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
//			System.out.println(uploadDir);
//			Files.write(fileNameAndPath, file.getBytes());
//		} else {
//			imageUUID = imgName;
//		}
//		@RequestParam("spectaclesImage")MultipartFile file,
//		@RequestParam("imgName")String imgName) throws IOException 
		spectacles.setImageName("image");
		spectaclesService.addSpectacles(spectacles);
		
		AdminLog adminLog = new AdminLog();
		adminLog.setName("UPDATED SPECTACLES");
		adminLog.setActionDate(new Date());
		adminLogService.addLog(adminLog);
		
		return "redirect:/admin/spectacles";
	}
	
	@GetMapping("/admin/spectacles/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		spectaclesService.removeSpectaclesById(id);
		
		AdminLog adminLog = new AdminLog();
		adminLog.setName("DELETED SPECTACLE");
		adminLog.setActionDate(new Date());
		adminLogService.addLog(adminLog);
		
		return "redirect:/admin/spectacles";
	}
	
	@GetMapping("/admin/spectacles/update/{id}")
	public String updateProduct(@PathVariable int id,Model model) {
		Spectacles spectacles= spectaclesService.getSpectaclesById(id).get();
		SpectaclesDTO spectaclesDTO= new SpectaclesDTO();
		
		spectaclesDTO.setId(spectacles.getId());
		spectaclesDTO.setName(spectacles.getName());
		spectaclesDTO.setBrandId(spectacles.getBrand().getId());
		spectaclesDTO.setPrice(spectaclesDTO.getPrice());
		spectaclesDTO.setInStockCount(spectacles.getInStockCount());
		spectaclesDTO.setImageName(spectacles.getImageName());
		
		
		model.addAttribute("brands",brandService.getAllBrands());
		model.addAttribute("spectaclesDTO", spectaclesDTO);
		
		return "spectaclesAdd";
	}
	
	///////////////////////////////////////////////////////////
	
	@GetMapping("/admin/users")
	public String getUsers(Model model) {
		List<User> users=userService.getAllUsers();
	     for (int i = 0; i < users.size(); i++) {
	    	 if(users.get(i).getRoles().get(0).getId()==1) {
	    		 users.remove(i);
	    	 }
	    }
		model.addAttribute("users",users);
		return "usersView";
	}
	
	@GetMapping("/admin/users/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		
		
		//System.out.println("user deleted");
		AdminLog adminLog = new AdminLog();
		adminLog.setName("DELETED USER");
		adminLog.setActionDate(new Date());
		adminLogService.addLog(adminLog);
		
		userService.removeUserById(id);
		return "redirect:/admin/users";
	}
}
