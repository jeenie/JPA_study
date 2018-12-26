package net.skhu.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="purchase_order_details")
public class PurchaseOrderDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	Double quantity;

	@Column(name = "unit_cost")
	Double unitCost;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	Product product;
	
	@ManyToOne
	@JoinColumn(name="purchase_order_id")
	PurchaseOrder purchaseOrder;
}
