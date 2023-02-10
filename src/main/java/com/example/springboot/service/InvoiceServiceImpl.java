package com.example.springboot.service;

import com.example.springboot.businesslogic.VerifyInvoiceAccountNumber;
import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.domain.model.Invoice;
import com.example.springboot.domain.model.Item;
import com.example.springboot.outcall.db.entity.InvoiceEntity;
import com.example.springboot.outcall.db.entity.ItemEntity;
import com.example.springboot.outcall.db.entity.TypeItemEntity;
import com.example.springboot.outcall.db.repository.InvoiceRepository;
import com.example.springboot.outcall.db.repository.TypeItemRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//TODO Coding Junit test
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final VerifyInvoiceAccountNumber verifyInvoiceAccountNumber;
	private final TypeItemRepository typeItemRepository;

	@Override
	public void createInvoice(Invoice invoice) throws ExampleApiException {
		verifyInvoiceAccountNumber.verifyInvoiceAccountNumber(invoice);

		InvoiceEntity invoiceEntity = createInvoiceEntity(invoice);
		invoiceRepository.save(invoiceEntity);
	}

	private InvoiceEntity createInvoiceEntity(Invoice invoice) throws ExampleApiException {
		List<ItemEntity> itemsEntityList = new ArrayList<>();
		// TODO Coding mapper
		for (Item item : invoice.getItems()) {
			TypeItemEntity typeEnumEntity =
					typeItemRepository.getTypeItemEntityByName(item.getType().name());
			if (typeEnumEntity == null) {
				throw new ExampleApiException(); // "Type not found"
			}
			ItemEntity itemEntity =
					ItemEntity.builder()
							.name(item.getName())
							.price(item.getPrice())
							.idType(typeEnumEntity)
							.build();
			itemsEntityList.add(itemEntity);
		}

		return InvoiceEntity.builder()
				.numAccount(invoice.getNumAccount())
				.itemEntities(new HashSet<>((itemsEntityList)))
				.build();
	}
}
