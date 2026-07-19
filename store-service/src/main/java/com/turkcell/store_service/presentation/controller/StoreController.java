package com.turkcell.store_service.presentation.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.store_service.application.dto.StoreResponse;
import com.turkcell.store_service.application.service.StoreApplicationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/stores")
@Validated
@Tag(name = "Stores", description = "Bayi master data (store-service)")
public class StoreController {

	private final StoreApplicationService storeService;

	public StoreController(StoreApplicationService storeService) {
		this.storeService = storeService;
	}

	@GetMapping
	@Operation(summary = "Bayileri listeler", description = """
			Üç sorgu şekli:
			1) Parametresiz → tüm bayiler
			2) ?ids=1,5,9 → toplu ID sorgusu (stock/capability servisleri için)
			3) ?city=&district= → bölgesel filtre
			""")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Bayi listesi (boş olabilir)"),
			@ApiResponse(responseCode = "400", description = "Geçersiz parametre")
	})
	public List<StoreResponse> getStores(
			@RequestParam(required = false) String ids,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String district) {
		if (ids != null && !ids.isBlank()) {
			return storeService.getStoresByIds(StoreApplicationService.parseIds(ids));
		}
		if ((city != null && !city.isBlank()) || (district != null && !district.isBlank())) {
			return storeService.getStoresByRegion(city, district);
		}
		return storeService.getAllStores();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Tek bayi detayı")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Bayi bulundu"),
			@ApiResponse(responseCode = "404", description = "Bayi bulunamadı"),
			@ApiResponse(responseCode = "400", description = "Geçersiz ID")
	})
	public StoreResponse getStoreById(
			@PathVariable @Positive(message = "Bayi ID değeri pozitif olmalıdır") Long id) {
		return storeService.getStoreById(id);
	}
}
