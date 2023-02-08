package com.example.springboot.service;

import com.example.springboot.businesslogic.VerifyInvoiceAccountNumber;
import com.example.springboot.domain.exceptions.ExampleApiException;
import com.example.springboot.domain.model.Invoice;
import com.example.springboot.domain.model.Item;
import com.example.springboot.outcall.db.entity.InvoiceEntity;
import com.example.springboot.outcall.db.entity.ItemEntity;
import com.example.springboot.outcall.db.entity.TypeEnumEntity;
import com.example.springboot.outcall.db.repository.InvoiceRepository;
import com.example.springboot.outcall.db.repository.TypeEnumRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//TODO Coding Junit test
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final VerifyInvoiceAccountNumber verifyInvoiceAccountNumber;
	private final TypeEnumRepository typeEnumRepository;

	@Override
	public void createInvoice(Invoice invoice) throws ExampleApiException {
		verifyInvoiceAccountNumber.verifyInvoiceAccountNumber(invoice);

		invoiceRepository.save(createInvoiceEntity(invoice));
	}

	private InvoiceEntity createInvoiceEntity(Invoice invoice) throws ExampleApiException {
		List<ItemEntity> itemsEntityList = new ArrayList<>();
		// TODO Coding mapper
		for (Item item : invoice.getItems()) {
			TypeEnumEntity typeEnumEntity =
					typeEnumRepository.getTypeEnumEntityByNameTypeEnum(item.getType().name());
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
				.items(itemsEntityList)
				.build();
	}
}
