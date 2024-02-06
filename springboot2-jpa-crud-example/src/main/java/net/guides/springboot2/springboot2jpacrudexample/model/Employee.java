package net.guides.springboot2.springboot2jpacrudexample.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String itemName;
	private int Quantity;
	private int price;
	
	private int Total;
	private String emailId;
	
	
	
	
	public Employee() {
		
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EmployeeDetails_id")
	private  EmployeeDetails empDetils; 
	

	

	public EmployeeDetails getEmpDetils() {
		return empDetils;
	}




	public void setEmpDetils(EmployeeDetails empDetils) {
		this.empDetils = empDetils;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}



	public int getTotal() {
		return Total;
	}



	public void setTotal(int total) {
		Total = total;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", itemName=" + itemName + ", Quantity=" + Quantity + ", price=" + price
				+ ", Total=" + Total + ", emailId=" + emailId + "]";
	}
	
	



	
	

	
	
	
	
	
	
	
}

//===========================================
//export class Employee {
//	  id: number;
//	  itemName: string;
//	  Quantity: number;
//	  price: number;
//	  Total: number;
//	  emailId: string;
//	  empDetils: EmployeeDetails;
//
//	  constructor() {
//	  }
//	}
//
//	export class EmployeeDetails {
//	  // Define properties for EmployeeDetails if needed
//	}

//export class EmployeeDetails {
//	  id?: number;
//	  employeeDetails_Id?: string;
//	  Street?: string;
//	  State?: string;
//
//	  constructor() {
//	    // Initialize properties if needed
//	  }
//	}
//===============================
//<h3>Create Employee</h3>
//<div [hidden]="submitted" style="width: 400px;">
// <form (ngSubmit)="onSubmit()">
//   <div class="form-group">
//     <label for="name">itemName</label>
//     <input type="text" class="form-control" id="itemName" required [(ngModel)]="employee.itemName" name="itemName">
//   </div>
//
//   <div class="form-group">
//     <label for="name">quantity</label>
//     <input type="text" class="form-control" id="quantity" required [(ngModel)]="employee.quantity" name="quantity">
//   </div>
//
//   <div class="form-group">
//     <label for="name">price</label>
//     <input type="text" class="form-control" id="price" required [(ngModel)]="employee.price" name="price">
//   </div>
//
//   <div class="form-group">
//     <label for="name">emailId</label>
//     <input type="text" class="form-control" id="emailId" required [(ngModel)]="employee.emailId" name="emailId">
//   </div>
//
//   <button type="submit" class="btn btn-success">Submit</button>
// </form>
//</div>
//
//<div [hidden]="!submitted">
// <h4>You submitted successfully!</h4>
// <!-- <button class="btn btn-success" (click)="newEmployee()">Add</button> -->
//</div>



